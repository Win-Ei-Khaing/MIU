package com.example.kotlinfundamendals
//Data Types.kt
fun main(args: Array<String>) {
    val name: String = "Kotlin"  // Constant
   //  name = name + " " + "Programming"      // val cannot ne reassigned
    // Declaring Boolean
    var isAwesome:Boolean = true
    println("Is " + name + " awesome? The answer is : " + isAwesome)


    //Declaring String
    var hero: String
    hero = "batman"
    println(hero)
    hero = "superman"
    println(hero)

    var a: Int = 3  // Variables
    var b = 6 // No need to specify the type. Kotlin infer the type from the value

    println(a + b)

    // Declaring various number types
    val doubleNum: Double = 123.456784 //64 bit number
    val floatNum: Float = 123.45f // 32 bit
    val longNum = 1237819283712L // 64 bit

    // Calling methods
    println(doubleNum)
    println(floatNum)
    println(longNum)
    val value = 3.14959265358979323
// round to 2 decimal: 3.14 --> "%.2f".format(value).toDouble()
    var res = "%.2f".format(value)
    println(" Value with two Decimal : $res")
}