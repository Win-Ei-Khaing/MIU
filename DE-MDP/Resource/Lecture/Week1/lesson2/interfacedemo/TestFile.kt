package lesson2.interfacedemo

import com.example.kotlinfundamendals.interfacedemo.InterfaceImp

fun main(args: Array<String>) {
    val obj = InterfaceImp()
    MyInterface.staticmeth()

    println("test = ${obj.test}")
    print("Calling hello(): ")

    obj.hello("Tim")

    print("Calling and printing print(): ")
    println(obj.print())
}