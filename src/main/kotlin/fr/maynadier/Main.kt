package fr.maynadier

class Greeter {
    fun greet(name: String = "World"): String {
        return "Hello, $name!"
    }
}

fun main() {
    val greeter = Greeter()
    println(greeter.greet())
}
