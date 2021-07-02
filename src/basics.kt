fun main() {
    println("Hello world")

    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("Fits in range")
    }

    val list = listOf("a", "b", "c")
    if (list.size !in list.indices) {
        println("out of range")
    }

    for (a in 1..10 step 2) {
        print(a)
    }

    println()

    for (b in 9 downTo 0 step 3) {
        print(b)
    }

    for ((index, value) in list.withIndex()) {
        println("the element at $index is $value")
    }

}

fun sum(a: Int, b: Int) = a + b

fun maxOf(a: Int, b : Int) = if (a > b) a else b

open class Shape

class Rectangle(var height: Double, var length: Double): Shape() {
    var perimeter = (height + length) * 2
}

fun getStringLength(obj: Any?): Int? {
    if (obj is String) {
        // automatic cast
        return obj.length
    }
    return null
}