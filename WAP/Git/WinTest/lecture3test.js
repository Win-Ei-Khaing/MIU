(function() {
    "use strict";

    var b = 1000;

    function f() {
        b = 100;
        var a = 10;
        var z = a + b;
        alert(z);

        function g() {
            alert(2 * z);
            return 2 * z;
        }

        var b = 30;
        return g;
    }

    var x = f();
    x();
    alert(b);

    // var f = [];
    // for (let i = 0; i < 3; i++) {
    //     alert(i);
    //     f[i] = function() { alert(i) };
    //     alert("f[" + i + "] -> " + i);
    // }
    // f[0]();
    // f[1]();
    // f[2]();
    // var x = 1;

    // function a() {
    //     var y = 2;
    //     var sum = function() {
    //         var z = 3;
    //         return x + y + z;
    //     };
    //     y = 10;
    //     return sum;
    // }
    // var b = a();
    // alert(b());

    // function a() {
    //     var name = "Win";

    //     function display() {
    //         alert(name);
    //     }
    //     return display();
    // }
    // var b = a();
    // b();

    // function sum(x, y, ...last) {
    //     let total = x + y;
    //     for (let i = 0; i < last.length; i++)
    //         total += last[i];
    //     return total;
    // }
    // alert(sum(1, 2, 3));
    // alert(sum(4));


    // var f1 = function(x = 10) {
    //     alert("Hello world " + x);
    // };
    // f1();
    // var aa = f1;
    // aa(100);
    // (function f1() {
    //     alert("Hello world");
    // })();

    // var f2 = () => alert("Hello world");
    // f2();

    // (() => alert("Hello world 4"))();

    // var f3 = (x, y) => alert("Hello world 5 " + (x * y));
    // f3(2, 4);

    // function findMax() {
    //     let max = -Infinity;
    //     for (let i = 0; i < arguments.length; i++) {
    //         if (arguments[i] > max)
    //             max = arguments[i];
    //     }
    //     return max;
    // }

    // alert(findMax(1, 2, 3, 4, 5));
    // alert(findMax());
    // alert(findMax("a", "b", "c"));

    // var f1 = function(name) {
    //     alert("hello world " + name);
    // };

    // function v1(name, f) {
    //     return f1(name);
    // };

    // v1("win");
    // f1("ei");


    // function v2(name) {
    //     return function() { alert(name) };
    // }

    // v2("khaing")();
    // var x = 1;
    // alert(x + "___" + y);
    // var y = 2;
    // alert(x + "___" + y);

    // const a;
    // a = 10;
    // alert(a);
    // for (let i = 0; i < 3; i++) {
    //     const a = 11 + i;
    //     alert(a);
    // }
    // alert(a);

    // var a = 1;
    // alert(a);
    // for (var i = 0; i < 3; i++) {
    //     a += 30;
    //     var a = 10;
    //     alert(a);
    //     var b = 11;
    // }
    // alert(i);
    // alert(b);
})();