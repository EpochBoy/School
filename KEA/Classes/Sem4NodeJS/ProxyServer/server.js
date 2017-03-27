
var express = require("express");

var app = express();
var fs = require("fs");

app.get("/", function(oReq, oRes){
  fs.readFile(__dirname + "/hi.txt", "utf8", function(err, data){
    oRes.send(data);
  });
});


app.listen(8537, function(err, data){
  console.log("Server is listenning on port: 8555");
});
