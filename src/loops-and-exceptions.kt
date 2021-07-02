import java.lang.IllegalStateException
import java.lang.Integer.parseInt

fun main() {
    // the type of return / break / continue is Nothing type
    val x = 1
    val s = x ?: return

    // loop@ is a label
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 5) break@loop
        }
    }

    // all exception classes inherit the class Throwable
    // try is an exception
    val a: Int? = try { parseInt("123") } catch (e: NumberFormatException) { null }

    // the type of the throw expression is the special type Nothing
    val t = x ?: throw IllegalStateException("reason")

    val p = null // p has type Nothing?

}

// Nothing type has no values and is used to mark code locations that can never be reached
// for instance, a function that never returns can be market with Nothing
fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}

fun foo() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return // non-local return directly to the caller of foo()
        print(it)
    }
    println("this point is unreachable")
}


fun foo2() {
    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
        if (value == 3) return  // local return to the caller of the anonymous function - the forEach loop
        print(value)
    })
    print(" done with anonymous function")
}