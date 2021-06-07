package `in`.deanja

class LongConstant {
    fun longConstant(): String {
        val cont: String = "*".repeat(80) +
                "Anthony" +
                "*".repeat(80)
        return cont
    }
}

fun main(args: Array<String>) {
    val lg : LongConstant = LongConstant();
    val s: String = lg.longConstant();
    println("Hello, $s")
}