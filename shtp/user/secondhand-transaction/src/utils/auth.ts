import Cookies from 'js-cookie';

const secondhand_transaction = 'secondhand-transaction';

// 获取 token
export function getToken(){ 
  return Cookies.get(secondhand_transaction);
}

// 设置 token
export function setToken(token: string){
  Cookies.set(secondhand_transaction, token);
}

// 移除 token
export function removeToken(){
  Cookies.remove(secondhand_transaction);
}