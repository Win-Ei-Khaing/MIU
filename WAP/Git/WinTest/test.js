var a = "Hello World";

function showA() {
    alert(a);
}

window.onload = function() {
    document.getElementById("b1").onclick = showA;
}