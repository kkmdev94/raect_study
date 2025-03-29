function showPrice(){
  // 사용자가 입력한 값을 두개의 변수에 저장함.
  var originalPrice = document.querySelector('#originalPrice').value;
  var rate = document.querySelector('#rate').value;

  if(originalPrice > 0 && rate > 0){
    var savedPrice = originalPrice * (rate / 100);
    var result = originalPrice - savedPrice;
    document.querySelector('#showResult').innerHTML = "상품의 원래 가격은 " +
      originalPrice +"원이고, 할인율은 " + rate + "%입니다." + savedPrice + "원을 절약한" + result + "원에 구입 가능합니다.";
  }
}