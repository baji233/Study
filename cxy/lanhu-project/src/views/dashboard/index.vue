<template>
  <el-main>
    <el-row :gutter="20" type="flex" class="row-bg" justify="center" >
      <el-col :span="6">
        <div class="show-header">
          <div class="show-num">{{ total.userCount }}</div>
          <div class="bottom-text">员工总数</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="show-header">
          <div class="show-num">{{ total.memberCount }}</div>
          <div class="bottom-text">会员总数</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="show-header">
          <div class="show-num">{{ total.meterialCount }}</div>
          <div class="bottom-text">器材总数</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="show-header">
          <div class="show-num">{{ total.lostCount }}</div>
          <div class="bottom-text">失物总数</div>
        </div>
      </el-col>
    </el-row>
    <div class="echars">
      <el-card>
        <template>
          <div class="card-header">
            <span>热销商品</span>
          </div>
          <div id="hotGoods"></div>
        </template>
      </el-card>
      <el-card>
        <template>
          <div class="card-header">
            <span>热销卡</span>
          </div>
          <div id="hotCard"></div>
        </template>
      </el-card>
      <el-card>
        <template>
          <div class="card-header">
            <span>热销课程</span>
          </div>
          <div id="hotCourse"></div>
        </template>
      </el-card>
    </div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>反馈列表</span>
        <el-divider></el-divider>
      </div>
      <div v-for="item, id in suggestList" :key="id" class="text item">
        <span>{{ item.title }}</span>
        <span>{{item.content }}</span>
        <span>{{item.dateTime}}</span>
        <el-divider></el-divider>
      </div>
    </el-card>
  </el-main>
</template>

<script>
import * as echarts from 'echarts'

export default {
  data() {
    return {
      total: {
        memberCount: '',
        userCount: '',
        meterialCount: '',
        lostCount: ''
      },
      suggestList: [],

      //echarts配置
      courseOption: {
        tooltip: {
          trigger: 'houCourse'
        },
        legend: {
          top: '5%',
          left: 'center'
        },
        series: [
          {
            name: 'course',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 40,
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            data: []
          }
        ]
      },
      cardOption: {
        xAxis: {
          type: 'category',
          // name
          data: []
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data: [],
            type: 'bar'
          }
        ]
      },
      goodsOption: {
        tooltip: {
          trigger: 'hotGoods'
        },
        legend: {
          top: '5%',
          left: 'center',
          selectedMode: false
        },
        series: [
          {
            name: 'goods',
            type: 'pie',
            radius: ['40%', '70%'],
            center: ['50%', '70%'],
            startAngle: 180,
            label: {
              show: true,
              formatter(param) {
                return param.name + ' (' + param.percent * 2 + '%)';
              }
            },
            data: [
              
              {
                value: 1048 + 735 + 580 + 484 + 300,
                itemStyle: {
                  color: 'none',
                  decal: {
                    symbol: 'none'
                  }
                },
                label: {
                  show: false
                }
              }
            ],
          }
        ]
      }
    }
  },
  mounted() {
    const showHeader = document.getElementsByClassName('show-header');
    const color = ['#ED4014', '#2DB7F5', '#00C957', '#FF9900'];
    for (let i = 0; i < color.length; i ++) {
      showHeader[i].style.background = color[i];
    }
    this.getHotCourse(),
    this.getHotCard(),
    this.getHotGoods(),
    this.getSuggest(),
    this.getMember(),
    this.getUser(),
    this.getMaterial(),
    this.getLost()
  },
  methods: {
    //获取热销课程
    async getHotCourse() {
      let ret = await this.http.get('/home/getHotCourse')
      //图表将在hotCourse中显示
      var chartDom = document.getElementById('hotCourse')
      //初始化
      var myChart = echarts.init(chartDom)
      //传数据
      this.courseOption.series[0].data = ret.data;
      //为图表设置设置
      myChart.setOption(this.courseOption)
    },
    //获取热销卡
    async getHotCard() {
      let ret = await this.http.get('/home/getHotCards')
      //图表将在hotCard中显示
      var chartDom = document.getElementById('hotCard')
      //初始化
      this.cardOption.xAxis.data = ret.data.map(item => item.name);
      this.cardOption.series[0].data = ret.data;
      var myChart = echarts.init(chartDom);
      //为图表设置设置
      myChart.setOption(this.cardOption)
    },
    //获取热销商品
    async getHotGoods() {
      let ret = await this.http.get('/home/getHotGoods')
      //图表将在hotGoods中显示
      var chartDom = document.getElementById('hotGoods')
      //初始化
      var myChart = echarts.init(chartDom)
      //传数据
      this.goodsOption.series[0].data = ret.data
      //为图表设置option
      myChart.setOption(this.goodsOption)
    },
    //获取反馈列表
    async getSuggest() {
      let ret = await this.http.get('/home/getSuggest')
      this.suggestList = ret
    },
    //获取会员总数
    async getMember() {
      let ret = await this.http.get('/home/memberCount')
      this.total.memberCount = this.subCount(ret)
    },
    //获取员工总数
    async getUser() {
      let ret = await this.http.get('/home/userCount')
      this.total.userCount = this.subCount(ret)
    },
    //获取器材总数
    async getMaterial() {
      let ret = await this.http.get('/home/materialCount')
      this.total.meterialCount = this.subCount(ret)
    },
    //获取失物总数
    async getLost() {
      let ret = await this.http.get('/home/lostCount')
      this.total.lostCount = this.subCount(ret)
    },
    //字符串截取总数
    subCount(ret) {
      return ret.data;
    }
  }
}
</script>

<style lang="scss" scoped>
.el-main {
  height: calc(100vh - 50px);
}
.bottom-text {
  bottom: 0;
  width: 100%;
  background: rgba(0, 0, 0, 0.1);
  height: 25px;
  line-height: 25px;
  text-align: center;
  position: absolute;
  font-weight: 600;
}

.show-header {
  color: #fff;
  height: 80px;
  border-radius: 5px;
  position: relative;
}

.show-num {
  font-size: 38px;
  font-weight: 600;
  padding: 5px;
  text-align: center;
}

.echars {
  display: flex;

  &>:first-child {
    flex: 1;
  }

  &>:not(:first-child) {
    margin-left: 20px; 
    flex: 1;
  }

  .el-card div:last-of-type {
    width: 100%; 
    height: 220px;
  }

}

.box-card {
  margin-top: 30px;

  &>.clearfix span {
    color: #000; 
    font-weight: 600; 
    margin-bottom: 10px;
  }

  &>.text span:first-of-type {
    font-weight: 600; 
    font-size: 14px;
  }

  &>.text span:not(:first-of-type) {
    margin-left: 30px;
     font-size: 14px;
  }
}

.row-bg {
  margin-bottom: 40px;
}
</style>
