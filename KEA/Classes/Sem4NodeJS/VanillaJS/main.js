var myProm = new Promise( function (resolve, reject) {
  var r = new XMLHttpRequest();
  r.open("GET", "http://swapi.co/api/people/1");
  r.onreadystatechange = function () {
    if (r.readyState != 4 || r.status != 200){
      reject()
    } return;
    resolve(JSON.parse(this.responseText));
  };
  r.send();
});


const RenderContainer = function(response){
  console.log("rendering container")
  return response;
}
const list = function(response){
  console.log("rendering empty listElements: ", response)
  return response;
}
const RenderContent = function(response){
  console.log("rendering stuff into the listElements: ", response)
}

myProm.then(RenderContainer).then(list).then(RenderContent).catch(function(){
  console.log("Ran my.Prom");
});

// - make a promise that calls the starwars api
// - then calls a function that renders a cointainer
// - then calls a function that renders a list
// - then renders the characters from the StarWars api to that list



//
// // from http://vanilla-js.com
// // API: http://swapi.co/
// var r = new XMLHttpRequest();
// // 1st Param: POST, GET, DELETE / 2nd Param: URL to API / 3rd Param: Wether it Should be ASYNC or not
// r.open("GET", "http://swapi.co/api/people/1", true);
// // Param onreadystatechange eats a function.
// r.onreadystatechange = function () {
//   if (r.readyState != 4 || r.status != 200) return;
//   console.log("Success: " + r.responseText);
//   // code
//
// r.open("GET", "http://swapi.co/api/people/1", true);
//   // Param onreadystatechange eats a function.
// r.onreadystatechange = function () {
//   if (r.readyState != 4 || r.status != 200) return;
//   console.log("Success: " + r.responseText);
// };
//
// r.send();
