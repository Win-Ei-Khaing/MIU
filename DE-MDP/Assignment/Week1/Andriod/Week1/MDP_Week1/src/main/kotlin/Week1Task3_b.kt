fun main(){
    var array1 = arrayOf(1, 2, 3, 4, 6, 5)
    println("Sum of Odds : ${getSumOfOdds(array1)}")

    var array2 = arrayOf(1, 2, 3, 4, 5, 6, 7)
    println("Sum of Odds : ${getSumOfOdds(array2)}")
}

fun getSumOfOdds(myArray: Array<Int>): Int{
    var result = 0
    for(i in myArray){
        if(i%2!=0)
            result+=i*i
    }
    return result
}