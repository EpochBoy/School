var subObject = require(__dirname + "/subObject");
var jEntryPoint = {}
jEntryPoint.fnCallSubObject = function() {
  return subObject.fnGetTestNumber();
}


module.exports = jEntryPoint;
