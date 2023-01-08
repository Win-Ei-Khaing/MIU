const express = require("express");
const app = express();

app.use(express.urlencoded({ "extended": false }));

app.get("/", (req, res) => {
    res.send(`<a href='add'>Add to session</a> <br>
            <a href='view'>View session</a>`);
});
app.get("/add", (req, res) => {
    res.send(`<form method='POST'>
              <input name='key'>
              <input name='value'>
              <input type='submit'>
            </form>`);
});
app.get("/view", (req, res) => {
    let view = "<ul>";
    view += `<li>Win</li>`;

    view += "</ul><a href='/'>back</a>";
    res.send(view);
});
app.post("/add", (req, res) => {
    res.redirect(303, "/view");
});
app.listen(3000);