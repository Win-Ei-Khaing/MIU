package com.example.kotlinfundamendals

import lesson2.Person

fun main(args: Array<String>) {
    // Creating an Instance of a Data Class
    var p1 = Person("John","David",35)
    var p2 = Person("John","David",35)
    // Print the current status of p1
    println(p1)
    // Accessing the members of p1

    val fn = p1.fname
    val ln = p1.lname
    var age = p1.age
    // Making use of Object methods
    println(p1 == p2) // similar to println(p1.equals(p2))
    println(p1.hashCode())

    /*Kotlin will generate a componentN() function which maps to that property,
     where ’N’ represents the properties order in the definition.*/
    println(p1.component1()) // Prints the first name
    println(p1.component2()) // Prints the last name
    println(p1.component3()) // Prints the age

    // Copy() function - Can Modify the values during the copy
    val p4: Person =  p1.copy() // Copy all the fields
    val p3: Person =  p1.copy( age = 40) // Copy name as Tim and age as 40
    println(p4)
    println(p3)

  }
