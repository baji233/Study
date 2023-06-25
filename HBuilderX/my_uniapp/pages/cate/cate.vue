<template>
	<view class="scroll-view-container">
		<scroll-view scroll-y class="left-scroll-view"  :style="{height: wh + 'px'}">
			<block v-for="item, i in cateList" :key="i">
				<view @click="changeItem(i)" :class="['left-scroll-view-item', curr===i? 'active':'']">{{item.cat_name}}</view>
			</block>
		</scroll-view>
		<scroll-view scroll-y class="right-scroll-view" :scroll-top="scrollTop"  :style="{height: wh + 'px'}">
			<view class="cate-lv2" v-for="item2, i2 in cateLevel2" :key="i2">
				<view class="cate-lv2-title">{{item2.cat_name}}</view>
				<view class="cate-lv3-list">
					<view class="cate-lv3-item" v-for="item3, i3 in item2.children" :key="i3" @click="gotoGoodsList(item3)">
						<image :src="item3.cat_icon"></image>
						<text>{{item3.cat_name}}</text>
					</view>
				</view>
			</view>
		</scroll-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				cateList: [],
				cateLevel2: [],
				// 窗口的可用高度(信息展示区) = 屏幕高度 - 导航栏高度 - tabbar高度
				wh: 0,
				// 当前选中项的索引，默认让第⼀项被选中
				curr: 0,
				// 滚动条距离顶部的距离
				scrollTop: 0
			};
		},
		methods: {
			// 获取分类导航列表
			async getCateList() {
				let { 
					data: ret
				} = await uni.$http.get('/categories')
				if (ret.meta.status != 200) uni.$showReqErrorMsg()
				this.cateList = ret.message
				//重新加载后为三级菜单赋初始值
				this.cateLevel2 = this.cateList[0].children
			},
			// 点击左侧分类
			changeItem(i) {
				this.curr = i
				// 获取二级菜单
				this.cateLevel2 = this.cateList[i].children
				// 让scrollTop的值在0和1之间切换
				this.scrollTop = this.scrollTop ? 0 : 1
			},
			//点击三级菜单跳转至商品列表
			gotoGoodsList(item3) {
				uni.navigateTo({
					url: '/subpkg/goods_list/goods_list?cid='+ item3.cat_id
				})
			}
		},
		onLoad() {
			this.getCateList()
			// 获取当前系统的信息
			const sysInfo = uni.getSystemInfoSync()
			// 为wh窗口可用高度动态赋值
			this.wh = sysInfo.windowHeight
		}
	}
</script>

<style lang="scss">
	.scroll-view-container {
	 display: flex;
	 .left-scroll-view {
	 width: 120px;
	 .left-scroll-view-item {
	 line-height: 60px;
	 background-color: #f7f7f7;
	 text-align: center;
	 font-size: 12px;
	 // 激活项的样式
	 &.active {
	 background-color: #ffffff;
	 position: relative;
	 // 渲染激活项左侧的红⾊指示边线
	 &::before {
	 content: ' ';
	 display: block;
	 width: 3px;
	 height: 30px;
	 background-color: #c00000;
	 position: absolute;
	 left: 0;
	 top: 50%;
	 transform: translateY(-50%);
	 }
	 }
	 }
	 }
	}
	
	.cate-lv3-list {
	 display: flex;
	 flex-wrap: wrap;
	 .cate-lv3-item {
	 width: 33.33%;
	 margin-bottom: 10px;
	 display: flex;
	 flex-direction: column;
	 align-items: center;
	 image {
	 width: 60px;
	 height: 60px;
	 }
	 text {
	 font-size: 12px;
	 }
	 }
	}
	.cate-lv2-title {
		height: 50rpx;
		background-color: blanchedalmond;
		line-height: 50rpx;
		text-align: center;
	}
</style>
