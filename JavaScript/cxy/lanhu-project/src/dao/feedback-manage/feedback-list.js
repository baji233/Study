import { MessageBox, Message } from "element-ui";
function select(vue, callback) {
  let ps = +sessionStorage.getItem('feedbackListPageSize') || 5;
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
  vue.$axios.get('/feedback-list/count?w='+ w).then(result => {
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
function delFeedbackList(vue, id, callback) {  
  MessageBox.confirm('是否删除该反馈信息', '警告', {
    type: 'warning',
    confirmButtonText: '确定',
    cancelButtonText: '取消',
  }).then(result => {
    vue.$axios.delete(`/feedback-list/delete/${id}`).then(result => {
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
        vue.count --;
        vue.$bus.$emit('callFunc', [select]);
      }
    });
  }).catch(err => { console.log( err); });
}

// 传入 vue 的实例对象，并且需要增加的数据源，callback 为可选值
function add(vue, data, callback) {
  vue.$axios.post('/feedback-list/add', data).then(result => {
    if (callback) {
      return callback(result);
    }
    Message({
      type: 'success',
      message: '成功添加一条反馈',
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
      message: '此次添加反馈信息失败',
      showClose: true
    });
  });
}

function update(vue, data, callback) {
  vue.$axios.put('/feedback-list/update', data).then(result => {
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

export const feedbackListSelect = select;
export const feedbackListCount = count;
export const feedbackListAdd = add;
export const feedbackListUpdate = update;

export { select, count, delFeedbackList, add, update,  }

export default {
  select,
  count,
  delFeedbackList,
  add,
  update,
  
}

