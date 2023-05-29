import { MessageBox, Message } from "element-ui";
// 查询 member_card 表，需要一个参数，vue是在组件中调用时的this，
// callback是一个可选值，没有的话就直接把查询的值赋值给 表格的tableData(数据)
function select(vue, callback) {
  let ps = +sessionStorage.getItem('lostListPageSize') || 5;
  let {w, cp} = vue.$route.query;

  if (w) {
    vue.w = w;
  } else {
    w = vue.w;
  }

  cp = parseInt(cp) || 1;

  vue.listLoading = true;
  vue.$axios.get(vue.sendReqestUrl({ps, cp, w})).then(result => {
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
  let {w} = vue.$route.query;
  if (w) {
    vue.w = w;
  } else {
    w = vue.w;
  }
  w = w || '';
  vue.$axios.get('/lost-list/count?w='+ w).then(result => {
    if (callback) {
      callback(result);
    } else {
      vue.count = result.data;
    }
  }).catch(err => {
    console.log(err);
  });
}

// 传入vue的实例对象，并且传入一个需要删除的ID，callback 为可选值
function delLostList(vue, lost_id, callback) {  
  MessageBox.confirm('是否删除该失物信息', '警告', {
    type: 'warning',
    confirmButtonText: '确定',
    cancelButtonText: '取消',
  }).then(result => {
    vue.$axios.delete(`/lost-list/delete/${lost_id}`).then(result => {
      if (callback) {
        callback(result);
      } else {
        Message({ 
          type: 'success',
          message: '删除成功',
          showClose: true
        });
        const { query, name } = vue.$route;
        if (vue.tableData.length === 1 && +query.cp > 1) {
          vue.$router.push({
            name,
            query: { ...query, cp: query.cp - 1 }
          });
        }
        if (vue.claimMap.has(lost_id)) {
          vue.claimMap.delete(lost_id);
        }
        vue.handleBeforeunload(() => {
          vue.count --;
          vue.$bus.$emit('callFunc', [select]);
        });
      }
    });
  }).catch(err => { console.log( err); });
}

// 传入 vue 的实例对象，并且需要增加的数据源，callback 为可选值
function add(vue, data, callback) {
  vue.$axios.post('/lost-list/add', data).then(result => {
    if (callback) {
      return callback(result);
    }
    Message({
      type: 'success',
      message: '成功添加一个失物',
      showClose: true
    });
    vue.resetForm('form');
    vue.dialogVisible = false;
    vue.$bus.$emit('callFunc', [select]);
    vue.$bus.$emit('setCount', true);
  }).catch(err => {
    console.log(err);
    Message({
      type: 'error',
      message: '此次添加失物失败',
      showClose: true
    });
  });
}

function update(vue, data, callback) {
  vue.$axios.put('/lost-list/update', data).then(result => {
    if (callback) {
      return callback(result);
    }
    Message({
      type: 'success',
      message: '修改成功',
      showClose: true
    });
    vue.resetForm('form');
    vue.$bus.$emit('callFunc', [select]);
    vue.dialogVisible = false;
  }).catch(err => {
    console.log(err);
    Message({
      type: 'error',
      message: '此次修改失败，请稍后重试',
      showClose: true
    });
  });
}

export const lostListSelect = select;
export const lostListCount = count;
export const lostListAdd = add;
export const lostListUpdate = update;

export { select, count, delLostList, add, update,  }

export default {
  select,
  count,
  delLostList,
  add,
  update,
  
}

