//JSON - the user is a JSON object
var jUser = {}; //"j" = json object

//function of a user. "fn" = function
//Key\/      -     value \/
jUser.fnGetName = function() {
  return "lasse"; //Returns name
}

jUser.fnGetLastName = function() {
    return "bjoerklund";
  }
  //"s" = string
jUser.fnConcatName = function(sFirstname, sLastname) {
  var sFullName = sFirstname + sLastname;
  //"return" is not invented to concatiinate or do math. Make a var first while doing math
  return sFullName;
}



//you have to make the object global
module.exports = jUser;
