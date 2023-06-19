const rules = {
  title: [
    { required: true, message: '请填写反馈标题', trigger: 'blur'},
    { pattern: /^.{1,200}$/gs, message: '反馈标题的字数在 1 到 64 之间', trigger: 'blur' }
  ],
  content: [
    { required: true, message: '请填写反馈内容', trigger: 'blur'},
    { pattern: /^.+$/s, message: '反馈内容的字数在 1 到 ? 之间', trigger: 'blur' }
  ],
}

export default rules;