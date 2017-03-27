// Link to use: http://localhost:8787/send-email/purchase@forneus.net

'use strict';
const nodemailer = require('nodemailer');
var express = require('express');

var app = express();

// create reusable transporter object using the default SMTP transport
let transporter = nodemailer.createTransport({
    service: 'gmail',
    auth: {
        user: 'fredrikconstantin@gmail.com',
        pass: '3vilProto55'
    }
});

// setup email data with unicode symbols
// URL: http://localhost:8787/send-email/purchase@forneus.net
app.get("/send-email/:email", function(oReq, oRes){
  var email = oReq.params.email
  let mailOptions = {
    from: '"Fred Foo" <foo@blurdybloop.com>', // sender address
    to: email, // list of receivers
    subject: 'Hello TESTER', // Subject line
    text: 'THIS IS WORKING', // plain text body
    html: '<b>Hello world ?</b>' // html body
  };
  // send mail with defined transport object
  transporter.sendMail(mailOptions, (error, info) => {
    if (error) {
      return console.log(error);
    }
    console.log('Message %s sent: %s', info.messageId, info.response);
  });
  oRes.send(' ');
});


app.listen(8787, function(err, data){
  console.log("Server is listenning on port: 8787");
});
