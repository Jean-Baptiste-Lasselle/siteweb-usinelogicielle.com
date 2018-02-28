        var myCenter = new google.maps.LatLng(41.0386137, -75.1064638);

        function initialize() {
            var mapProp = {
                center: myCenter,
                scrollwheel: false,
                zoom: 10,
                styles: [{
                    "featureType": "landscape",
                    "stylers": [{
                        "saturation": -100
                        }, {
                        "lightness": 65
                        }, {
                        "visibility": "on"
                        }]
                    }, {
                    "featureType": "poi",
                    "stylers": [{
                        "saturation": -100
                        }, {
                        "lightness": 51
                        }, {
                        "visibility": "simplified"
                        }]
                    }, {
                    "featureType": "road.highway",
                    "stylers": [{
                        "color": "#ffffff"
                        }, {
                        "visibility": "simplified"
                        }]
                    }, {
                    "featureType": "road.arterial",
                    "stylers": [{
                        "saturation": -100
                        }, {
                        "lightness": 30
                        }, {
                        "visibility": "on"
                        }]
                    }, {
                    "featureType": "road.local",
                    "stylers": [{
                        "saturation": -100,
                        }, {
                        "lightness": 40
                        }, {
                        "visibility": "on"
                        }]
                    }, {
                    "featureType": "transit",
                    "stylers": [{
                        "saturation": -100
                        }, {
                        "visibility": "simplified"
                        }]
                    }, {
                    "featureType": "administrative.province",
                    "stylers": [{
                        "visibility": "off"
                        }]
                    }, {
                    "featureType": "water",
                    "elementType": "labels",
                    "stylers": [{
                        "visibility": "on"
                        }, {
                        "lightness": -25
                        }, {
                        "saturation": -100
                        }]
                    }, {
                    "featureType": "water",
                    "elementType": "geometry",
                    "stylers": [{
                        "color": "#1bb4b9"
                        }]
                    }],
                mapTypeId: google.maps.MapTypeId.ROADMAP,
            };

            var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);

            var marker = new google.maps.Marker({
                position: myCenter,
                icon: 'assets/images/map.png',
            });

            marker.setMap(map);
        }

        google.maps.event.addDomListener(window, 'load', initialize);