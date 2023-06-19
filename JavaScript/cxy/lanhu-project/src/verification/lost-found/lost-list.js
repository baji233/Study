const rules = {
  lost_name: [
    { required: true, message: '请填写物品名称', trigger: 'blur'},
    { pattern: /^.{1,64}$/gs, message: '物品名称的字数在 1 到 64 之间', trigger: 'blur' }
  ],
  found_addres: [
    { required: true, message: '请填写拾取地址', trigger: 'blur'},
    { pattern: /^.{1,128}$/gs, message: '拾取地址的字数在 1 到 64 之间', trigger: 'blur' }
  ],
  found_person: [
    { required: true, message: '请填写拾取人', trigger: 'blur'},
    { pattern: /^.{1,36}$/gs, message: '请填写正确的名字', trigger: 'blur'}
  ],
  found_phone: [
    { required: true, message: '请填写联系电话', trigger: 'blur'},
    { pattern: /^1[3-9]\d{9}$/, message: '请填写正确的手机号', trigger: 'blur' }
  ],
  found_time: [
    {required: true, message: '请选择拾取时间', trigger: 'blur'}
  ],
  status: [
    { required: true },
  ]
}

export default rules;