var express = require('express');
var path = require('path');
var app = express();

app.use(express.urlencoded({ extended: false }))

app.use('/cssFiles', express.static(__dirname + '/styles'))

app.get('/', function(req, res) {
    res.sendFile('index.html', {
        root: path.join(__dirname, './views')
    });
});

app.post('/', function(req, res) {
    res.end('bye bye ' + req.body.username);
});

app.listen(3000);