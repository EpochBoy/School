var jPlayer = require(__dirname + "/player.js");
var jGame = require(__dirname + "/game.js");
// start the server without players
var aPlayers = [];

jPlayer.fnCreatePlayer("Santiago");
jGame.aPlayers.push(jPlayer);
jPlayer.fnCreatePlayer("Sfoi");
jGame.aPlayers.push(jPlayer);

console.log(aPlayers);
