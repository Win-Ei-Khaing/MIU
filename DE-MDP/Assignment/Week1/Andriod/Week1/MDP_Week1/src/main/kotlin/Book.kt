open class Book {
    var title=""
    var author=""
    var price=0.0

    constructor(title: String, author: String, price: Double){
        this.title=title
        this.author=author
        this.price=price
    }

    open fun read() {
        println("Reading Paper book")
    }
}