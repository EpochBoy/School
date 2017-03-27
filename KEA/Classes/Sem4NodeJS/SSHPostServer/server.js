
var http = require("http");
var express = require("express");
var app = express();
var fs = require("fs");

var request = require('request');

//Server:
//
// app.get("/", function(req,res){
//   res.send('kjrwbwrgbwrgb');
// });

//Client / GO TO http://localhost:8787
app.get("/", function(oReq, oRes){
  request("http://217.61.218.68:10063", function(error, response, body){
    oRes.send('');
    console.log(body);
  });
});


app.listen(8787, function(err, data){
  console.log("Server is listenning on port: 8787");
});
