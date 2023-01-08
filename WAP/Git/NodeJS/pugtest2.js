var http = require('http');
var fs = require('fs');
http.createServer(function(req, res) {
    fs.readFile('demofile1.html', function(err, data) {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.write(data);
        return res.end();
    });

    // fs.appendFile('mynewfile1.txt', 'Hello content!', function(err) {
    //     if (err) throw err;
    //     console.log('Saved!');
    // });

    // fs.writeFile('mynewfile1.txt', 'I wrote new', function(err) {
    //     if (err) throw err;
    //     console.log('Saved!');
    // });

    // fs.unlink('mynewfile1.txt', function(err) {
    //     if (err) throw err;
    //     console.log('File deleted!');
    // });

    //return res.end("hello world");
    console.log("hello i'm starting...");
}).listen(5000);