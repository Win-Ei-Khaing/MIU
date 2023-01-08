"use strict";
var timer = null;
function decrement(){
	var min = document.getElementById('min').value;
	var sec = document.getElementById('sec').value;
	if(sec > 0) {
		sec--;
	} else if (min > 0) {
		min--;
		sec = 59;
	} else {
		clearInterval(timer);
		timer = null;
		document.body.style.backgroundColor = "red";
	}

	function countdown() {
		if(timer === null) {
			timer = setInterval(decrement, 1000);
		}
	}
	window.onload.getElementById('go').onclick = countdown;
}