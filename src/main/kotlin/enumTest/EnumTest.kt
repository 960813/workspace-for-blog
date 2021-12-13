package enumTest


object SingleTonTest {

}

enum class EnumTest(
    val identifier: String
) {
    Number("number");
}

fun main() {
    val enum = EnumTest::class.java
    val constructors = enum.getDeclaredConstructor()
    constructors.isAccessible = true
    val instance = constructors.newInstance()
    println(instance)

//    val constructor = SingleTonTest::class.java.getDeclaredConstructor()
//    constructor.isAccessible = true
//    val instance = constructor.newInstance()
//    println(instance)
}


