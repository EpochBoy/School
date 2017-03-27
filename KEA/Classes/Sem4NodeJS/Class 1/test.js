var name = "Fredrik";
var lastName = "Bjørklund";

//Exercise
console.log(name+" "+lastName);

var year = "2017";
var number = 1;


//Add the year plus the number
//Result should be 2018
//You cannot touch line 1 or 2

console.log(parseInt(year)+number);
//Number funnction converts String to a number.
//Does the same as above, but works with floats and doubles also.
console.log(Number(year)+number);

//Another way of converting numbers
var numberOneShow = "1";
var numberTwoShow = "2";

var total = (+numberOneShow)+(+numberTwoShow);
console.log(total);

// add those two numbers and show the result
// you cannot touch line 1 neither line 2
var numberOne = "1.10";
var numberTwo = "2.30";

var total2 = parseFloat(numberOne)+parseFloat(numberTwo);

console.log(total2);
console.log(Number(numberOne)+Number(numberTwo));
//Add decimals, using toFixed() and defining the number via 2 to TWO decimals.
console.log(total2.toFixed(2));


var one = "10";
var two = "45";
var three = "98";

var sum = Number(one) + Number(two) + Number(three);
var average = sum/3;
avg = average.toFixed(5);

console.log(avg);




// array position

var letters = ["a","b","c"];
// show in the console b
console.log(letters[1]);
console.log(letters[2], letters[0], letters[1]);

if (letters[0] == "a") {
  console.log(letters[1]);
}


//Print letter amount of times as specified by integer before it.
var letters = [2, "a", 3, "b", 5, "c"];

//My Solution
for (var i = 0; i < letters.length; i++) {
  if (Number.isInteger(letters[i])) {
    //var a = letters[i];
    for (var j = 0; j < letters[i] ; j++) {
      console.log(letters[i+1]);
    }
  }
}

//Ryver Solution
var letters = [ 1,"a",1,"b",1,"c"];

for( var i = 0; i < letters.length; i+=2 ){
for( var j = 0; j < letters[i]; j++ ){
console.log(letters[i+1]);
}
}

var name = "Troels";
var lastname = "Lindeblad-Rivenes";
console.log(name+" "+lastname);
