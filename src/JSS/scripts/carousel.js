window.addEventListener('load', function(){
    var carousels = document.getElementsByClassName('carousel');

    //캐러셀 이벤트를 등록하는 로직
    for(var i = 0; i < carousels.length; i++){
        addEventToCarousel(carousels[i]);
    }
});

function addEventToCarousel(carouselElem) {
    var ulElem = carouselElem.querySelector('ul');
    var liElems = ulElem.querySelectorAll('li');

    // 너비 값 조정
    var liWidth = liElems[0].clientWidth;
    
    var adjustedWidth = liElems.length * liWidth;
    ulElem.style.width = adjustedWidth + 'px';

    // 슬라이드 버튼 이벤트 등록
    var slideButtons = carouselElem.querySelectorAll('.slide');
    for (var i = 0; i < slideButtons.length; i++){
        slideButtons[i].addEventListener('click', createListenerSlide(carouselElem));
    }
}

function createListenerSlide(carouselElem){
    return function(event) {
        var clickedButton = event.currentTarget;
    }
}

