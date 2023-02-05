package com.example.kotlinfundamendals

// Strings.kt - String Methods
fun main(args: Array<String>) {
    val str = "May the force be with you."
    println(str)
// Multiline String
    println("Trim Margin") //| delimeter to trim the margin
    val rawCrawl = """|A long time ago,
    |in a galaxy
    |far, far, away...
    |BUMM BUMM BUMMMM""".trimMargin()
    println(rawCrawl)
    println("Not Trim Margin")
    val rawCrawl1 = """A long time ago,
    in a galaxy
    far, far, away...
    BUMM BUMM BUMMMM"""
    println(rawCrawl1)
// Checking Equality
    val contentEquals = str.contentEquals("May the force be with you.")
    println(contentEquals)

    val contains = str.contains("Force", false)
    println(contains)
    val uppercase = str.toUpperCase()
    val lower = str.toLowerCase()

    println(uppercase)
    println(lower)

    val num = 6
    val stringNum = num.toString()
    println(stringNum)

    val subsequence = str.subSequence(0, 3) // end index excluded
    println("Subsequence = $subsequence")

    val luke = "Luke Sky walker"
    val lightSaberColor = "green"
    val vehicle = "land speeder"
    val age = 27
    // String Templates
    println("$luke has a $lightSaberColor lightsaber and drives a $vehicle and is $age years old")
    println("Lukes full name $luke has ${luke.toUpperCase()} characters")

}