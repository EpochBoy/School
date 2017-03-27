//We need to use express routing system, server
var express = require("express");
var app = express(); // constructor of express

var fs = require("fs");

//point to the root
app.get("/", function( oReq , oRes )
{
  //The wrong approach is without a function call back to open
  //the index.html
  //http://localhost:3333
  var sIndexHtml = fs.readFileSync("views/index.html", "utf8");
  // This is the wrong approach, because it accesses the filesystem using the
  // harddisk, which slows down the system, so this is why we don't use this
  // approach in a real world scenario.
  // Pretend that you connect to a controller and get the nickname
  // form a database, session.
  var sNickname = "Rots";
  var lNickname = "Baron";
  //replace the placedholder with the real nickname
  sIndexHtml = sIndexHtml.replace("{{nickname}}",sNickname);
  sIndexHtml = sIndexHtml.replace("{{lastname}}",lNickname);
  console.log(sIndexHtml);
  oRes.send(sIndexHtml);
});

//create a channel - function you think API's
app.get("/create-game", function(oReq, oRes)
{
  //http://127.0.0.1:3333/create-game
  oRes.send("Game created succesfully");
});

// server
app.listen(6665,function()
{
  console.log("Server is listening on port 6665");
});

// server 2
app.listen(6666,function()
{
  console.log("Server is listening on port 6666");
});
