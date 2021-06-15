<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title></title>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:700" rel="stylesheet">
        <link rel="stylesheet" href="styles.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.5/handlebars.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBCOsnTXv_-slD3V_EGJsQJNox9keCYihY"></script>
        <script src="snazzy-info-window.min.js"></script>
     
        <script id="marker-content-template" type="text/x-handlebars-template">
            <div class="custom-img" style="background-image: url({{{bgImg}}})"></div>
            <section class="custom-content">
                <h1 class="custom-header">
                    {{title}}
                    <small>{{subtitle}}</small>
                </h1>
                <div class="custom-body">{{{body}}}</div>
            </section>
        </script>
    </head>
    <body>
        <div class="map-canvas">
        </div>
    </body>
</html>

<?php
include_once 'lol.php';
?>
<script>

    // Snazzy Map Style - https://snazzymaps.com/style/8097/wy
   
    var locations=<?php get_all_locations() ?>;  

    console.log(locations) ; 

    // Create the map

    
    var map = new google.maps.Map($('.map-canvas')[0], {
        zoom: 10,
        center: new google.maps.LatLng(33.5731, -7.5898)
    });

    // Add a custom marker
    var markerIcon = {
        path: 'M12 7V3H2v18h20V7H12zM6 19H4v-2h2v2zm0-4H4v-2h2v2zm0-4H4V9h2v2zm0-4H4V5h2v2zm4 12H8v-2h2v2zm0-4H8v-2h2v2zm0-4H8V9h2v2zm0-4H8V5h2v2zm10 12h-8v-2h2v-2h-2v-2h2v-2h-2V9h8v10zm-2-8h-2v2h2v-2zm0 4h-2v2h2v-2z',
        fillColor: '#e25a00',
        fillOpacity: 0.95,
        scale: 3,
        strokeColor: '#fff',
        strokeWeight: 3,
        anchor: new google.maps.Point(12, 24)
    };
   
    var template = Handlebars.compile($('#marker-content-template').html());

var marker =[] ;
var info1 = null;
    var closeDelayed = [] ;
    var closeDelayHandler = function(e) {
        console.log("hada") ;
        $(info1.getWrapper()).removeClass('active');
        setTimeout(function() {
            closeDelayed[e] = true;
            info1.close();
        }, 300);
    };


for (i = 0; i < locations.length; i++) {

    var lan =locations[i][0] ; 
    var lant = locations[i][1] ;
    console.log(lan +lant) ;
marker[i] = new google.maps.Marker({
    icon: markerIcon,
    position: new google.maps.LatLng(lan, lant),
    map: map,
});

info1 = new SnazzyInfoWindow({
        marker: marker[i],
        wrapperClass: 'custom-window',
        offset: {
            top: '-72px'
        },
        edgeOffset: {
            top: 50,
            right: 60,
            bottom: 50
        },
        border: false,
        closeButtonMarkup: '<button type="button" class="custom-close">&#215;</button>',
        content: template({
            title: 'Site de Casablanca'+locations[i][0],
            subtitle: '33.5731° N, 7.5898° W',
            bgImg: 'https://sunnyexcursion.com/wp-content/uploads/2020/09/Casablanca-places-to-visit.jpg',
            body: 
                 '<p>Casablanca is a port city and commercial hub in western Morocco, fronting the Atlantic Ocean. The city s French colonial legacy is seen in its downtown Mauresque architecture, a blend of Moorish style and European art deco. Standing partly over the water, the enormous Hassan II Mosque, completed in 1993, has a 210m minaret topped with lasers directed toward Mecca</p>' 
                 
        }),
        callbacks: {
            open: function() {
                $(this.getWrapper()).addClass('open');
            },
            afterOpen: function() {
                var wrapper1 = $(this.getWrapper());
                wrapper1.addClass('active');
                console.log(closeDelayed[i]);

                wrapper1.find('.custom-close').on('click', closeDelayHandler(i));
            },
            beforeClose: function() {
              
                if (!closeDelayed[i]) {
                    closeDelayHandler(i);
                    return false;
                }
                return true;
            },
            afterClose: function() {
                console.log("hadi") ;
                var wrapper1 = $(this.getWrapper());
                wrapper1.find('.custom-close').off();
                wrapper1.removeClass('open');
                closeDelayed[i] = false;
            }
        }
    });
 



}




  // As with JSON, use the Fetch API & ES6
 
    // Set up handle bars

    
    // Add a Snazzy Info Window to the marker
    




    

</script>