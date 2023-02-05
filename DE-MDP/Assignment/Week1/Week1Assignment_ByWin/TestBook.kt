fun main(args: Array<String>) {
    var book = Book("About Burma", "Win", 1000.0)
    book.read()
    println("""|Book
        |Title : ${book.title}
        |Author : ${book.author}
        |Price : $${book.price}
        |""".trimMargin())


    val eBook= EBook("About USA", "Ei", 10.0, "kindle")
    eBook.read()
    eBook.print()

    eBook.filetype="epub"
    eBook.print()
}
