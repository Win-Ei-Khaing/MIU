const express = require('express');
const app = express();

app.use(express.urlencoded({ extended: false }))

app.get('/add-product', (req, res, next) => {
    console.log('In the middleware!');
    res.send(`<form action="/product" method="post">
                <input type="text" name="title">
                <input type="submit">
               </form>`);
});

app.post('/product', (req, res, next) => {
    console.log(req.body);
    res.redirect('/');
});

app.get('/', (req, res, next) => {
    res.send('bye bye');
});

app.listen(3000);