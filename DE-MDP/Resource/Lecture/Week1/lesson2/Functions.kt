package lesson2

fun main(args: Array<String>) {
    var res = multiply(5,50) // Function calling
    println("Result : $res")
    // Local Function
    val name = "John"
    val count = 5
    fun displayString() {
        for (index in 1..count) {
            println(name)
        }
    }
    displayString()

    // Making use of Default arguments and passing values
    var message = buildMessageFor(count = 10)
    println(message)

    message = buildMessageFor("John") // Valid
    println(message)
    // message = buildMessageFor(10) // Invalid
    message = buildMessageFor(count = 10) // Valid if you use name of the argument = value
    message = buildMessageFor("Jack",50) // Valid
    println(message)
    // Can also change the order by using argument name
    message = buildMessageFor(count = 35, name = "Jack") // Valid
    println(message)
}
fun multiply(x: Int, y: Int )= x * y
// Example for Default Arguments
fun buildMessageFor(name: String = "Customer", count: Int = 0): String {
    return("$name, you are customer number $count")
}