console.log(1);
async function fun1(){
  console.log(6);
  await fun2()  
  console.log(7);
}
setTimeout(()=>{
  console.log(9);
},0)
async function fun2(){
  new Promise((resolve)=>{
    console.log(2);
    resolve(3)
    setTimeout(()=>{
      console.log(4);
    },0)
  }).then((data)=>{
    console.log(data)
  }).then(()=>{
    console.log(5);
  })
}
fun1()
console.log(8);
