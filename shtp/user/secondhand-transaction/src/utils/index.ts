// 全局组件
import * as ElementPlusIcons from '@element-plus/icons-vue'
import SvgIcon from '@/components/SvgIcon/index.vue';

const components = [
  Object.entries(ElementPlusIcons),
  SvgIcon
];

export const registerComponent = {
  install(app: any){
    for (const component of components) {
      if(component instanceof Array) {
        for (const [key, item] of component) {
          app.component(key, item);
        }
      } else {
        app.component(component.name, component);
      }
    }
  }
}

export function isExternal(path: string) {
  return /^(https?:|mailto:|tel:)/.test(path)
}

// 是否大写字母
export function isUpperCaseLetter(letter: string = ''){
  return /^[A-Z]/.test(letter);
}

// 是否是图片
export function isImg(img: string){
  return /\.(gif|jpe?g|png|bmp|webp|heic|heif|raw)$/.test(img);
}