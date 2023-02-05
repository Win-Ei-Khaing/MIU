package lesson2

fun main(args: Array<String>) {
    var lang : Array<String> =
            arrayOf("C++","Java","Kotlin","Python","Scala")
    println("Numbers : ")
    displayStrings("one", "two", "three", "four")
    println("Languages : ")
    displayStrings(*lang) // * --> Spread out the inputs for vararg if it some collections

}
fun displayStrings(vararg strings: String){
    for (string in strings) {
        println(string)
    }
}