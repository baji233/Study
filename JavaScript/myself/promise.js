// //使用Promise实现计时器(函数瀑布)
// new Promise((resolve, reject) => {
//     setTimeout(() => {
//         console.log('1');
//         resolve();
//     }, 1000);
// }).then(() => {
//     return new Promise((resolve, reject) => {
//         setTimeout(() => {
//             console.log('2');
//             resolve();
//         },4000);
//     });
// }).then(() => {
//     return new Promise((resolve, reject) => {
//         setTimeout(() => {
//             console.log('3');
//         },2000);
//     });
// });



// //异步操作(Promise构造函数)
// const PROMISE = new Promise((resolve, reject) => {
//     setTimeout(() => {
//         if(Math.random() < 0.5){
//             resolve('success');
//         }else{
//             reject('fail');
//         }
//     },1000);
// });

// PROMISE.then(resolve => {
//     console.log(resolve);
// }).catch(reject => {
//     console.log(reject);
// }).finally(() => {
//     console.log('结束');
// });



// //被除数不能为零
// new Promise((resolve, reject) => {
//     var a = 4;
//     var b = 0;
//     if(b == 0){
//         reject('被除数不能为零');
//     }else{
//         resolve(a / b);
//     }
// }).then(value => {
//     console.log('a / b = ' + value);
// }).catch(error => {
//     console.log(error);
// }).finally(() => {
//     console.log('结束');
// });



// //一个用Promise实现计时器功能的函数
// function timer(delay, message) {
//     return new Promise((resolve, reject) => {
//         setTimeout(() => {
//             console.log(message);
//             resolve();
//         },delay);
//     });
// }

// timer(1000, '1').then(() => {
//     return timer(4000, '2');
// }).then(() => {
//     timer(2000, '3');
// });

// //另一种方法是来使用async实现Promise
// async function asyncFun() {
//     await timer(5000, '1');
//     await timer(2000, '2');
//     await timer(3000, '3');
// }
// asyncFun();



// //async的reject异常处理
// async function asyncFun() {
//     try{
//         await new Promise((resolve, reject) => {
//             // resolve('DaiDaiCat');
//             throw 'a new error';
//         }).then(value => {
//             console(value);
//         });
//     } catch(err) {
//         console.log(err);
//     } finally {
//         console.log('end');
//     }
// }
// asyncFun();


