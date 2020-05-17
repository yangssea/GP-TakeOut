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

  .layout {
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }

  .layout-breadcrumb {
    padding: 10px 15px 0;
  }

  .layout-content {
    min-height: 600px;
    margin: 15px;
    overflow: hidden;
    background: #eee;
    border-radius: 4px;
    height: 850px;
  }

  .layout-content-main {
    padding: 10px;
  }

  .layout-copy {
    text-align: center;
    padding: 10px 0 20px;
    color: #9ea7b4;
  }

  .layout-menu-left {
    background: #464c5b;
    height: 930px;
    transition: width .2s ease .1s;
  }

  i {
    color: rgba(255, 255, 255, .7);;
  }

  .layout-logo-left {
    width: 90%;
    height: 30px;
    background: #5b6270;
    border-radius: 3px;
    line-height: 30px;
    font-size: 15px;
    color: white;
  }

  .layout-logo-left i {
    float: left;
  }

  .layout-logo-left span {
    float: left;
  }

  .layout-ceiling-main a {
    color: #9ba7b5;
  }

  .layout-hide-text .layout-text {
    display: none;
  }

  .layout-text {
    color: rgba(255, 255, 255, .7);
  }

  .header {
    height: 50px;
    width: 100%;
    background: #464c5b;
  }

  .header .font1 {
    color: rgba(255, 255, 255, .7);
    font-family: Algerian;
    margin-left: 20px;
    margin-top: 20px;
    font-size: 30px;
  }

  .chinesefont {
    color: white;
    float: right;
    font-size: 18px;
    margin-top: 10px;
    font-family: "Algerian";
  }

  .fontsize {
    font-size: 30px;
  }

  .fonts-color {
    color: black;
    font-size: 50px;
  }

  .xz {
    transform: rotate(-90deg);
    margin-left: 25px;
  }

  .path-hover :hover i {
    color: #fff;
  }

  .path-hover :hover span {
    color: #fff;
  }

  .list_sname{
    text-align: center;
    padding: 5%;

  }
</style>
<template>
  <div style="height:100%">
    <!--头部商家名称展示部分-->
    <div class="header" v-if="show"  >

      <span class="font1">@zi-yue</span>
    </div>
    <!--iview布局中的布局模块 -->
    <div class="layout" :class="{'layout-hide-text': spanLeft < 3}" v-if="show">
      <Row type="flex">
        <i-col :span="spanLeft" class="layout-menu-left">
          <Menu theme="dark"  width="auto" >
           <!-- <div class="layout-logo-left">
             &lt;!&ndash; <div style="float: left;" :class="{'xz': spanLeft < 3}">
                <ion-icon name="reorder" class="fontsize" ></ion-icon>
              </div>&ndash;&gt;
             &lt;!&ndash; <span class="layout-text">&nbsp;&nbsp;导航菜单</span>&ndash;&gt;
            </div>-->
            <MenuItem name="2">
              <router-link to="/main">
                <Icon type="md-home" style="margin-top:-5px; " :size="iconSize"/>
                <span class="layout-text" style="margin-left: 5px;">首页</span>
              </router-link>
            </MenuItem>
            <Submenu :name="index+1"  v-for="(list,index) in path">
              <template slot="title">
                <Icon :custom=list.sign :size="iconSize"/>
                <span class="layout-text">{{list.name}}</span>
              </template>
              <MenuItem v-for="(list1,is) in list.sonpath"  :style="{background:(colorsl==is&&colors==index?'teal':'#464c5b'),color:(colorsl==is&&colors==index?'white':' rgba(255, 255, 255, .7)')}">
                <router-link :to=list1.path ><span  @click="smlist(is,index)" style="color: white">{{list1.sname}}</span></router-link>
              </MenuItem>
            </Submenu>
          </Menu>
        </i-col>
        <i-col :span="spanRight">
          <div class="layout-breadcrumb">
            <Breadcrumb>
              <Icon type="compass"></Icon>
              <Breadcrumb-item href="#">{{pathname}}</Breadcrumb-item>
              <Breadcrumb-item href="#">应用中心</Breadcrumb-item>
              <Breadcrumb-item>某应用</Breadcrumb-item>
            </Breadcrumb>
          </div>
          <!--内容区域-->
          <router-view></router-view>
          <!-- <div class="layout-copy">
             2011-2016 &copy; TalkingData
           </div>-->
        </i-col>
      </Row>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        // 隐藏导航栏等模块
        show:true,
        spanLeft: 3,
        spanRight: 21,
        pathname: '首页',
        /*list颜色*/
        colorsl:0,
        colors:0,
        layout:'',
        path: [
          {
            name: '订单',
            sign: "iconfont icon-tianmaohaoquan",
            signdown:"md-arrow-dropdown",
            sonpath:[
              {
                sname:'订单管理',
                path: '/main/Order',
              }, {
                sname:'订单查询',
                path: '/main/QureyOrder',
              }, {
                sname:'订单设置',
                path: '/main/SetOrder',
              }
            ]

          }, {
            name: '商品',
            sign: 'iconfont icon-hanbao',
            signdown:"md-arrow-dropdown",
            sonpath:[
              {
                sname:'商品管理',
                path:'/main/Goods'
              },{
                sname:'商品设置',
                path:'/main/Goods'
              }
            ]
          }, {
            name: '顾客',
            sign: 'iconfont icon-kefuyouxian',
            sonpath:[
              {
                sname:'顾客评价',
                path:'/main/Cgrade'
              },
            ]
          }, {
            name: '财务',
            sign: 'iconfont icon-goumai',
            sonpath:[
              {
                sname:'财务管理',
                path:'/main/Finance'
              }
             ]
          }, {
            name: '门店',
            sign: 'iconfont icon-dianpu',
            sonpath:[
              {
                sname:'门店管理',
                path:'/main/Store'
              },{
                sname:'门店设置',
                path:'/main/StoreManager'
              }
            ]
          },/* {
            name: '数据',
            sign: 'iconfont icon-tongji'
          },*/ {
            name: '帮助',
            sign: 'iconfont icon-zhibojian',
            sonpath:[
              {
                sname:'帮助详情',
                path:'/main/Help'
              }
            ]
          }
        ]

      }
    },
    computed: {
      /*暂时废弃函数*/
      iconSize() {
        return this.spanLeft === 3 ? 21 : 24;
      }
    },
    methods: {
      /*点击收缩*/
      toggleClick() {
        if (this.spanLeft === 3) {
          this.spanLeft = 1;
          this.spanRight = 23;
        } else {
          this.spanLeft = 3;
          this.spanRight = 21;
        }
      },
      /*点击下拉菜单显示颜色*/
      smlist(index,i){
        this.colorsl=index;
        this.colors=i;
      },

    }
  }
</script>
