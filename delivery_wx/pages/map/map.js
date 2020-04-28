var amapFile = require('../../static/amap-wx.js');
Page({
  data: {
    key: 'c290b7e016c85e8f279b2f80018c6fbf',
    show: false,
    currentLo: null,
    currentLa: null,
    newCurrentLo: null,
    newCurrentLa: null,
    distance: 0,
    duration: 0,
    markers: null,
    scale: 16,
    polyline: null,
    statusType: 'car',
    includePoints: []
  },
  //路线规划
  change(){
    let plugin = requirePlugin('routePlan');
    let key = 'IFLBZ-IU56G-C4TQM-I3VSN-Y5AO2-KGBN7';  //使用在腾讯位置服务申请的key
    let referer = 'test';   //调用插件的小程序的名称
    let startPoint = JSON.stringify({  //起点
      'name': '中国技术交易大厦',
      'latitude': 39.984154,
      'longitude': 116.30749
    });
    let endPoint = JSON.stringify({  //终点
      'name': '北京西站',
      'latitude': 39.894806,
      'longitude': 116.321592
    });
    wx.navigateTo({
      url: 'plugin://routePlan/route-plan?key=' + key + '&referer=' + referer + '&endPoint=' + endPoint
    });
  },
  onLoad() {
   
  },
  
})
