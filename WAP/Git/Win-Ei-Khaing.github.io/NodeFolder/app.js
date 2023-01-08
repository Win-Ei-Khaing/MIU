var http = require('http');

const play = require('./play');
play.violin();
play.clarinet();

http.createServer(function(req, res) {
    res.writeHead(200, { 'Content-Type': 'text/html' });
    res.end(play.violin() + "<br>" +
        play.clarinet());
}).listen(8080);