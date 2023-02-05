fun main(){
    var wantToContinue=true

    while(wantToContinue) {
        print("Enter weight : ")
        var input = Integer.parseInt(readLine())

        print("""|1 Venus
            |2 Mars
            |3 Jupiter
            |4 Saturn
            |5 Uranus
            |6 Neptune
            |Choose Planet(1 to 6) : 
        """.trimMargin())

        var choice = readLine()

        val result = when (choice) {
            "1"-> input*0.78
            "2" -> input*0.39
            "3" -> input*2.65
            "4" -> input*1.17
            "5" -> input*1.05
            "6" -> input*1.23
            else -> "$choice is invalid."
        }
        println("Weight $input equals to $result")

        print(("""|
            |Do you want to do again? Y/N : """.trimIndent()).trimMargin())

        var decision= readLine()
        wantToContinue = decision.equals("Y") || decision.equals("Yes")
    }
}