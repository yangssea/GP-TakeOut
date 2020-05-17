<template>
  <div class="layout-content">
    <div class="font1">提示音设置</div>
    <div class="musiclist">
      <span>出单提示音</span>
      <RadioGroup v-model="phone" style="margin-left: 10%;">
        <Radio label="apple">
          <span>提示1次</span>
        </Radio>
        <Radio label="apple1">
          <span>提示3次</span>
        </Radio>
        <Radio label="apple2">
          <span>不提示</span>
        </Radio>
        <Radio label="apple3">
          <span>循环提示</span>
        </Radio>
      </RadioGroup>
      <Icon type="md-volume-up" style="margin-left: 5%;color:#2d8cf0;"/>
      <span style="color:#2d8cf0;">试听</span>
    </div><Divider/>
    <div class="musiclist">
      <span>出单提示音</span>
      <RadioGroup v-model="phone" style="margin-left: 10%;">
        <Radio label="apple">
          <span>提示1次</span>
        </Radio>
        <Radio label="apple1">
          <span>提示3次</span>
        </Radio>
        <Radio label="apple2">
          <span>不提示</span>
        </Radio>
        <Radio label="apple3">
          <span>循环提示</span>
        </Radio>
      </RadioGroup>
      <Icon type="md-volume-up" style="margin-left: 5%;color:#2d8cf0;"/>
      <span style="color:#2d8cf0;">试听</span>
    </div><Divider/>
    <div class="musiclist">
      <span>出单提示音</span>
      <RadioGroup v-model="phone" style="margin-left: 10%;">
        <Radio label="apple">
          <span>提示1次</span>
        </Radio>
        <Radio label="apple1">
          <span>提示3次</span>
        </Radio>
        <Radio label="apple2">
          <span>不提示</span>
        </Radio>
        <Radio label="apple3">
          <span>循环提示</span>
        </Radio>
      </RadioGroup>
      <Icon type="md-volume-up" style="margin-left: 5%;color:#2d8cf0;"/>
      <span style="color:#2d8cf0;">试听</span>
    </div><Divider/>
    <div class="musiclist">
      <span>出单提示音</span>
      <RadioGroup v-model="phone" style="margin-left: 10%;">
        <Radio label="apple">
          <span>提示1次</span>
        </Radio>
        <Radio label="apple1">
          <span>提示3次</span>
        </Radio>
        <Radio label="apple2">
          <span>不提示</span>
        </Radio>
        <Radio label="apple3">
          <span>循环提示</span>
        </Radio>
      </RadioGroup>
      <Icon type="md-volume-up" style="margin-left: 5%;color:#2d8cf0;"/>
      <span style="color:#2d8cf0;">试听</span>
    </div><Divider/>
    <div class="musiclist">
      <span>出单提示音</span>
      <RadioGroup v-model="phone" style="margin-left: 10%;">
        <Radio label="apple">
          <span>提示1次</span>
        </Radio>
        <Radio label="apple1">
          <span>提示3次</span>
        </Radio>
        <Radio label="apple2">
          <span>不提示</span>
        </Radio>
        <Radio label="apple3">
          <span>循环提示</span>
        </Radio>
      </RadioGroup>
      <Icon type="md-volume-up" style="margin-left: 5%;color:#2d8cf0;"/>
      <span style="color:#2d8cf0;">试听</span>
    </div><Divider/>
  </div>
</template>

<script>
    export default {
        name: "SOmusic"
    }
</script>

<style scoped>
  .musiclist{
    margin: 15px;
    font-size: 15px;
  }
  .font1{
    font-size: 16px;
    margin-top: 30px;
    margin-left: 10px;
  }

  .layout-content {
    background: white;
    margin: 15px;
    overflow: hidden;
    border-radius: 4px;
  }
</style>
