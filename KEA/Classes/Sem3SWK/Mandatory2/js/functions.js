/**
 * Created by forneus on 24/11/2016.
 */


$(document).ready(function () {
    getOffers();
    getAccountInfo();
    setInterval(getOffers, 1000);
    setInterval(getAccountInfo,1000);

    changeBackground();

    var sellButton = document.getElementById('submitSale').onclick=function(){
      sellOffer();
      var sellInput = document.getElementById('sellAmount');
      sellInput.value = '';
    };

    var getRate = document.getElementById('getRate').onclick=function(){
      getExchangeRate();
    }

    function getOffers(){
        $.ajax({
            'url': 'http://52.57.228.6/man2API/php/BankPhp.php',
            'type': 'GET',
            'data': {
                'what':'offers',
                'apikey':'e66fca751e738afcf8c7aea2856342c8'
            },
            'success': function(offersString) {
                var jsonObj = JSON.parse(offersString);
                var offers = jsonObj.data;
                console.log(offers);
                populateTable(offers);
            }
        });
    }
});


function populateTable(offers) {
    var offersTable = document.getElementById('tradingtable');

    var offersTableView =
        "<tr>" +
        "<th>ID</th>"+
        "<th>Amount</th>"+
        "<th>Currency</th>"+
        "<th>Since</th>"+
        "<th>Buy Button</th>"+
        "</tr>";

    for(var i in offers){
        offersTableView +=
            "<tr>"+
            "<td>"+offers[i].id+"</td>"+
            "<td>"+offers[i].amount+"</td>"+
            "<td>"+offers[i].currency+"</td>"+
            "<td>"+offers[i].since+"</td>"+
            "<td><button onclick='buyOffer("+offers[i].id+")' id="+offers[i].id+">BUY</button></td>"+
        "</tr>"
    }
    offersTable.innerHTML = offersTableView;

}

function buyOffer(id) {
    $.ajax({
        'url':'http://52.57.228.6/man2API/php/BankPhp.php',
        'type':'GET',
        'data':{
            'what':'buy',
            'offer': id,
            'apikey': 'e66fca751e738afcf8c7aea2856342c8'
        },
        'success' : function () {}
    });

}

function sellOffer(){
  var amount = document.getElementById('sellAmount').value;

      $.ajax({
          'url':'http://52.57.228.6/man2API/php/BankPhp.php',
          'type':'GET',
          'data':{
              'what':'sell',
              'amount': amount,
              'apikey': 'e66fca751e738afcf8c7aea2856342c8'
          },
          'success' : function () {}
      });
}

function getExchangeRate(){
  var fromRate = document.getElementById('fromCurrency').value;
  var toRate = document.getElementById('toCurrency').value;
  var rate = document.getElementById('gotRate');

  $.ajax({
    'url':'http://52.57.228.6/man2API/php/BankPhp.php',
    'type':'GET',
    'data':{
        'what':'exchange_rate',
        'from': fromRate,
        'to': toRate,
        'apikey': 'e66fca751e738afcf8c7aea2856342c8'
    },
    'success' : function (datastring) {
      var jsonObj = JSON.parse(datastring);
      rate.innerHTML = jsonObj.data.amount;
    }
  });
}

function getAccountInfo(){

  $.ajax({
      'url':'http://52.57.228.6/man2API/php/BankPhp.php',
      'type':'GET',
      'data':{
          'what':'account_info',
          'apikey': 'e66fca751e738afcf8c7aea2856342c8'
      },
      'success' : function (datastring) {
        var jsonObj = JSON.parse(datastring);

        var accountAmount = jsonObj.data[0].amount;
        var accountCurrency = jsonObj.data[0].currency;

        var amountLabel = document.getElementById('amountInfo');
        var currencyLabel = document.getElementById('currencyInfo');

        amountLabel.innerHTML = accountAmount;
        currencyLabel.innerHTML = accountCurrency;
      }
  });

}


function changeBackground(){
  $("#mainheading").on("click", function(){
    $("#mainbody").css("background-color", "red");
  });
}
