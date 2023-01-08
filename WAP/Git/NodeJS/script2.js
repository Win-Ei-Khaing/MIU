var express = require('express');
var path = require('path');
var app = express();

app.use((req, res, next) => {
    console.log('This is always run');
    next();
    //res.end("This is end");
});
app.use('/add-product', (req, res, next) => {
    console.log('In the middleware!');
    res.send('<h1>The "Add Product" Page</h1>');
});
app.use('/', (req, res, next) => {
    console.log('In another middleware!');
    res.send('<h1>Hello from Express</h1>');
});

app.listen(3000);