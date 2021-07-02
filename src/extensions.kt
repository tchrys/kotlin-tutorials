// extensions - special declarations that provide an ability to extend a class
// with new functionality without having to inherit from the class
fun main() {
    MyClass.printCompanion()
}

class MyClass {
    companion object {} // will be called companion
}

fun MyClass.Companion.printCompanion() { println("companion") }


fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

// nullable receiver
fun Any?.toString(): String {
    if (this == null) return "null"
    return toString()
}

// extension properties
// ! initializers are not allowed for extension properties
val <T> List<T>.lastIndex: Int
get() = size - 1