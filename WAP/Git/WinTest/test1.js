var x = 1;
var a = 5;
var b = 10;
var c = function(a, b, c) {
    var x = 10;
    alert(x);
    alert(a);
    var f = function(a, b, c) {
        b = a;
        alert(b);
        b = c;
        var x = 5;
    }
    f(a, b, c);
    alert(b);
}
c(8, 9, 10);
alert(b);
alert(x);