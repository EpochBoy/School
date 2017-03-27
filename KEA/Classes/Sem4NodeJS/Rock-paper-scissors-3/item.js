//"jItem" is for the local variable. Like the "constructor"
//Remember to add the module.exports in the end of the object
var jItem = {};

jItem.fnFinalPrice = function(price, discount){
  var iFinalPrice = price - discount;
  return iFinalPrice;
}

module.exports = jItem;
