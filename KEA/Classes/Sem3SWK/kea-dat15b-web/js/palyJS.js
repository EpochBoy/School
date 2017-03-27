/**
 * Created by coag on 13-10-2016.
 */

function sayHi() {
    var name = document.getElementById('myInput').value;
    document.getElementById("myTxt").innerHTML = "Hi " + name;
//        console.log("Hi " + name);
}
/*
 alert("Hello world!");
 console.log("Hello world!");
 document.getElementById("myP").innerHTML = "Hello world";

 var x = 5;
 console.log(x);
 x = "Alice";
 console.log(x);
 x = 'Alice';
 console.log(x);
 x = true;
 console.log(x);


 console.log(5+2);//7
 console.log(5-2);//3
 console.log(5*2);//10
 console.log(5/2);//2.5
 console.log(5%2);//1


 console.log(5 > 2);
 console.log(5 <= 2);
 console.log(5 == "5"); //true
 console.log(5 === "5"); //false
 console.log("5" === "5"); //true
 console.log(5 != "5"); //false
 console.log(5 !== "5"); //true

 console.log(true && false); //false
 console.log(true & false); //0
 console.log(3 & 7); //3
 console.log(true || false); //true
 console.log(!(true || false)); //false
 console.log(true | false); //1

 var a = [5, 3, false, 8, "bob", 10, "alice"];
 console.log(a);


 var names = ["Mark", "Sky", "Mathias", "Alice"];
 console.log(names);
 names.sort();
 console.log(names);

 var nos = [10, 2, 13, 5, 16];
 console.log(nos);
 nos.push(1234);
 x = nos.pop();
 console.log(x);

 nos.sort(function (x, y) {
 return x - y;
 });
 console.log(nos);


 sayHi("Alice");
 */

/*
 console.log(5 - 3);//2
 console.log(5 + 3);//8
 console.log("5" + 3 + 2);//532
 console.log(5 + 2 + "3");//73
 console.log(5 - "3 øl");//2
 var yyy;
 console.log(yyy+"52");//2

 var fru = ["Orange", "Apples", "Bananas", "Pineapple"];
 var ani = ["cat", "pig", "humans", "dennis"];

 var x = fru.concat(ani);
 console.log(x);

 var pers = {
 name: "Alice",
 age: "36",
 sayAge: function () {
 return "My name is "+ this.name + ". I'm " + this.age + " year(s) old."
 }
 }

 pers.age = 21;
 pers.color = "blue";
 console.log(pers.sayAge());

 console.log(pers);


 if(5>3){
 console.log("YES");
 } else {
 console.log("NO");
 }

 var name = "alice";

 switch (name){
 case 'alce': console.log("Sky is Blue"); break;
 default: console.log("Sky is a student in 15B");
 }

 for (var i = 0; i<10; i++){
 console.log('alice');
 }

 while (i<100){
 console.log('alice');
 i++;
 }

 console.log('ahoj from the DARK SIDE');
 */
