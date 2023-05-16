<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
    <el-breadcrumb-item>数据统计</el-breadcrumb-item>
    <el-breadcrumb-item>数据报表</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card>
      <div id="main" style="width: 750px; height: 400px;"></div>
    </el-card>
  </div>

  </template>
  
  <script>
  import * as echarts from 'echarts'
  import _ from 'lodash'

  export default {
    data() {
      return {
        options: {
        title: {
          text: '用户来源'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            label: {
              backgroundColor: '#E9EEF3'
            }
          }
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [
          {
            boundaryGap: false
          }
        ],
        yAxis: [
          {
            type: 'value'
          }
        ]
      }


      }
    },
    async mounted() {
      let ret = await this.http.get('reports/type/1')
      console.log('报表数据: ', ret)
      //图表将在main中显示
      var chartDom = document.getElementById('main')
      //初始化
      var myChart = echarts.init(chartDom)
      //合并: 配置对象(options) + 后台数据对象(ret)
      const result = _.merge(ret.data, this.options)
      console.log('合并后: ', result);
      //为图表设置设置
      myChart.setOption(result)
    }
  }
  </script>
  
  <style>
  
  </style>