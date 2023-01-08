const express = require('express');
const app = express();
const fs = require('fs');
app.use(express.urlencoded({ extended: false }));
// app.use((req, res, next) => {
//     console.log("first app.use");
//     next();
// })


// app.use('/', (req, res, next) => {
//     console.log("third app.use");
//     next();
// })


// app.use('/', (req, res, next) => {
//     console.log("second app.use");
//     next();
// })
// app.get('/Add', (req, res, next) => {
//     console.log("fourth app.use");
//     res.send("adding");
// })

// app.use((req, res, next) => {
//     console.log('This is always run');
//     next();
// });
// app.use('/add-product', (req, res, next) => {
//     console.log('In the middleware!');
//     res.send('<h1>The "Add Product" Page</h1>');
// });
// app.use('/', (req, res, next) => {
//     console.log('In second  middleware!');
//     //res.send('<h1>Hello from second</h1>');
//     next();
// });
// app.use('/', (req, res, next) => {
//     console.log('In another middleware!');
//     res.send('<h1>Hello from Express</h1>');
// });

// app.get('/add-product', (req, res, next) => {
//     console.log('In the middleware!');
//     res.send('<form action="/product" method="post"><input name="title "><button type="submit">Submit</button></form>');
// });
// app.post('/product', (req, res, next) => {
//     console.log(req.body);
//     res.redirect('/add-product');
// });

// app.get('/', function(req, res) {
//     res.send('<html><body><h1>Hello World</h1></body></html>');
// });
// app.post('/submit-data', function(req, res) {
//     res.send('POST Request');
// });
// app.put('/update-data', function(req, res) {
//     res.send('PUT Request');
// });
// app.delete('/delete-data', function(req, res) {
//     res.send('DELETE Request');
// });

app.get('/', function(req, res, next) {
    fs.readFile('/file-does-not-exist', function(err, data) {
        if (err) {
            next(err) // Pass errors to Express.
        } else {
            res.send(data)
        }
    })
})

app.use('/', (req, res, next) => {
    console.log('In another middleware!');
    res.send('<h1>Hello from Express</h1>');
});

app.listen(3000, () => { console.log("running on 3000"); })