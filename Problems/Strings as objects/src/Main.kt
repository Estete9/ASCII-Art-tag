fun main() {
    val input = readLine()!!
    var str: String = ""
    str = when {
        input.isEmpty() -> ""
        input.first() == 'i' -> {
            (input.drop(1).toInt() + 1).toString()
        }
        input.first() == 's' -> {
            input.substring(1).reversed()
        }
        else -> input
    }
    println(str)
}