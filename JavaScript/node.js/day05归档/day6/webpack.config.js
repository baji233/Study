const path = require('path');

module.exports = {

    mode: 'development' ,
    entry: path.join(__dirname,'./src/index.js'),
    output: {
        path: path.join(__dirname,'./dist'),
        filename: 'bundle.js',  //不改默认叫 main.js    
    },
    devServer:{
        static: './src'
    },
    module:{
        rules:[
            {test:/\.css$/, use:['style-loader','css-loader']},
            {test:/\.less$/, use:['style-loader','css-loader','less-loader']}          
        ]
    }

}
