// generic types in java are invariant (List<String> is not a subtype of List<Object>)

// declaration-site variance: you can annotate the type parameter T of Source to make sure
// that it is only returned (produced) from members of Source<T>, and never consumed
interface Source<out T> {
    fun nextT(): T
}
// we can say that T is a covariant type parameter

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs
}

// in annotation makes a type parameter contravariant: it can only be consumed and never produced
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo2(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 has type Double, which is a subtype of Number
    // Thus, you can assign x to a variable of type Comparable<Double>
    val y: Comparable<Double> = x // OK!
}

// generic functions
fun <T> singletonList(item: T): List<T> {
    TODO()
}
val l = singletonList(1)

