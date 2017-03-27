//require's is good prectise to have at the top
var express = require("express");
var jUser = require(__dirname + "/user");
var jItem = require(__dirname + "/item");
var jShoe = require(__dirname + "/shoe");
var jEntryPoint = require(__dirname + "/entryPoint");

var app = express();

//If the file is in the same dir
//or "./user".

console.log(jUser.fnGetName());
console.log(jUser.fnGetLastName());
console.log(jUser.fnConcatName("lasse", "bjoerklund"));
console.log(jItem.fnFinalPrice(100, 10));
console.log(jShoe.fnGetGenderPrice(100, "female"));
console.log(jEntryPoint.fnCallSubObject());

/*
app.get("/login", function(req, res) {
  console.log("Trying to login");
  res.send("LOGIN");
});


app.listen(10023, function() {
  console.log("Server listening to port 10023");
});
*/
