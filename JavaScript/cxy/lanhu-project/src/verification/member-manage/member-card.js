const rules = {
  card_type: [
    { required: true, message: '请选择会员卡类型', },
    { pattern: /^.{2,5}$/gi, message: '请不要修改已定义的数据' }
  ],
  title: [
    { required: true, message: '请填写标题', trigger: 'blur' },
    { pattern: /^.{2,100}$/gi, message: '请将标题字数控制在 2 到 100 之间', trigger: 'blur'}
  ],
  price: [
    { required: true, message: '请填写价格', trigger: 'blur'},
    { validator: (rule, value, callback) => {
      if (!/^\d{1,18}(.\d{1,18})?$/.test(value) || value.length > 14) {
        callback(new Error('请控制价格的增长'));
      } else {
        callback();
      }
    }, message: '请控制价格的增长', trigger: 'blur'}
  ],
  card_day: [
    { required: true, message: '请填写天数', trigger: 'blur'},
    { pattern: /^\d{1,10}$/gi, message: '请控制天数的增长', trigger: 'blur'}
  ],
  status: [
    { required: true },
  ]
}

export default rules;