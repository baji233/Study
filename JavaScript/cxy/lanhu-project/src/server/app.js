const bodyParser = require('body-parser');
const express = require('express');
// 引入创建 token 的文件
const jwt = require('jsonwebtoken');
// 引入链接数据库文件
const { singleSql } = require('./db');
// 引入 cookie
const cookie = require('cookie-parser');
const code = require('svg-captcha');
// 引入路由文件

const getAll = require('./routes/getAll');
const mySystem = require('./routes/system/employee/index.js')
const myRole = require('./routes/system/role/index.js')
const memberCardRouter = require('./routes/member-manage/member_card');
const memberManageRouter = require('./routes/member-manage/member_manage');
const myRechargeRouter = require('./routes/member-manage/my_recharge');
const lostListRouter = require('./routes/lost-found/lost');
const feedbackListRouter = require('./routes/feedback-manage/feedback_list');
const goodsRouter=require('./routes/goods')
const goodsOrderRouter=require('./routes/goods_order');
const ordersRouter = require('./routes/shangpingguanli/dingdangguanli');
// 校验 token
const verifyToken = (verifyIdentity, name) => {
  return new Promise((resolve, reject) => {
    jwt.verify(verifyIdentity, name,
      (err, data) => err ? reject(err) : resolve(data));
  });
}
const app = express();
app.use('/public',express.static('./public/upload'))
// 加载 cookie
app.use(cookie());
// 加载请求体对象
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

// 设置跨域和相应数据格式
app.all('*', async function (req, res, next) {
  const { method, url, cookies, headers } = req;
  res.header('Access-Control-Allow-Origin', headers.origin);
  res.header('Access-Control-Allow-Headers', 'X-Requested-With, mytoken')
  res.header('Access-Control-Allow-Headers', 'X-Requested-With, Authorization')
  res.setHeader('Content-Type', 'application/json;charset=utf-8')
  res.header('Access-Control-Allow-Headers', 'Content-Type,Content-Length, Authorization, Accept,X-Requested-With')
  res.header('Access-Control-Allow-Methods', 'PUT,POST,GET,DELETE,OPTIONS');
  res.setHeader('Access-Control-Allow-Credentials', 'true');
  res.header('X-Powered-By', ' 3.2.1');
  // 让options请求快速返回
  if (method == 'OPTIONS') res.send(200);
  else {
    console.log(`${req.get('host')}发来了一个${method}请求，请求路径为${url}`);
    next();
  }
});

function createCode() {
  return code.create({
    size: 4,
    ignoreChars: "0o1iIl",
    noise: 5,
    color: true,
    background: "#fff",
    fontSize: 60
  })
}
//验证码图片
app.get('/code', (req, res) => {
  let code = createCode();
  res.type('svg')
  res.status(200).send(code.data);
  res.end();
})

//登录
app.post('/login', (req, res) => {
  delete req.body.code;
  let sql = `select * from sys_user where username = ? and password = ? and user_type = ?`;
  singleSql(sql, Object.values(req.body)).then(result => {
    if (result.length == 0) {
      res.status(400).send('登录失败，账号或密码错误');
    } else {
      res.status(200).send(result);
    }
  }).catch(err => {
    console.log(err);
    res.status(500).send('登录超时');
  })
})

app.use('/home', getAll);
app.use('/member-card', memberCardRouter);
app.use('/member-manage', memberManageRouter);
app.use('/my-recharge', myRechargeRouter);
app.use('/my-system', mySystem)
app.use('/my-role', myRole)
app.use('/lost-list', lostListRouter);
app.use('/feedback-list', feedbackListRouter);
app.use('/goods',goodsRouter);
app.use('/goods_order',goodsOrderRouter);
app.use('/shangpingguanli', ordersRouter);

app.listen(5000, err => {
  console.log('服务已开启，端口5000正在监听');
});
