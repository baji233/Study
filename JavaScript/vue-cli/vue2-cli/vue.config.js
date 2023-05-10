const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // 关闭语检查
  lintOnSave: false,
  // 将vue上传到tomcat服务器
  outputDir: 'taobao', //打包后的项目名为taobao
  publicPath: './'
})
