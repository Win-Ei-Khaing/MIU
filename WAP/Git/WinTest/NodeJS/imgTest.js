const express = require('express');

const app = express();

//set view engine

app.set("view engine", "pug")



app.use('/img', express.static(__dirname + '/img'))



app.get('/', function(req, res) {

    res.render('imgTest', { imgName: 'happy' });

    //res.send("hello world");

});



app.listen(5000, function() {

    console.log('Node server is running..');

});