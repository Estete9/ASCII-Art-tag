fun identity(value: Int) = value
fun half(value: Int) = value / 2
fun zero(value: Int) = 0

fun generate(functionName: String): (Int) -> Int {
    when (functionName) {
        "identity" -> return ::identity
        "half" -> return ::half
        "zero" -> return ::zero
        else -> return :: zero
    }
}
