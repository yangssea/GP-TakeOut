//校验经度
const testLong =function(val){
  let longrg = /^(\-|\+)?(((\d|[1-9]\d|1[0-7]\d|0{1,3})\.\d{0,6})|(\d|[1-9]\d|1[0-7]\d|0{1,3})|180\.0{0,6}|180)$/;
  if (!longrg.test(val)) {
    return false;
  }
  return true;
}
//校验纬度
const testLat = function (val) {
  let longrg = /^(\-|\+)?([0-8]?\d{1}\.\d{0,6}|90\.0{0,6}|[0-8]?\d{1}|90)$/;
  if (!longrg.test(val)) {
    return false;
  }
  return true;
}

const checkPhone =function(val){
  let longrg = /^[1]([3-9])[0-9]{9}$/
  if (!longrg.test(val)) {
    return false;
  }
  return true;
}
module.exports = {
  testLong,
  testLat,
  checkPhone
}