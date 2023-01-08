const express = require("express");
var path = require('path');
const app = express();

app.use(express.urlencoded({ "extended": false }));

app.get("/", (req, res) => {
    res.sendFile('Calculator.html', {
        root: path.join(__dirname, './views')
    })
});

app.post("/", (req, res, next) => {
    console.log(req.body.num1 + " " + req.body.operation + " " + req.body.num2);
    var sum = 0;
    switch (req.body.operation) {
        case '+':
            sum = parseInt(req.body.num1) + parseInt(req.body.num2);
            break;
        case '-':
            sum = req.body.num1 - req.body.num2;
            break;
        case '*':
            sum = req.body.num1 * req.body.num2;
            break;
        case '/':
            // {
            //     if (req.body.num2 == 0)
            //         next(new Error('Can\'t divide by 0!'));
            sum = req.body.num1 / req.body.num2;
            break;
            //}
        case '%':
            // {
            //     if (req.body.num2 == 0)
            //         next(new Error('Can\'t divide by 0!'));
            sum = req.body.num1 % req.body.num2;
            break;
            //}
    }

    console.log("The Answer is :" + sum);

    res.send(`<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Simple Calculator</title>
    </head>
    <body>
        <p>The Answer is : ${sum}<p>
        <a href='/'>Another calculation</a>
    </body>
    </html>`);
});

app.get("/confirmation", (req, res) => {

});

app.listen(3000);