const express = require('express');
const app = express();

app.use('/cssFiles', express.static(__dirname + '/styles'))

app.listen(3000, () => {
    console.log('Your Server is running on 3000');
})

app.use('/add-product', (req, res, next) => {
    console.log('In the middleware!');
    res.send('<h1>The "Add Product" Page</h1>');
});