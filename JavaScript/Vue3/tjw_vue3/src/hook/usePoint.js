import {onBeforeMount, onBeforeUnmount, reactive, ref} from 'vue'

export default function() {
    const point = reactive({
        x: 0,
        y: 0
    })
    // 点击鼠标查看相关坐标值
    function savePoint(event) {
        point.x = event.pageX
        point.x = event.pageY
        console.log('X:', point.x + 'Y:', point.y);
    }
    onBeforeMount(() => {
        window.addEventListener('click', savePoint)
    })
    onBeforeUnmount(() => {
        window.addEventListener('click', savePoint)
    })
    return point
}