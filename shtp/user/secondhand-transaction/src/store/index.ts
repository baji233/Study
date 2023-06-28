import {createPinia} from 'pinia';
// 大仓库
const pinia = createPinia();

// 引入小仓库
import useAppStore from './modules/app';
export const appStore = useAppStore(pinia);

// 登录、注册、退出登录的小仓库
import useAdminUserStore from './modules/user';
export const adminUserStore = useAdminUserStore(pinia); 

// 设置页面的小部分 logo 的仓库
import useSettingsStore from './modules/settings';
export const settingsStore = useSettingsStore(pinia);

export default pinia;