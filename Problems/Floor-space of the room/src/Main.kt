import java.util.*
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val shape = scanner.nextLine()
    var area = 0.0
    when (shape) {
        "circle" -> {
            val r = scanner.nextDouble()
            area = r * r * 3.14
        }
        "triangle" -> {
            val a = scanner.nextDouble()
            val b = scanner.nextDouble()
            val c = scanner.nextDouble()
            val s = (a + b + c) * 0.5
            area = sqrt(s * (s - a) * (s - b) * (s - c))
        }
        "rectangle" -> {
            val a = scanner.nextDouble()
            val b = scanner.nextDouble()

            area = a * b
        }
    }
    println(area)
}