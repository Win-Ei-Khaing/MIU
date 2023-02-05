class EBook: Book {
    var filetype="pdf"

    constructor(title: String, author: String, price: Double, filetype: String) : super(title, author, price) {
        this.filetype=filetype
    }

    override fun read() {
        println("Read from Electronic Device")
    }

    fun print(){
        println("""|EBook
        |Title : $title
        |Author : $author
        |Price : $$price
        |FileType : $filetype
        |""".trimMargin())

    }
}