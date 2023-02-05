package com.example.kotlinfundamendals.interfacedemo

import lesson2.interfacedemo.MyInterface

class InterfaceImp : MyInterface {

    override val test: Int = 25
    override fun print() = "Kotlin"


}