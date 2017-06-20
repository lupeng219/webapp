(function () {
    $(function () {
        var forEach = [].forEach;
        document.getElementsByClassName('wp-inner')[0].fullpage();
        var mySwiper = new Swiper('.auto-play', {
            slidesPerView: 4,
            autoplay: 3000,
            loop: true,
            autoplayDisableOnInteraction: false

        })
    })
})()