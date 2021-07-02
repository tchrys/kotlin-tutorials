import java.lang.Exception
import java.lang.IllegalStateException

fun main() {
    val name = "abc"
    // string interpolation
    println("Name $name")

    // read-only list
    val list = listOf("a", "b")

    // read-only map
    val map = mapOf("a" to 1, "b" to 2)

    // traverse a map
    for ((k, v) in map) {
        println("$k -> $v")
    }

    // lazy property
    val p: String by lazy { "a" }

    val myObject = object : MyAbstractClass() {
        override fun doSomething() {
            TODO("Not yet implemented")
        }

        override fun sleep() {
            TODO("Not yet implemented")
        }
    }
    myObject.doSomething()

    // if-not-null-else shorthand
    val files: List<Int>? = null
    println(files?.size ?: "empty")

    // execute a statement if null
    val aa = files?.size ?: throw IllegalStateException("exception")

    // execute if not null
    files?.let {
        list -> print(list)
    }

    // call multiple methods on an object instance
    with(myObject) {
        doSomething()
        sleep()
    }

}

// extension functions
fun String.dummyFn() { "a" }

// getters, setters, equals, hashcode, toString, copy
data class Customer(val name: String, val email: String)

// default values for function parameters
fun foo(a: Int = 0, b: String = "") {
    TODO("reason")
}

// create a singleton
object Resource {
    val name = "Name"
}

abstract class MyAbstractClass {
    abstract fun doSomething()
    abstract fun sleep()
}

// try-catch expression
fun test() {
    val result = try {
        TODO()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}