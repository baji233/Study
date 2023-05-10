var path = require('path'); //分析文件路径

//导出一个json文件
module.exports = {

    mode: 'development',

    //修改输出的打包文件
    entry: path.join(__dirname, './src/index.js'),
    output: {
        path: path.join(__dirname, './dist'),
        filename: 'bundle.js', //不改名字的话,默认叫main.js
    },

    //自动打包,类似于热部署
    devServer: {
        static: './src'
    },

    //css文件的打包配置
    //less文件的打包配置
    module : {
        rules : [
            {test:/\.css$/, use : ['style-loader','css-loader']},
            {test:/\.less$/, use : ['style-loader','css-loader','less-loader']}
        ]
    }

}