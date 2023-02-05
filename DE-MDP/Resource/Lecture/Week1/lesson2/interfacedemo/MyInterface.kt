package lesson2.interfacedemo

interface MyInterface {

    val test: Int // You are not allowed to initialize the property, should be initialize in the class
    // Abstract method
    fun print() : String

    // default implementation
    fun hello(name: String) {
        println("Hello there, $name!")
    }
    // static method
    companion object{
        fun staticmeth(){
            println("Hello Static Method")
        }
    }
}
