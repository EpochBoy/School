
var express = require("express");
var app = express();
var fs = require("fs");

var request = require('request');


app.get("/", function(oReq, oRes){
  request('http://www.google.com', function (error, response, body) {
    //console.log('error:', error); // Print the error if one occurred
    //console.log('statusCode:', response && response.statusCode); // Print the response status code if a response was received
    //console.log('body:', body); // Print the HTML for the Google homepage.
    oRes.send(body);
  });
});


app.listen(10063, function(err, data){
  console.log("Server is listenning on port: 10063");
});
