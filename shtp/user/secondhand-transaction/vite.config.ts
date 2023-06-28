import { ConfigEnv, UserConfigExport, loadEnv } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'
// 引入 svg 矢量图需要用到的插件
import { createSvgIconsPlugin } from 'vite-plugin-svg-icons'
// mock 插件提供方法
import { viteMockServe } from 'vite-plugin-mock'

export default ({ command, mode }: ConfigEnv): UserConfigExport => {
  // 获取各种环境下的环境变量
  const env = loadEnv(mode, process.cwd());
  return {
    resolve: {
      alias: {
        "@": path.resolve("./src") // 相对路径别名配置，使用 @ 代替 src
      }
    },
    plugins: [
      vue(),
      // 让 svg 矢量图能够被直接使用
      createSvgIconsPlugin({
        // Specify the icon folder to be cached
        iconDirs: [path.resolve(process.cwd(), 'src/assets/icons')],
        // Specify symbolId format
        symbolId: 'icon-[dir]-[name]',
      }),
      viteMockServe({
        mockPath: './src/mock',
        // 保证开发阶段可以使用 mock 接口
        localEnabled: command === 'serve',  
      }),
    ],
    // scss 全局变量的配置
    /* css: {
      preprocessorOptions: {
        scss: {
          javascriptEnabled: true,
          additionalData: '@import "./src/styles/variables.module.scss";',
        },
      },
    }, */
    // 代理跨域
    /* server: {
      proxy: {
        [env.VITE_APP_BASE_API]: {
          // 获取数据的服务器地址
          target: env.VITE_APP_URL,
          // 路径重写
          rewrite: path => path.replace(/^\/(.{0,20}-)?api/, ''),
          // 需要代理跨域
          changeOrigin: true,
        }
      }
    } */
  }
}
