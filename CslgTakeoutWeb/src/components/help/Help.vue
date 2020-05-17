
<template>
  <div class="layout-content">
    <div class="card">
        <Timeline pending>
          <TimelineItem>2019.3.17&nbsp;发布1.0版本</TimelineItem>
          <TimelineItem>2019.5.17&nbsp;发布2.0版本</TimelineItem>
          <TimelineItem>2019.7.17&nbsp;发布3.0版本</TimelineItem>
          <TimelineItem><a href="#">查看更多</a></TimelineItem>
        </Timeline>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Help"
  }
</script>

<style scoped>
  .layout-content {
    margin: 15px;
    overflow: hidden;
    background:#eee;
    border-radius: 4px;
  }
  .card{
    width:100%;
    height:700px;
    background:white;
    padding-left: 10%;
    padding-top: 50px;
  }
</style>
