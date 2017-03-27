var express = require("express");
var app = express();

var aNicknames = [];

//app.post has unlimited URL size
//http://localhost:1250
// app.get("/", function(req, res)
// {
//   var sNickname = req.query.nickname;
//   var secretMessage = req.query.secretmessage;
//   //http://localhost:1250/?nickname=Killer
//   //http://localhost:1250/?nickname=Killer&secretmessage=FUCKERSDIE
//   res.send("Welcome " + sNickname + " " +secretMessage);
// });


// We will not get a new way of JQuery with / instad of ,?, &.
// game.com/new-user/KILLER
// game.com/new-user/MEGAKILLER
// url could also be written: /new-user/:nickname/:message
// this url gives the same result.
// http://localhost:1250/new-user/Killer/message/hello
// app.get("/new-user/:nickname/message/:message", function(req,res)
// {
//   // now instead of query we use params
//   var sNickname = req.params.nickname;
//   var sMessage = req.params.message;
//   res.send(sNickname+" says: "+sMessage);
// });


app.get("/", function(req, res)
{
  res.sendFile(__dirname + "/index.html");
});

  // if (aNicknames.includes(sNickname))
app.get( "/new-user/:nickname/msg/:message" , function( req , res ){
	var sNickname = req.params.nickname;
  var sMessage = req.params.message;
  var prntMessage = sNickname+": "+sMessage;

	if( aNicknames.indexOf( sNickname ) == -1 )
  {
		aNicknames.push( prntMessage );
		console.log("NEW PLAYER IN THE SYSTEM");
	}
  else
  {
		console.log("SORRY, CHOOSE A DIFFERENT NICKNAME");
	}
	console.log( aNicknames );
	res.send( "WELCOME" );
});

app.get("/users", function(req,res){
  //convert the array to text
  var saNicknames = JSON.stringify( aNicknames );
  console.log(saNicknames);
  res.send(saNicknames);
  // res.json(aNicknames);
});

app.listen(1250, function(err)
{
    if(err)
    {
      console.log("Cannot listen to Port 1250");
      return;
    }
    console.log("listening to port 1250");

});
