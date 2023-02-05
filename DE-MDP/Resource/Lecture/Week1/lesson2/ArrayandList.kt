package lesson2

fun main(args:Array<String>){
    var myArray = arrayOf(1, 2, 3)
    var arraySize = "myArray has ${myArray.size} items"
    var firstItem = "The first item is ${myArray[0]} "
    println(firstItem )
    var temp = intArrayOf(4,6,7,8)
    for(index in temp){
        println(index)
    }
     var lang : Array<String> = arrayOf("C++","Java","Kotlin","Python","Scala")
    println("Language Array")
    lang.forEach { println(it) }

    println("Name Array")
    var names = arrayOf("James","Anne","Bruce","Tom","Benny")
    for ((ind,v) in names.withIndex()) {
        println("$ind" + " Index = $v")}
      // ArrayList
        println("Language ArrayList")
        var llist = ArrayList<String>(arrayListOf("C++","Java","HTML"))
        llist.add("Kotlin")
        llist.add("Scala")
        llist.add("Ruby")
        println(llist)
    }
