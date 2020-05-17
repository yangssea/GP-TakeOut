<template>
    <div>
      <div class="contion">
        <span style="font-size: 15px;">预订单设置：</span>
        <div style="margin-top: 3%">
          <span>预订单状态</span>
          <RadioGroup v-model="phone" style="margin-left: 10%;">
            <Radio label="apple">
              <span>支持</span>
            </Radio>
            <Radio label="apple1">
              <span>不支持</span>
            </Radio>
          </RadioGroup>
        </div>
      </div>
      <Divider/>
    </div>
</template>

<script>
    export default {
        name: "SOwill"
    }
</script>

<style scoped>
  .contion{
    margin: 20px;
  }
</style>
