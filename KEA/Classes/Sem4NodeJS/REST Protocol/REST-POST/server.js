// var express = require("express");
// var app = express();
// var bodyParser = require('body-parser');
//
// app.use( bodyParser.json());
// app.use( bodyParser.urlencoded({"extended":true}));
//
// app.get("/", function(req,res){
//   res.sendFile(__dirname+"/index.html");
// });
//
// app.get("/game", function(req,res){
//   res.sendFile(__dirname+"/game.html");
// });
//
//
// app.get("/match/:nickname/:choice", function(req, res){
//   var sNickname = req.params.nickname;
//   var sChoice = req.params.choice;
//   console.log(sNickname, sChoice);
//   res.json({"response":"ok", "id":"420"});
// });
//
// app.post("/final", function(req, res){
//   var sName = req.body.txtName;
//   console.log(sName);
//   res.sendFile(__dirname+"/final.html");
// });
//
// app.post("/update/user", function(req, res){
//   var sId = req.body.txtId;
//   var sName = req.body.txtName;
//   var sLastName = req.body.txtLastName;
// });
//
// app.get("/delete/user", function(req, res){
//   var sId = req.params.id;
// });
//
// app.listen(8080, function(){
//   console.log("Server is listening on port 8080");
// });


var express = require("express");
var app = express();

var bodyParser = require("body-parser");

app.use( bodyParser.json() );
app.use( bodyParser.urlencoded( {"extended":false} ) );

// Create some players for testing
var jPlayerOne = {"nickname":"a","choice":""};
var jPlayerTwo = {"nickname":"b","choice":""};




app.get( "/game", function( req,res ){
	res.sendFile(__dirname+"/game.html");
});


app.get( "/match/:nickname/:choice" , function( req , res ){
	var sNickname = req.params.nickname;
	var sChoice 	= req.params.choice;
	console.log( sNickname , sChoice );
	if( sNickname == "a" ){
		jPlayerOne.choice =  sChoice;
	}else{
		jPlayerTwo.choice =  sChoice;
	}
	res.json({"response":"ok"});
});




app.get( "/result/:nickname" , function( req , res ){
	var sNickname = req.params.nickname;





	// WAITING
	if( jPlayerOne.choice == "" || jPlayerTwo.choice == "" ){
		res.json({"status":"wait"});
	}

	// EVEN
	if( jPlayerOne.choice == jPlayerTwo.choice  ){
		res.json( {"status":"even"} );
	}

  //ROCK
	if( jPlayerOne.choice == "rock" && jPlayerTwo.choice == "scissor" ){
		res.json( {"status":"winner","nickname":jPlayerOne.nickname} );
    jPlayerOne.choice = "";
    jPlayerTwo.choice = "";
	}
  if ( jPlayerOne.choice == 'rock' && jPlayerTwo.choice == 'paper') {
    res.json( {'status':'loser','nickname':jPlayerOne.nickname} );
  }

  // PAPER
  if( jPlayerOne.choice == "paper" && jPlayerTwo.choice == "rock" ){
    res.json( {"status":"winner","nickname":jPlayerOne.nickname} );
  }
  if ( jPlayerOne.choice == 'paper' && jPlayerTwo.choice == 'scissor') {
    res.json({'status':'loser','nickname':jPlayerOne.nickname});
  }

  //SCISSOR
  if( jPlayerOne.choice == "scissor" && jPlayerTwo.choice == "paper" ){
    res.json( {"status":"winner","nickname":jPlayerOne.nickname} );
  }
  if ( jPlayerOne.choice == 'scissor' && jPlayerTwo.choice == 'rock') {
    res.json({'status':'loser','nickname':jPlayerOne.nickname});
  }



});



app.listen(8080, function(){
	console.log("SERVER RUNNING");
});
