var add = (function() {
    var counter = 0;
    return function() {
        return counter += 1;
    }
})();

var count = (function() {
    var counter = 0;
    return {
        add: function() {
            return counter += 1;
        },
        reset: function() {
            counter = 0;
        },
        get: function() {
            alert(counter);
        }
    };
})();
count.get();
count.add();
count.add();
count.get();
count.reset();
count.get();
// var foo = 1;
// alert(foo);

// function bar() {
//     alert(foo);
//     if (!foo) {
//         var foo = 10;
//     }
//     alert(foo);
// }
// bar();

// setTimeout(booyah1, 2000);
// setTimeout(booyah2(), 2000);

// function booyah1() {
//     alert("booyah1");
// };

// function booyah2() {
//     return function() {
//         alert("booyah2");
//     };
// };


// var x = 3;
// var y = 5;
// alert(x + "__" + y);
// var w;
// alert(!w);
// alert(!!w);
// if (!w)
//     w = 10;
// alert(w);
// var x = 5;

// alert(x);
// alert(!x);
// alert(!!x);

// var y = "aaa";

// alert(!!y);
// alert("2" * 3);
// alert("2" + 3);
// var add = (function() {
//     var counter = 0;
//     return function() {
//         counter += 1;
//         alert(counter);
//     };
// })();

// add();
// add();

// var f = function() {
//     return new Promise(function(resolve, reject) {
//         reject("Hello I'm reject");
//         resolve("resolving now");
//     });
// };
// f().then(data => alert(data))
//     .catch(error => alert(error));