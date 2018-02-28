(function ($) {
    "use strict";
    
    //DOCUMENT READY FUNCTION
    jQuery(document).ready(function () {
    //meanmenu
        $('header nav').meanmenu({});
        
    // header_bottom client area btn  
    $('.header_right a.log_in').on('click', function(){
            $('.romana_login_form').toggleClass('clicked');
        });    
        
    //This code is for owl Carousel
    if ($.fn.owlCarousel) {
            var autoplay = 6000,
                smartSpeed_c = 700,
                hero_slider = $('.hero_slider');
            //Hero_Slider_crsl
            hero_slider.owlCarousel({
                nav: true,
                dots: true,
                autoplay: false,
                loop: true,
                items: 1,
                animation: true,
                touchDrag:false,
                mouseDrag:false,
                smartSpeed: smartSpeed_c,
                autoplayTimeout: autoplay,
                navText: ["<i class='icofont icofont-caret-left'></i>", "<i class='icofont icofont-caret-right'></i>"]
            });
        
            //tihs code is for slider effect
            hero_slider.on('translate.owl.carousel', function() {
                $('.romana_hero_text h1').removeClass('slideInLeft animated').hide();
                $('.romana_hero_text p').removeClass('slideInLeft animated').hide();
                $('.romana_hero_text .common_btn').removeClass('slideInRight animated').hide();
            });
            hero_slider.on('translated.owl.carousel', function() {
                $('.owl-item.active .romana_hero_text h1').addClass('slideInLeft animated').show();
                $('.owl-item.active .romana_hero_text p').addClass('slideInLeft animated').show();
                $('.owl-item.active .romana_hero_text .common_btn').addClass('slideInLeft animated').show();
            });
        //End hero slider
        
        //This code is for client_crsl
            var romana_testimonial_crsl = $('.romana_testimonial_crsl');
            romana_testimonial_crsl.owlCarousel({
                nav: false,
                dots: false,
                autoplay: false,
                loop: true,
                margin: 30,
                smartSpeed: 1000,
                items: 3,
                dotsEach: true,
                responsiveClass: true,
                responsive: {
                    300: {
                        items: 1
                    },
                    480: {
                        items: 1
                    },
                    768: {
                        items: 2,
                        margin: 0
                    },
                    992: {
                        items: 3
                    },
                    1170: {
                        items: 3
                    }
                }
            });
        // End romana_client_crsl 
        
        //This code is for romana_popular_class_crsl
            var romana_popular_class_crsl = $('.romana_popular_class_crsl');
            romana_popular_class_crsl.owlCarousel({
                nav: true,
                dots: false,
                autoplay: false,
                loop: true,
                margin: 30,
                smartSpeed: 1000,
                items: 3,
                dotsEach: true,
                responsiveClass: true,
                navText: ["<i class='icofont icofont-caret-left'></i>", "<i class='icofont icofont-caret-right'></i>"],
                responsive: {
                    300: {
                        items: 1
                    },
                    480: {
                        items: 1
                    },
                    768: {
                        items: 2
                    },
                    992: {
                        items: 3,
                        margin:10
                    },
                    1170: {
                        items: 3
                    }
                }
            });
        // End romana_client_crsl 
        //romana_brand_crsl
        var romana_brand_crsl = $('.romana_brand_crsl');
            romana_brand_crsl.owlCarousel({
                nav: false,
                dots: false,
                autoplay: false,
                loop: true,
                margin: 30,
                smartSpeed: 1000,
                items: 3,
                responsiveClass: true,
                responsive: {
                    300: {
                        items: 2
                    },
                    480: {
                        items: 3
                    },
                    768: {
                        items: 3
                    },
                    992: {
                        items: 4
                    },
                    1170: {
                        items: 5
                    },
                }
            });
        //romana_brand_crsl
    }
    // End Owl Carousel 
        
    // This code is for CounterUp
    if ($.fn.counterUp) {
        //counterUp
        $('.counter').counterUp({
            delay: 10,
            time: 1000,
        });
    }    
    // End CounterUp
        
    //This code is for magnificPopup IMAGE
    if ($.fn.magnificPopup) {
        $(".mfp-iframe").magnificPopup({
            type: 'video'
        });
    }
    // End magnificPopup1
        
    //This code is for magnificPopup IMAGE
    if ($.fn.magnificPopup) {
        $(".gallery_img").magnificPopup({
            type: 'image'
        });
    }
    // End magnificPopup2 
        
    });// END Document Ready FUNCTION

    //WINDOW LOAD FUNCTION
        
    jQuery(window).on('load', function () {
        // Preloder for gif img
        $('#preloader').fadeOut(); // will first fade out the loading animation
        $('.preloader_spinner').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
        $("body").removeClass("preloader_active");
    }); 
})(jQuery);




