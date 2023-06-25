<template>
	<view>
		<!-- 		轮播图  -->
		<swiper :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000">
			<swiper-item v-for="item in swiperList" :key="item.goods_id">
				<navigator class="swiper-item" :url="'/subpkg/goods_detail/goods_detail?goods_id='+item.goods_id">
					<image :src="item.image_src"></image>
				</navigator>
			</swiper-item>
		</swiper>
		<!-- 		分类导航区域  -->
		<view class="nav-list">
			<view class="nav_item" @click="navClickHandle(item)" v-for="item, i in navList" :key="i">
				<image class="nav-img" :src="item.image_src"></image>
			</view>
		</view>
		<!-- 楼层区域 -->
		<view class="floor-list">
			<view class="floor-item" v-for="item in floorList" :key="item.floor_title.name">
				<image class="floor-title" :src="item.floor_title.image_src" mode="widthFix"></image>
				<view class="floor-img-box">
					<view class="left-img-box">
						<image :src="item.product_list[0].image_src" mode="widthFix" :style="{width: item.product_list[0].image_width+'rpx'}"></image>
					</view>
					<view class="right-img-box">
						<view class="right-img-item" v-for="item2, i2 in item.product_list" :key="i2" v-if="i2 !== 0">
							<image :src="item2.image_src" mode="widthFix" :style="{width: item2.image_width+'rpx'}"></image>
						</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				swiperList: [],
				navList: [],
				floorList: []
			}
		},
		methods: {
			//获取轮播图列表
			async getSwiperList() {
				let {
					data: ret
				} = await uni.$http.get('/home/swiperdata')
				if (ret.meta.status != 200) uni.$showReqErrorMsg()
				this.swiperList = ret.message
			},
			//获取导航列表
			async getNavList() {
				let {
					data: ret
				} = await uni.$http.get('/home/catitems')
				if (ret.meta.status != 200) uni.$showReqErrorMsg()
				this.navList = ret.message
			},
			// 导航事件处理
			navClickHandle(item) {},
			// 获取楼层数据
			async getFloorList() {
				let {
					data: ret
				} = await uni.$http.get('/home/floordata')
				if (ret.meta.status != 200) uni.$showReqErrorMsg()
				this.floorList = ret.message
			},
		},
		onLoad() {
			this.getSwiperList()
			this.getNavList()
			this.getFloorList()
		}
	}
</script>

<style lang='scss'>
	swiper {
		height: 330rpx;

		.swiper-item,
		image {
			width: 100%;
			height: 100%;
		}
	}
	
	.nav-list {
		display: flex;
		justify-content: space-around;
		margin: 15px 0;
		.nav-img {
			width: 128rpx;
			height: 140rpx;
		}
	}
	
	.floor-title {
		display: flex;
		height: 60rpx;
		width: 100%;
	}
	
	.right-img-box {
	 display: flex;
	 flex-wrap: wrap;
	 justify-content: space-around;
	}
	.floor-img-box {
	 display: flex;
	 padding-left: 10rpx;
	}
</style>