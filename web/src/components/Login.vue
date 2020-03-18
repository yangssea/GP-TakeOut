<template>

</template>

<script>
    import axios from 'axios'
    export default {
        name: "Login",
        methods:{
            loginFun(){
                this.axios.post('请求的后端接口链接',{
                    data:{
                        userId:this.user,   // 登录名
                        userPwd:this.psw,  // 登录密码
                    }
                }).then((res) => {
                    if(res.data.status == 200){
                        var userInfo = res.data.data;
                        this.$store.commit('$_setToken', userInfo.token);
                        Toast({ message: '登录成功', type: 'success',duration: 1500});   // ui弹窗提示
                        this.$router.push({ name:'homePage' });  // 跳转到首页
                    } else {
                        Toast({ message: res.data.message, duration: 1500});   // ui弹窗提示
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>
