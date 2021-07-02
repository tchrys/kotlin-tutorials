fun main() {
    val y = "sndsf"
    val myList = listOf<Int>(1, 2)

    // unsafe cast operator
    val x: String = y as String

    // safe cast operator (returns null on failure)
    val z: String? = y as? String

    // myList is List<Int> doesn't work (type erasure)
    // star-projected type
    if (myList is List<*>) {
        myList.forEach { println(it) } // the items are types as Any?
    }

    // is work on the non-generic part
    if (myList is ArrayList) {
        TODO()
    }
}