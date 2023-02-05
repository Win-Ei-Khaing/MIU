package lesson2

class StaticDemo{
    companion object {
        // static count
        var count:Int=0;
        // static getCount()
        fun getCount(){
            print("No. of objects="+count)
        }
    }
    //constructor
    constructor(){
        count++
    }
}

fun main(args: Array<String>) {
    //object 1
    StaticDemo()
    // object 2
    StaticDemo()
    //method called using class name
    StaticDemo.getCount()
}
