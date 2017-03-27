// work with files - this takes time.
// to work with files we need to use a filesystem


var fs = require("fs"); // this is embedded inside Node.

// The way we have done this program is the wrong way of doing it,
// because we don't access the file asynchronously but synchronously.
// utf8 is what makes it possible for us to console.log sData. Without it fails.
//var sData = fs.readFileSync(__dirname+"/data.txt", "utf8");
// console.log(sData);

//Correct way, with a function callback and callback is always the last argument
fs.readFile(__dirname + "/data.txt", "utf8", function(err, data){
  // how to extract nickname
  var jData = JSON.parse(data);
  console.log(jData[0].nickname);
  //console.log(data);
});
