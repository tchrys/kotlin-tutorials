//fun main() {
//    // without SAM conversions
//    var isEven = object : IntPredicate {
//        override fun accept(i: Int): Boolean {
//            return i % 2 == 0
//        }
//    }
//
//    // using lambda
//    isEven = IntPredicate { it % 2 == 0}
//    println("${isEven.accept(5)}")
//}
//
//// an interface with only one abstract method is called a functional interface / single abstract method interface
//fun interface IntPredicate {
//    fun accept(i: Int): Boolean
//}