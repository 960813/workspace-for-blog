package enumTest

import java.io.BufferedReader
import java.io.LineNumberReader
import java.io.Reader
import java.lang.reflect.Constructor


object SingleTonTest {

}

enum class EnumTest(
    val identifier: String
) {
    Number("number");
}

class Aaa(
    val a: String,
    val b: String
){}

fun main() {
//    val enum = EnumTest::class.java
//    val constructors = enum.getDeclaredConstructor()
//    constructors.isAccessible = true
//    val instance = constructors.newInstance()
//    println(instance)

//    val constructor = SingleTonTest::class.java.getDeclaredConstructor()
//    constructor.isAccessible = true
//    val instance = constructor.newInstance()
//    println(instance)
//
//    val declaredConstructor = Aaa::class.java.getDeclaredConstructor()
//    declaredConstructor.isAccessible = true
//    val ins = declaredConstructor.newInstance()
//    println(ins)

}

