const rules = {
  name: [
    { required: true, message: '请填写您的姓名', trigger: 'blur' },
    { pattern: /^.{2,20}$/gi, message: '您的姓名至少 2 个字，至多 20 个', trigger: 'blur' }
  ],
  sex: [
    { required: true },
    { pattern: /^(true|false)$/gi, message: '请不要修改已定义的数据' }
  ],
  phone: [
    { required: true, message: '请填写您的电话', trigger: 'blur' },
    { pattern: /^1[3-9]\d{9}$/gi, message: '请填写正确的手机号', trigger: 'blur' }
  ],
  end_time: [
    { required: true, message: '请选择到期时间', trigger: 'blur' },
  ],
  height: [
    { validator: (rule, value, callback) => {
      if (+value < 20 && value !== null && value !== '') {
        callback(new Error('请填写身高'));
      } else if (value > 265) {
        callback(new Error('请重新填写身高'));
      } else {
        callback();
      }
    }, trigger: 'blur' }
  ],
  age: [
    { validator: (rule, value, callback) => {
      if (+value < 10 && value !== null && value !== '') {
        callback(new Error('年龄过小'));
      } else if (value > 120) {
        callback(new Error('年龄过大'));
      } else {
        callback();
      }
    }, trigger: 'blur' }
  ],
  weight: [
    { validator: (rule, value, callback) => {
      if (+value < 20 && value !== null && value !== '') {
        callback(new Error('请填写体重'));
      } else if (+value > 800) {
        callback(new Error('请重新填写体重'));
      } else {
        callback();
      }
    }, trigger: 'blur' }
  ],
  price: [
    { required: true, message: '请填写价格', trigger: 'blur'},
  ],
  status: [
    { required: true },
    { pattern: /^(true|false)$/gi, message: '请勿修改已定义的数据', trigger: 'blur'}
  ],
  username: [
    { required: true, message: '请填写会员卡号', trigger: 'blur' },
    { pattern: /^\d{6,60}$/gi, message: '请将会员卡号字数控制在 6 到 60 之间', trigger: 'blur'}
  ],
  password: [
    { required: true, message: '请填写密码', trigger: 'blur'},
    { pattern: /^\w{4,128}$/gi, message: '密码由数字、字母、下划线组成，且 4 到 128 字数之间', trigger: 'blur'}
  ]
}

export default rules;