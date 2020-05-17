<!--
    首页模块。
    主要思想：
    全局通过改变spanLeft、spanRight来实现页面的缩放。其中核心点：class和:size="iconSize"的绑定
    编写人：杨志学、王高玲
-->
<style scoped>
  ::-webkit-scrollbar {
    display: none;
  }
</style>
<template>
  <div style="height:100%">
    <!--          登录界面-->
    <router-view> </router-view>
  </div>
</template>
<script>
  export default {
   name:'App'
  }
</script>
