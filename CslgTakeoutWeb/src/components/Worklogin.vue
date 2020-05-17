<template>
    <div class="contain">
      <Card class="login" >
        <form  @submit.prevent="submit">
          <div class="title">
            <span v-show="showbottom==1" class="fonta">商家登录</span>
            <span v-show="showbottom==0" class="fonta">商家注册</span><br>
            <span style="color: #999">为您量身定制的餐饮管理左右手</span>
            <div class="logintype">
              <div :class="{'showbom':showbottom==1}" @click="showbottom=1">账号密码登录</div>
              <div :class="{'showbom':showbottom==0}" @click="showbottom=0">商家注册</div>
            </div>
            <Input  size="large" name="username" value="admin" placeholder="请输入账号" style="width: 85%;height: 60px"/>
            <Input type="password"  size="large" value="123" name="password"  placeholder="请输入密码" style="width: 85%;height: 60px"/>
            <Input type="password" v-show="showbottom==0" name="rpassword" size="large" placeholder="请确定密码" style="width: 85%;height: 60px"/>
            <button class="btn" type="info" formType="submit"  size="large"  style="width:85%;height:40px;">
              <span v-show="showbottom==1" >登录</span>
              <span v-show="showbottom==0" >注册</span>
            </button>
            <div class="footers">
              <div style="float: left" @click="showmsg()">登录遇到问题？</div>
              <div style="clear: both;"></div>
              <div  @click="showmsg()" style="color: #1989fa;margin-top: 90px;margin-right: 7.5%"><Icon type="md-phone-portrait" />手机端下载</div>
            </div>
          </div>
        </form>
      </Card>
    </div>
</template>

<script>
  import axios from 'axios'
  import store from '../vuex/store'
  export default {
    name:"Worklogin",
    store,
    data(){
      return{
        showbottom:1,
        show:false
      }
    },
    methods:{
      //跳转路径
      path(a){
        if(a==1){
          this.show=true;
        }
      },
      showmsg(){
        this.$Message.info("暂无此功能");
      },
      submit(e) {
        let login = this;
        let url = this.url + "/Controller/login/login.php";
        //用于注册的url
        let urls = this.url + "/Controller/login/login.php?login=no";
        const formData = new FormData(e.target);
        const name = formData.get('username');
        const pass = formData.get('password');
        const rpass = formData.get('rpassword');
        //注册
        if (this.showbottom == 0) {
          if (name == null || name == "" || pass == "" || pass == null) {
            this.$Message.info("用户名和密码不能为空");
          }else{
            if(pass!=rpass){
              this.$Message.info("密码不一致");
            }else{
              axios.post(urls, formData)
                .then(function (response) {
                  login.$Message.info("注册成功");
                  login.showbottom =1
                })
                .catch(function (error) {
                  login.$Message.info("error");
                })
            }
          }
        } else {
          //登录
          if (name == null || name == "" || pass == "" || pass == null) {
            this.$Message.info("用户名和密码不能为空");
          } else {
            axios.post(url, formData)
              .then(function (response) {
                let token = response.data;
                console.log(token);
                if (token != 'error'&&token!="") {
                  login.$Message.info("验证成功");
                  login.$store.commit('changeLogin', login.$store.state, token.token);
                  login.storeid = token.store;
                }
                console.log(login.$store.state.Authorization);
                login.$router.push('/main')
              })
              .catch(function (error) {
                login.$Message.info("error");
              })
          }
        }
      }
    }
  }
</script>
<style scoped>
  .btn{
    background-color: #57c5f7;
    border:1px solid #57c5f7;
    border-radius: 5px;
    color: white;
  }
  .footers{
    height:150px;
    width:100%;
    margin-left: 7.5%;
    margin-top: 10px;
  }
  .logintype{
    width:85%;
    height:50px;
    margin-left: 7.5%;
    border-bottom: 1px solid lightgrey;
  }

  .showbom{
    border-bottom:2px solid #5a5e66;
    margin-bottom: 18px;
  }

  .logintype div{
    margin-top: 15px;
    width:50%;
    height: 35px;
    float: left;
  }
  .fonta{
    font-size: 18px;
    color: #2d2f33;
  }
  .title{
    text-align: center;
  }
  .contain{
    height:100%;
    width:100%;
    background:#f5f7f9;
    padding-top: 10%;
  }
  .login{
    width:380px;
    margin-left: auto;
    margin-right: auto;

  }
</style>

