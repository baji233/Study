<template>
	<view>
		<view class="goods-list">
			<view v-for="item,i in goodsList" :key="i" @click="gotoDetail(item)">
				<my-goods :goods="item"></my-goods>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				// 请求参数对象
				queryObj: {
					query: '',
					cid: '',
					pagenum: 1,
					pagesize: 10
				},
				goodsList: [],
				total: 0,
				// 默认空图片
				defaultPic: 'https://bpic.588ku.com/element_origin_min_pic/01/50/79/61574564445862e.jpg',
				// 节流阀: 是否正在请求数据
				isLoading: false
			};
		},
		methods: {
			async getGoodsList(callBack) {
				// 开启节流阀
				this.isLoading = true
				let {data: ret} = await uni.$http.get('/goods/search', this.queryObj)
				// 关闭节流阀
				this.isLoading = false
				
				// 只要数据请求完毕，就立即按需调用callBack回调函数: stopPullDownRefresh()
				callBack && callBack()
				
				if (ret.meta.status != 200) uni.$showReqErrorMsg()
				
				// 为数据赋值：通过展开运算符...的形式，进行新旧数据的拼接
				this.goodsList = [...this.goodsList, ...ret.message.goods]
				this.total = ret.message.total
			},
			// 跳转至商品详情页
			gotoDetail(item) {
				uni.navigateTo({
					url: '/subpkg/goods_detail/goods_detail?goods_id='+ item.goods_id
				})
			}
		},
		// 将页面请求参数转存到 this.queryObj 对象中
		onLoad(options) {
			this.queryObj.query = options.query || ''
			this.queryObj.cid = options.cid || ''
			console.log(options.cid);
			this.getGoodsList()
		},
		// 监听页面的拉触底行为
		onReachBottom() {
			// 判断是否还有下一页数据, 如果没有, 则不发起额外的请求
			if(this.queryObj.pagenum * this.queryObj.pagesize >= this.total) return 
			
			// 判断是否正在请求其它数据，如果是，则不发起额外的请求
			if(this.isLoading) return
			// 页数+1, 重新发起请求
			this.queryObj.pagenum += 1
			this.getGoodsList()
		},
		// 监听下拉刷新的行为
		onPullDownRefresh() {
			// 重置相关数据
			this.queryObj.pagenum = 1
			this.total = 0
			this.isLoading = false
			this.goodsList = []
			
			// 重新发起请求后, 成功回调函数:(会停止当前页面下拉刷新)
			this.getGoodsList(() => {
				uni.stopPullDownRefresh()
			})
		}
	}
</script>

<style lang="scss">
.goods-item {
 display: flex;
 padding: 10px 5px;
 border-bottom: 1px solid #f0f0f0;
 .goods-item-left {
 margin-right: 5px;
 .goods-pic {
 width: 100px;
 height: 100px;
 display: block;
 }
 }
 .goods-item-right {
 display: flex;
 flex-direction: column;
 justify-content: space-between;
 .goods-name {
 font-size: 13px;
 }
 .goods-price {
 font-size: 16px;
 color: #c00000;
 }
 }
}
</style>
