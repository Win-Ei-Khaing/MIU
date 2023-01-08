function alertWin() {
    win = "win";
    //alert(win);
}

// alertWin();
// alert(win);

var pt = {
    x: 4,
    y: 3,
    distanceFromOrigin: function() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
};
// alert(pt.distanceFromOrigin());
// alert(pt.x);

function printMe() {
    alert("Hello " + this.winName);
}

//var name = "Win Ei Khaing";

function person(name, age) {
    this.name = name;
    this.age = age;
    this.show = function() {
        alert(this.name + "___" + this.age);
    };
};

var t = new person("win ei khaing", 24);
t.show();

function car(model, owner) {
    this.model = model;
    this.owner = owner;
}

var c = new car("Honda 2021", t);
alert(c.owner.name);
c.owner.show();