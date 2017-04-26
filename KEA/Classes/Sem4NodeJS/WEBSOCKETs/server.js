// Create a normal express server
var express = require("express");
var app = express();
// Create the socket server
var server = require("http").Server(app);
var io = require("socket.io")(server);


// var aPlayers = ["Dennis", oSocket];
//////////////////////////////////////////////////////////////
// When working with Sockets, everything todo with our connection
// is within io.on's brackets. It won't work anywhere else
io.on("connection", function( oSocket ){
  console.log("A Client Connected");


    /*
      var iIndexOfPlayers = aPlayers.indexOf("Dennis"); // 0
      aPlayers[iIndexOfPlayers+1].emit("dbewfbewbf")
    */

  	oSocket.on( "this is the color" , function( jData ){
  		var sColor = jData.color;
  		// io.emit( "change to this color" , {"color":sColor} ); // send to every socket/client
      //oSocket.emit( "change to this color" , {"color":sColor} ); // the client itself
      oSocket.broadcast.emit( "change to this color" , {"color":sColor} ); // This broadcasts to everyone except the one that triggered the action
  	});

    oSocket.on( "hand over the players", function ( jData ){
      oSocket.emit("whatever I am free to write any string", { "players": [{},{},{}] }) // This send an array of "Players back".
    });

    // This is only an example, it doesn't work. Just the idea of how to deal with a Singe user;
    // oSocket.on( "register me", function ( jData ){
    //   var sNickname = jData.nickname;
    //   aPlayers.push(sNickname);
    //   aPlayers.push(sNickname);
    // });


    // this takes 2 params, a (message, jData)
    // io.emit("Welcome to Hell", {"message":"THIS IS SOO SIMPLE"});

    // oSocket.on("hi server I am clicking the button", function( jData ){
    // console.log("Yes i know you clicked the Button");
    // });

});


//////////////////////////////////////////////////////////////
app.get( "/", function( req , res ){
  res.sendFile(__dirname + "/index.html");
});

// start the server and socket on this port
// NOTICE SERVER.LISTEN instead og APP
server.listen(80, function(){
  console.log("Server Running on Port 80");
});
