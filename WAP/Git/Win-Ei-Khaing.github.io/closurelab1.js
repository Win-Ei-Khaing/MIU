// function delayMsg2() {
//     if (timer === null) {
//         timer = setInterval(rudy, 1000);
//     } else {
//         clearInterval(timer);
//         timer = null;
//     }
// }

var rudyTimer = (function() {
    function rudy() {
        document.getElementById("output").innerHTML += "Rudy!";
    }

    var timerRef = null;
    return {
        run: function() {
            if (timerRef == null)
                timerRef = setInterval(rudy, 1000);
            else {

                clearInterval(timerRef);
                timerRef = null;
            }
        }
    };

})();