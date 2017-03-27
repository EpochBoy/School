//we need to use express
//routing system, server
var express = require("express");
var app = express(); //Constructor

//WRONG APPROACH
var fs = require("fs");

//point to the root( object request)
app.get("/", function(oReq, oRes) {
  //THE WRONG APPOACH is without function callbacks.
  var sIndexHtml = fs.readFileSync("views/index.html", "utf8"); //Read the file in sync. WRONG APPROAH!
  //Pretent that you connect to a controller and get the
  //nickname from a database, session;
  var sNickname = "nickname2";
  var sNickLastName = "nicklastname2";
  //replace nickname with real name;
  sIndexHtml = sIndexHtml.replace("{{nickname}}", sNickname);
  sIndexHtml = sIndexHtml.replace("{{nickLastName}}", sNickLastName);
  console.log(sIndexHtml);
  oRes.send(sIndexHtml);

});

//create a channel - functions you think APIs
app.get("/create-game", function(req, res) {
  res.send("Game created succesfully");
});

//server
app.listen(3334, function() {
  console.log("SEVER IS LISTING ON PORT 3334")

});
