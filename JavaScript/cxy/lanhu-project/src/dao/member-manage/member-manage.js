import { MessageBox, Message } from "element-ui";
// 查询 member_card 表，需要一个参数，vue是在组件中调用时的this，
// callback是一个可选值，没有的话就直接把查询的值赋值给 表格的tableData(数据)
function select(vue, callback) {
  let ps = +sessionStorage.getItem('memberManagePageSize') || 5;
  let { n, p, m, cp } = vue.$route.query;

  if (n) vue.n = n; else n = vue.n;
  if (p) vue.p = p; else p = vue.p;
  if (m) vue.m = m; else m = vue.m;
  n = n || ''; p = p || ''; m = m || '';
  cp = parseInt(cp) || 1;

  vue.listLoading = true;
  vue.$axios.get(vue.sendReqestUrl({ ps, cp, n, p, m })).then(result => {
    if (callback) {
      callback(result);
    } else {
      vue.tableData = result.data;
    }
    vue.listLoading = false;
  }).catch(err => {
    vue.listLoading = false;
    console.log(err);
  });
}

// count 和搜索一样，只是少了一些请求时的参数，这些参数可以不带，但是会无法分页，
// 而且这些参数是地址栏上的 query 参数，只要点击了就会自动获取
function count(vue, callback) {
  let { p, n, m } = vue.$route.query;

  if (n) vue.n = n; else n = vue.n;
  if (p) vue.p = p; else p = vue.p;
  if (m) vue.m = m; else m = vue.m;
  n = n || ''; p = p || ''; m = m || '';

  vue.$axios.get(`/member-manage/count?n=${n}&p=${p}&m=${m}`).then(result => {
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
function delMember(vue, {member_id, name}, callback) {
  MessageBox.confirm(`是否删除[${name}]会员`, '警告', {
    type: 'warning',
    confirmButtonText: '确定',
    cancelButtonText: '取消',
  }).then(result => {
    vue.$axios.delete(`/member-manage/delete/${member_id}`).then(result => {
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
        // 如果重置密码时，这个对象已经被删除了，那么就不需要再重置该对象的密码
        if (vue.passwordMap.has(member_id)) {
          vue.passwordMap.delete(member_id);
        }
        if (vue.doCardMap.has(member_id)) {
          vue.doCardMap.delete(member_id);
        }
        if (vue.rechargeMap.has(member_id)) {
          vue.rechargeMap.delete(member_id);
        }
        vue.handleBeforeunload(() => {
          vue.$bus.$emit('callFunc', [select]);
          vue.count--;
        });
      }
    });
  }).catch(err => { console.log(err); });
}

// 传入 vue 的实例对象，并且需要增加的数据源，callback 为可选值
function add(vue, data, callback) {
  vue.$axios.post('/member-manage/add', data).then(result => {
    if (callback) {
      return callback(result);
    }
    Message({
      type: 'success',
      message: '成功添加一位会员',
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
      message: '此次添加会员失败',
      showClose: true
    });
  });
}

function update(vue, data, callback) {
  vue.$axios.put('/member-manage/update', data).then(result => {
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

export const memberSelect = select;
export const memberCount = count;
export const memberAdd = add;
export const memberUpdate = update;

export { select, count, delMember, add, update }

export default {
  select,
  count,
  delMember,
  add,
  update,
}

