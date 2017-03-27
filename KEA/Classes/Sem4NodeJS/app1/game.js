var jGame = {
    "aPlayers": ["PlayerA", "PlayerB", "PlayerC", "PlayerD", "PlayerE", "PlayerF"],
    "aTempPlayers" : [],
    "aMatches": []
};


jGame.fnMatchPlayers = function() {
  // create a temporal array for selecting players and remove them
  jGame.aTempPlayers = jGame.aPlayers.slice();
  var iRandomNumber = jGame.fnGetRandomNumber(0, jGame)

}


jGame.fnGetRandomNumber = function(iMin, iMax) {
    var iRandomNumber = Math.round(Math.random() * (iMax - iMin)) + iMin;
    return iRandomNumber;
}



console.log(jGame.aPlayers);





module.exports = jGame;
