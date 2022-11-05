let username, password, confirmPassword
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  getUsername(e) {
    username = e.detail.value
  },
  getPassword(e) {
    password = e.detail.value
  },
  getConfirmPassword(e) {
    confirmPassword = e.detail.value
  },
  login() {
    if (username && password && confirmPassword) {
      if (password == confirmPassword) {
        wx.request({
          url: 'http://localhost:8080/user/login',
          method: 'POST',
          header: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          data: {
            username: username,
            password: password,
          },
          success(res) {
            if (res.data == 1) {
              wx.showToast({
                title: '登录成功',
                icon: 'success'
              })
            } else if (res.data == 0) {
              wx.showToast({
                title: '密码错误',
                icon: 'error'
              })
            } else {
              wx.showToast({
                title: '用户不存在',
                icon: 'error'
              })
            }
          }
        })
      } else {
        wx.showToast({
          title: '两次密码不相同',
          icon: 'error'
        })
      }
    } else {
      wx.showToast({
        title: '输入未完成',
        icon: 'error'
      })
    }
  },
  reset(){
    username=null
    password=null
    confirmPassword=null
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})