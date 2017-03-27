/**
 * Created by coag on 13-10-2016.
 */

$(document).ready(function () {
    var apiKey = 'your_key_here';
    // check for Geolocation support
    if (navigator.geolocation) {
        console.log('Geolocation is supported!');
    }
    else {
        console.log('Geolocation is not supported for this Browser/OS.');
    }

    navigator.geolocation.getCurrentPosition(function (position) {
        var startPos = position;
        var pos = {
            latitude: startPos.coords.latitude,
            longitude: startPos.coords.longitude
        };
        console.log(pos);

        var apiLink = "http://api.openweathermap.org/data/2.5/weather?lat=" + pos.latitude + "&lon=" + pos.longitude + "&appid=" + apiKey;

        //Send the AJAX call to the server
        $.ajax({
            //The URL to process the request
            'url': 'http://api.openweathermap.org/data/2.5/weather',
            //The type of request, also known as the "method" in HTML forms
            //Can be 'GET' or 'POST'
            'type': 'GET',
            //Any post-data/get-data parameters
            //This is optional
            'data': {
                'lat': pos.latitude,
                'lon': pos.longitude,
                'units': 'metric',
                'appid': apiKey
            },
            //The response from the server
            'success': function (data) {
                //You can use any jQuery/JavaScript here!!!
                console.log(data);
                var city = data.name;
                var temp = data.main.temp;
                var weather = data.weather[0].main;

                $('#currCity').append(city);
                $('#currTemp').append(temp);
                $('#currWeather').append(weather);
            }
        });

    });

    var roomId = 'room1';
    var roomId = 'room2';
    var roomId = 'room 3';
    //Send the AJAX call to the server
    $.ajax({
        //The URL to process the request
        'url': 'http://localhost/kea-dat15b-web/myAPI.php',
        //The type of request, also known as the "method" in HTML forms
        //Can be 'GET' or 'POST'
        'type': 'GET',
        //Any post-data/get-data parameters
        //This is optional
        'data': {
            "roomId": roomId
        },
        //The response from the server
        'success': function (dataString) {
            //You can use any jQuery/JavaScript here!!!
            data = JSON.parse(dataString);
            console.log(data);
            var roomId = data.roomId;
            var tempFromAPI = data.temp + data.units + "&deg;";

            $('#' + roomId).text("");
            $('#' + roomId).append(roomId+": "+tempFromAPI);
            doTheColors();
        }
    });



});

function doTheColors() {
    $('#home_plan').children('div').each(function () {
        var room = $(this);
        var x = room.text();
        console.log(x);
        var temp = x.match(/\d+/g)[1];
        console.log(temp);

        if (temp < 18) {
            room.css("background-color", "rgba(0, 0, 255, .5)");
        }
        if (temp >= 18 && temp <= 25) {
            room.css("background-color", "rgba(0, 255, 0, .5)");
        }
        if (temp > 25) {
            room.css("background-color", "rgba(255, 0, 0, .5)");
        }
        //$('#room1').text("hi");
    });
}
