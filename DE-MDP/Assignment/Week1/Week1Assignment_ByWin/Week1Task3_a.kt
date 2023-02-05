fun main(){
    var wantToContinue=true

    while(wantToContinue) {
        print("Enter an Int value : ")

        var inputVal = Integer.parseInt(readLine())
        var result = inputVal

        if(inputVal>10)
            result = getFirstDigit(inputVal) * 10 + getLastDigit(inputVal)

        println("The last digit and first digit of the given Int value $inputVal : $result")

        print(("""|
            |Do you want to do again? Y/N : """.trimIndent()).trimMargin())

        var decision= readLine()
        wantToContinue = decision.equals("Y") || decision.equals("Yes")
    }
}

fun getFirstDigit(inputVal: Int): Int{
    var f=inputVal
    while(f>=10)
        f/=10
    return f
}

fun getLastDigit(inputVal: Int) = inputVal%10