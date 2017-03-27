var jShoe = {};

jShoe.fnGetGenderPrice = function(iPrice, sGender) {
  var iFinalPrice = iPrice;
  if (sGender == "female") {
    var iTotalPrice = iFinalPrice * 0.75;
    return iTotalPrice;
  } else {
    return iFinalPrice;
  }
}

module.exports = jShoe;
