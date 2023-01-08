function f() {
    var a = 1, b = 20, c;
       alert(a + " " + b + " " + c);  

     function g() {
         var b = 300, c = 4000;
         alert(a + " " + b + " " + c); 
         a = a + b + c;
         alert(a + " " + b + " " + c); 
}
      alert(a + " " + b + " " + c); 
      g();
      alert(a + " " + b + " " + c); 
} 

