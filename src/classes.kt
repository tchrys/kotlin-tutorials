import java.lang.AssertionError

fun main() {

}

// primary constructor can not contain any code
// initialization code can be placed in initializer blocks(prefixed with the init keyword)
// during an instance initialization, init blocks and property initializers are executed in the order of appearance
class Person(firstName: String, lastName: String, var isEmployed: Boolean = true)

// if the constructor has annotations / visibility modifiers, the constructor keyword is required
class Client public constructor(name: String)

// if the class has a primary constructor, each secondary constructor needs to delegate to the primary constructor
class Person2(val name: String) {
    var children: MutableList<Person2> = mutableListOf()
    constructor(name: String, parent: Person2): this(name) {
        parent.children.add(this)
    }
}

// Any - common superclass
// Any has 3 methods: equals, hashCode, toString
// to make a class inheritable, use open keyword
open class Base(p: Int)
class Derived(p: Int) : Base(p)

open class Shape2 {
    open fun draw() {}
    final fun fill() {}
}

class Circle(): Shape2() {
    override fun draw() {}
}

// multiple implementations example
open class Rectangle2 {
    open fun draw() {}
}

interface Polygon {
    fun draw() {}
}

class Square(): Rectangle2(), Polygon {
    // it is mandatory to override this method
    override fun draw() {
        super<Rectangle2>.draw()
        super<Polygon>.draw()
    }
}

// difference between val and var props is that val does not allow a setter
class Example {
    val simple: Int? // has type Int, default getter, must be initialized in constructor
    val inferredType = 1 // has type Int and a default getter

    // custom accessors
    val isEmpty: Boolean
    get() = this.simple == 1

    // backing fields
    var counter = 0 // the initializer assigns the backing field directly
        set(value) {
            if (value >= 0)
                field = value  // field identifier can only be used in the accessors of the property
            // counter = value // ERROR StackOverflow: Using actual name 'counter' would make setter recursive
        }

    // backing properties
    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
    get() {
        if (_table == null) {
            _table = HashMap()
        }
        return _table ?: throw AssertionError("Set to null by another thread")
    }

    init {
        simple = 1
    }
}










