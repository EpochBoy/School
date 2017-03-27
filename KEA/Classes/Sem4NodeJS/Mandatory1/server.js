// A NodeJS server using express framework

// We need this to use express
var express = require("express");
// This is the constructor for express
var app = express();


var fs = require("fs");

//We point to the Root. This is our landing page.
app.get("/", function( oReq, oRes)
{
  //We tell express where our Index.html file is and store it in sIndex...
  var sIndexHtml = fs.readFileSync("view/index.html", "utf8");

  var sNick = "Forneus Brandt";

  sIndexHtml = sIndexHtml.replace("{{sNick}}",sNick);
  console.log(sIndexHtml);
  oRes.send(sIndexHtml)

});

// This is where we make our server.
app.listen(8080, function(){
  console.log("Server is listening on port 8080");
});

// Here we create a second server.
app.listen(9090, function(){
  console.log("Server2 is listening on port 9090");
});
