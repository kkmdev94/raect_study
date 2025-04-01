$(document).ready(function(){ // function()은 callBack 함수라고 한다.
  let $gigu = $("#gigu"); // 지구 이미지 웹요소(노드) 찾아서 저장
  // 버튼에 이벤트 등록.
  $("#btnStart").click(function(){
    $gigu.animate({
      left: '480px'
    }, 5000);
  })
})