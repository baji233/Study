package hut.tyt.monitor;

import hut.tyt.adaptor.MouseAdaptor;
import hut.tyt.mapper.InformationMapper;
import hut.tyt.pojo.Information;
import hut.tyt.utils.SqlSessionUtils;
import hut.tyt.view.Login;
import hut.tyt.view.MainFace;
import org.apache.ibatis.session.SqlSession;

import java.awt.event.MouseEvent;

/**
 * 登入按钮监听器
 * @author 小飞侠 ysrazxy@foxmail.com
 * @version 1.0 JDK 13.0.1
 * @BelongsProject: EmpControl
 * @BelongsPackage: hut.tyt.monitor
 * @CreateTime: 2022-08-08  09:13
 * @Description: TODO
 */
public class LoginMonitor extends MouseAdaptor {
//    由于监听器和登入页面不在同一个类中，想要和登入页面中的部件通信，需要在监听器类中有一个页面属性
    Login login;

    public LoginMonitor(Login login) {
        this.login = login;
    }

    @Override
    public void mouseClicked(MouseEvent e){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        InformationMapper mapper = sqlSession.getMapper(InformationMapper.class);
//        获取ID
        Integer id = Integer.valueOf(login.jTextField2.getText());
//        通过主键ID查询
        Information information = mapper.selectByPrimaryKey(id);
//        判断管理员是否存在
        if (information == null){
            login.jTextField3.setText("管理员不存在");
            return;
        }
//        获取账号
        Integer number = Integer.valueOf(login.jTextField.getText());
//        获取密码
        Integer password = Integer.valueOf(login.jTextField1.getText());
//        判断账号密码是否与数据库中infomation表中数据相同
        if (information.getNumber().equals(number) && information.getPassword().equals(password)){
            login.jTextField3.setText("登入成功");
        } else {
            login.jTextField3.setText("账号或密码错误");
        }
    }
}
