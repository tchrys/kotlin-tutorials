fun main() {
    // lazy() is a function that takes a lambda and returns an instance of Lazy<T>
    // which can serve as a delegate for implementing a lazy property
    val lazyValue: String by lazy {
        println("computed")
        "Hello"
    }

    val user = User(mapOf(
        "name" to "John Doe",
        "age"  to 25
    ))

}

// storing properties on a map
class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}