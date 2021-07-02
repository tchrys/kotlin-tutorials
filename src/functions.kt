fun main() {
    // spread operator
    foo(strings = *arrayOf("a", "b", "c"))

    // infix notation
    println(1 shl 2)

    val items = listOf(1, 2, 3, 4, 5)

    // Lambdas are code blocks enclosed in curly braces.
    items.fold(0, {
        // When a lambda has parameters, they go first, followed by '->'
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        result
    })


    // Lambda expressions and anonymous functions are function literals. Function literals are functions
    // that are not declared but passed immediately as an expression
    val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
    val twoParameters: (String, Int) -> String = repeatFun // OK

    fun runTransformation(f: (String, Int) -> String): String {
        return f("hello", 3)
    }
    val result = runTransformation(repeatFun) // OK

    // A value of a function type can be invoked by using its invoke(...) operator: f.invoke(x) or just f(x).
    val stringPlus: (String, String) -> String = String::plus
    println(stringPlus.invoke("<-", "->"))

}

class TreeNode(val parent: TreeNode)

inline fun <reified T> TreeNode.findParentOfType(): T? {
    var p = parent
    while (p != null && p !is T) {
        p = p.parent
    }
    return p as T?
}


fun foo(vararg strings: String) { /*...*/ }

infix fun Int.shl(x: Int): Int = this.shl(x)

//A local function can access local variables of outer functions (the closure)
class Graph(val vertices: List<Vertex>)
class Vertex(val neighbors: List<Vertex>)

fun dfs(graph: Graph) {
    val visited = HashSet<Vertex>()
    fun dfs(current: Vertex) {
        if (!visited.add(current)) return
        for (v in current.neighbors)
            dfs(v)
    }

    dfs(graph.vertices[0])
}

// high-order functions example
fun <T, R> Collection<T>.fold(
    initial: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

// operator overloading
data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)