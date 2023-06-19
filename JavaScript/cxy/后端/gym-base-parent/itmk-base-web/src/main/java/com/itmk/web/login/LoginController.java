package com.itmk.web.login;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.itmk.jwt.JwtUtils;
import com.itmk.utils.ResultUtils;
import com.itmk.utils.ResultVo;
import com.itmk.web.member.entity.Member;
import com.itmk.web.member.service.MemberService;
import com.itmk.web.sys_menu.entity.MakeMenuTree;
import com.itmk.web.sys_menu.entity.RouterVO;
import com.itmk.web.sys_menu.entity.SysMenu;
import com.itmk.web.sys_menu.service.SysMenuService;
import com.itmk.web.sys_user.entity.SysUser;
import com.itmk.web.sys_user.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private MemberService memberService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    //生成验证码
    @PostMapping("/image")
    public ResultVo imageCode(HttpServletRequest request) {
        //生成验证码
        String text = defaultKaptcha.createText();
        //把生成的验证码存到session里面
        HttpSession session = request.getSession();
        session.setAttribute("code", text);

        System.out.println("============================================后台生成验证码后存入session: "+ session.getAttribute("code"));

        //生成图片,转换为base64
        BufferedImage bufferedImage = defaultKaptcha.createImage(text);
        ByteArrayOutputStream outputStream = null;
        try {
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", outputStream);
            BASE64Encoder encoder = new BASE64Encoder();
            String base64 = encoder.encode(outputStream.toByteArray());
            String captchaBase64 = "data:image/jpeg;base64," + base64.replaceAll("\r\n", "");
            ResultVo result = new ResultVo("生成成功", 200, captchaBase64);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @PostMapping("/login")
    public ResultVo login(HttpServletRequest request, @RequestBody LoginParm parm) {
        if (StringUtils.isEmpty(parm.getUsername()) || StringUtils.isEmpty(parm.getPassword()) || StringUtils.isEmpty(parm.getUserType()) || StringUtils.isEmpty(parm.getCode())) {
                return ResultUtils.error("用户名、密码、验证码或用户类型不能为空!");
            }
            //获取session
            HttpSession session = request.getSession();
        //获取验证码
            String code = (String) session.getAttribute("code");
        System.out.println("============================================获取session中保存的验证码: "+ code);
        System.out.println("============================================用户提交的表单: "+ parm.getUsername() + "," + parm.getUserType() + "," + parm.getPassword() + "," + parm.getCode());


//        if (StringUtils.isEmpty(code)) {
//                return ResultUtils.error("验证码过期,请刷新验证码!");
//            }
//            //验证验证码
//            if (!code.equals(parm.getCode())) {
//                return ResultUtils.error("验证码错误!");
//            }

            String password = passwordEncoder.encode(parm.getPassword());
            //构造spring security需要的token
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(parm.getUsername() + ":" + parm.getUserType(), parm.getPassword());
            Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            //用户类型判断
            if (parm.getUserType().equals("1")) { //会员
                Member user = (Member) authenticate.getPrincipal();
                //生成token
                Map<String, String> map = new HashMap<>();
                map.put("userId", Long.toString(user.getMemberId()));
                map.put("username", user.getUsername());
                map.put("userType", parm.getUserType());
                String token = jwtUtils.generateToken(map);
                //返回登录成功信息
                LoginResult result = new LoginResult();
                result.setToken(token);
                result.setUserId(user.getMemberId());
                result.setUsername(user.getName());
                result.setUserType(parm.getUserType());
                return ResultUtils.success("登录成功", result);
            } else if (parm.getUserType().equals("2")) { //员工
                SysUser user = (SysUser) authenticate.getPrincipal();
                //生成token
                Map<String, String> map = new HashMap<>();
                map.put("userId", Long.toString(user.getUserId()));
                map.put("username", user.getUsername());
                map.put("userType", parm.getUserType());
                String token = jwtUtils.generateToken(map);
                System.out.println("======================================================================================Token: "+ token);
                //返回登录成功信息
                LoginResult result = new LoginResult();
                result.setToken(token);
                result.setUserId(user.getUserId());
                result.setUsername(user.getNickName());
                result.setUserType(parm.getUserType());
                return ResultUtils.success("登录成功", result);
            } else {
                return ResultUtils.error("用户类型错误!");
            }
    }

    //查询用户信息
    @GetMapping("/getInfo")
    public ResultVo getInfo(InfoParm parm) {
        UserInfo userInfo = new UserInfo();
        if (parm.getUserType().equals("1")) { //会员
            //根据会员id查询权限字段
            List<SysMenu> menuList = sysMenuService.getMenuByMemberId(parm.getUserId());
            //获取全部的code字段
            List<String> collect = Optional.ofNullable(menuList).orElse(new ArrayList<>())
                    .stream()
                    .map(item -> item.getCode())
                    .filter(item -> item != null)
                    .collect(Collectors.toList());
            //转为数组
            String[] strings = collect.toArray(new String[collect.size()]);
            //查询用户信息
            Member member = memberService.getById(parm.getUserId());
            //设置返回信息
            userInfo.setName(member.getName());
            userInfo.setUserId(member.getMemberId());
            userInfo.setPermissons(strings);
            return ResultUtils.success("查询成功", userInfo);
        } else if (parm.getUserType().equals("2")) { //员工
            //查询用户信息
            SysUser user = sysUserService.getById(parm.getUserId());
            List<SysMenu> menuList = null;
            if (StringUtils.isNotEmpty(user.getIsAdmin()) && user.getIsAdmin().equals("1")) { //超级管理员
                menuList = sysMenuService.list();
            } else {
                menuList = sysMenuService.getMenuByUserId(user.getUserId());
            }
            //获取全部的code字段
            List<String> collect = Optional.ofNullable(menuList).orElse(new ArrayList<>())
                    .stream()
                    .map(item -> item.getCode())
                    .filter(item -> item != null)
                    .collect(Collectors.toList());
            //转为数组
            String[] strings = collect.toArray(new String[collect.size()]);

            //设置返回信息
            userInfo.setName(user.getNickName());
            userInfo.setUserId(user.getUserId());
            userInfo.setPermissons(strings);
            return ResultUtils.success("查询成功", userInfo);
        } else {
            return ResultUtils.error("用户类型错误!");
        }
    }

    /**
     * 获取菜单数据
     *
     * @return
     */
    @GetMapping("/getMenuList")
    public ResultVo getMenuList(InfoParm parm) {
        if (parm.getUserType().equals("1")) { //会员
            List<SysMenu> menus = sysMenuService.getMenuByMemberId(parm.getUserId());
            //获取菜单和目录
            List<SysMenu> collect = Optional.ofNullable(menus).orElse(new ArrayList<>())
                    .stream()
                    .filter(item -> item != null && !item.getType().equals("2")).collect(Collectors.toList());
            List<RouterVO> rourer = MakeMenuTree.makeRourer(collect, 0L);
            return ResultUtils.success("查询成功", rourer);
        } else if (parm.getUserType().equals("2")) { //员工
            SysUser user = sysUserService.getById(parm.getUserId());
            List<SysMenu> menuList = null;
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(user.getIsAdmin()) && user.getIsAdmin().equals("1")) {
                menuList = sysMenuService.list();
            } else {
                menuList = sysMenuService.getMenuByUserId(parm.getUserId());
            }
            //获取菜单和目录
            List<SysMenu> collect = Optional.ofNullable(menuList).orElse(new ArrayList<>())
                    .stream()
                    .filter(item -> item != null && !item.getType().equals("2")).collect(Collectors.toList());
            List<RouterVO> rourer = MakeMenuTree.makeRourer(collect, 0L);
            return ResultUtils.success("查询成功", rourer);
        } else {
            return ResultUtils.error("用户类型错误!");
        }
    }

}
