fun main() {
    val array = arrayOf(2, 3)
    for (index in array.indices) {
        if (array[index] == array[index + 1]) println("yes")
    }
}
