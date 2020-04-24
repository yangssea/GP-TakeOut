function request(url, data = {}, method = "GET", contentType = "application/json") {
  return new Promise(function (resolve, reject) {
    wx.request({
      url: url,
      data: data,
      method: method,
      header: {
        'content-type': contentType,
        'token': wx.getStorageSync('token')
      },
      success: function (res) {
        if (res.statusCode == 200) {

          if (res.data.errno == 401) {
            // //需要登录后才可以操作
            // wx.showModal({
            //     title: '',
            //     content: '请先登录',
            //     success: function (res){
            //         if (res.confirm) {
            //             wx.removeStorageSync("userInfo");
            //             wx.removeStorageSync("token");
            //             wx.switchTab({
            //                 url: '/pages/ucenter/index/index'
            //             });
            //         }
            //     },
            //     showCancel:false
            // });
          } else {
            resolve(res.data);
          }
        } else {
          reject(res.errMsg);
        }

      },
      fail: function (err) {
        reject(err)
      }
    })
  });
}
//导出
module.exports = {
  request
}