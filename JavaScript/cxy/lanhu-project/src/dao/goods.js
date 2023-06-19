import { MessageBox, Message } from "element-ui";
function selectPage(vue,callback){
  vue.listLoading=true;
  let { name, pageSize, pageNum } = vue.$route.query
  if (name) vue.name=name;else name=vue.name;
  if (pageSize) vue.pageSize=+pageSize;else pageSize=+vue.pageSize;
  if (pageNum) vue.pageNum=+pageNum;else pageNum=+vue.pageNum;
  name=name||'%%';pageSize=+pageSize||0;pageNum=+pageNum||0;
  console.log('name',name)
  console.log('pageSize', pageSize)
  console.log('pageNum',pageNum)
  pageNum=(pageNum-1)*pageSize;
  vue.$axios.get(vue.sendRequestUrl({name,pageNum,pageSize})).then((res)=>{
    if (callback){
      callback(res.data);
    }else{
      vue.tableData=res.data;
    }
    vue.listLoading=false;
  }).catch (err => {
    vue.listLoading = false;
    console.log(err);
  });
}
function selectAll(vue,callback){
  vue.listLoading=true;
  vue.$axios.get('/goods/getAll').then((res)=>{
    if (callback){
      callback(res.data);
    }else{
      vue.tableData=res.data;
    }
    vue.listLoading=false;
  }).catch (err => {
    vue.listLoading = false;
    console.log(err);
  });
}
function del(vue,goodsId){
  vue.listLoading=true;
  vue.$axios.delete(`/goods/delete/${goodsId}`).then((res)=>{
    vue.listLoading=false;
    // this.$axios.get(`/goods/getNameAll?name=${this.name}`).then((res)=>{
    //   this.count=res.data.length;
    //   this.pageNum=1;
    //   selectPage(this,(res)=>{
    //     console.log('res',res)
    //     this.tableData=res;
    //   })
    // }).catch((err)=>{
    //   console.log(err)
    // })

    selectPage(vue,(res)=>{
      vue.$axios.get(`/goods/getNameAll?name=${vue.name}`).then((res) => {
        vue.count=res.data.length;
      }).catch((err) => {
        console.log(err)
      })
      if(--vue.count%vue.pageSize===0){
        if(!((vue.pageNum-1)<=0)){
          vue.pageNum--;
        }
      }
      selectPage(vue,(res)=>{
        vue.tableData=res;
      })
      console.log('pageNum1',vue.pageNum)
    })

  }).catch (err => {
    console.log(err);
  });
}
export {
  selectAll,
  selectPage,
  del
}
