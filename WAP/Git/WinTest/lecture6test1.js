window.onload = function() {

    // var a1 = 1;
    // var a2 = 2;
    // var a3 = 3;

    // document.getElementById("btnSetTimeout").onclick = function() {
    //     // Scope B
    //     var b1 = 1;
    //     var b2 = 2;
    //     var b3 = 3;
    //     alert(a1);

    //     function YFunc() {
    //         // Scope C
    //         var c1 = 1;
    //         var c2 = 2;
    //         var c3 = 3;
    //         alert(a1);
    //         alert(b3);
    //     };
    //     YFunc();

    // };

    // function job(stbte) {
    //     return new Promise(function(resolve, reject) {
    //         if (state) {
    //             resolve('success');
    //         } else {
    //             reject('error');
    //         }
    //     });
    // }
    // let promise = job(true);
    // promise.then(function(data) {
    //         alert(data);
    //         return job(false);
    //     })
    //     .catch(function(error) {
    //         alert(error);
    //         return 'Error caught';
    //     });


    // const promise = new Promise((resolve, reject) => {
    //     resolve("Hattori");
    //     setTimeout(() => reject("Yoshi"), 500);
    // });
    // promise.then(val => alert("Success: " + val))
    //     .catch(e => alert("Error: " + e));



    // const promise = new Promise((resolve, reject) => {
    //     reject("Hattori");
    // });
    // promise.then(val => alert("Success: " + val))
    //     .catch(e => alert("Error: " + e));


    // var Employee = (function() {
    //     let myObject = {};

    //     let name;
    //     let age;
    //     let salary;

    //     let getName = function() {
    //         return name;
    //     };
    //     let getAge = function() {
    //         return age;
    //     };
    //     let getSalary = function() {
    //         return salary;
    //     };

    //     myObject.setName = function(newName) {
    //         name = newName;
    //     };
    //     myObject.setAge = function(newAge) {
    //         age = newAge;
    //     };
    //     myObject.setSalary = function(newSalary) {
    //         salary = newSalary;
    //     };
    //     myObject.increaseAge = function() {
    //         age = parseInt(getAge()) + 1;
    //     };
    //     myObject.increaseSalary = function(percentage) {
    //         salary = parseFloat(getSalary()) + (parseFloat(getSalary()) * (parseFloat(percentage) / 100));
    //     };
    //     myObject.showData = function() {
    //         alert(getName() + "-" + getAge() + "-" + getSalary());
    //     };

    //     return myObject;
    // })();

    // var address;

    // Employee.setAddress = function(newAddress) {
    //     address = newAddress;
    // };

    // Employee.getAddress = function() {
    //     return address;
    // };

    // Employee.setName("Win");
    // Employee.setAge("24");
    // Employee.setSalary(100);
    // Employee.showData();

    // Employee.increaseAge();
    // Employee.increaseSalary(90);
    // Employee.showData();

    // Employee.setAddress("Fairfield, Iowa");
    // alert(Employee.getAddress());


    // var address;

    //     return {
    //         setAddress: function(newAddress) {
    //             address = newAddress;
    //         },
    //         getAddress: function() {
    //             return address;
    //         },
    //         showDataWithAddress: function() {
    //             alert(getName() + "-" + getAge() + "-" + getSalary() + "-" + getAddress());
    //         }
    //     };
    // var add = (function() {
    //     var counter = 0;
    //     return function() {
    //         counter += 1;
    //         alert(counter);
    //         return counter;
    //     }
    // })();

    // var make_adder = function(num) {
    //     var counter = 0;
    //     return function() {
    //         return counter += num;
    //     };
    // };

    // var add5 = make_adder(5);
    // add5();
    // add5();
    // add5(); // final counter value is 15
    // var add7 = make_adder(7);
    // add7();
    // add7();
    // add7(); // final counter value is 21

    // var count = (function() {
    //     var counter = 0;
    //     return {
    //         add: function() {
    //             return counter += 1;
    //         },
    //         reset: function() {
    //             return counter = 0;
    //         },
    //         show: function() {
    //             alert(counter);
    //             return 0;
    //         }
    //     }
    // })();

    // count.add();
    // count.add();
    // count.add();
    // count.show();
    // count.reset();
    // count.show();
    // count.add();
    // count.show();
    // var foo = 1;

    // function bar() {
    //     alert(foo);
    //     if (!foo) {
    //         var foo = 10;
    //     }
    //     alert(foo);
    // }
    // bar();

    // var x = 9;

    // function myFunction() {
    //     return x * x;
    // }
    // alert(myFunction());
    // x = 5;
    // alert(myFunction());


    // if (x == 1)
    //     x = 30;

    // function test(x) {
    //     //var x = 2;
    //     alert(90);
    // }
    // test();

    // document.getElementById("btnSetTimeout").onclick = function() {
    //     alert(x);
    // };
};
// (function() {
//     "use strict";

//     var func1 = function(a, b) {
//         return a * b;
//     };
//     var func2 = function(a, b) {
//         return a + b;
//     };

//     function apply(a, b, f) {
//         return f(a, b);
//     }
//     var x = apply(2, 3, func1);
//     alert(x);
//     var y = apply(2, 3, func2);
//     alert(y);

//     function getAlert(str) {
//         return function() {
//             alert(str);
//         };
//     }

//     var a = getAlert("Hello world");
//     a();

//     window.onload = function() {
//         document.getElementById("btnSetTimeout").onclick = function() {
//             setTimeout(showResult, 2000);
//             document.getElementById("output").innerHTML = "coming soon....";


//         };

//         function showResult() {
//             document.getElementById("output").innerHTML += " here it is....";
//         }

//         function showPara(para) {
//             document.getElementById("output").innerHTML += para + "___";
//         }

//         var timer = null;
//         document.getElementById("btnSetInterval").onclick = function() {
//             if (timer == null)
//                 timer = setInterval(showPara, 2000, "win");
//             else {
//                 clearInterval(timer);
//                 timer = null;
//             }
//         };

//         document.getElementById("btnGoogle").onclick = function() {

//             //alert(document.getElementById("btnGoogle").style.fontSize);
//             //document.getElementById("btnGoogle").style.fontSize = "200px";
//             //alert(document.getElementById("btnGoogle").style.top);

//             //alert(document.getElementById("btnGoogle").className);
//             //document.getElementById("btnGoogle").style.backgroundColor = "red";
//             //document.getElementById("btnGoogle").className = "highlight";
//             //alert(document.getElementById("btnGoogle").className);
//             //         window.open("http://www.google.com", "My Google", "width=900,height=500");

//             //         alert(document.body);

//             //         alert(location.pathname);
//             //         location.reload();

//             //         alert(navigator.language);

//             //         alert(screen.width);

//             //         alert(history.length);
//             //         history.forward();
//         };
//     };

//     // var x = 3;

//     // function f(n) { alert("gonna + "); return n + 1; }

//     // function g(n) { alert("gonna - "); return n - 1; }
//     // x = f(x);
//     // alert(x);
// })();