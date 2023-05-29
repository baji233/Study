function select(vue, callback) {
  let ps = +sessionStorage.getItem('myRechargePageSize') || 5;
  let {cp} = vue.$route.query;

  cp = parseInt(cp) || 1;

  vue.listLoading = true;
  vue.$axios.get(vue.sendReqestUrl({ps, cp})).then(result => {
    if (callback) {
      callback(result);
    } else {
      vue.tableData = result.data;
    }
    vue.listLoading = false;
  }).catch (err => { 
    vue.listLoading = false;
    console.log(err);
   });
}

// count 和搜索一样，只是少了一些请求时的参数，这些参数可以不带，但是会无法分页，
// 而且这些参数是地址栏上的 query 参数，只要点击了就会自动获取
function count(vue, callback) {

  vue.$axios.get(`/my-recharge/count`).then(result => {
    if (callback) {
      callback(result);
    } else {
      vue.count = result.data;
    }
  }).catch(err => {
    console.log(err);
  });
}

export const myRechargeSelect = select;

export { select, count}

export default {
select, count
}