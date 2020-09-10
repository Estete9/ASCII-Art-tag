package signature

import java.io.File
import java.util.*

val scanner = Scanner(System.`in`)
var nameString = scanner.nextLine()!!
var statusString = scanner.nextLine()!!.toLowerCase()

var counter = 0

//reads the fonts' files and transforms them in a List of strings
val romanRowListFull = File("E:/Users/cepal/Downloads/Android studio resources/ASCII Art/roman.txt").readLines(Charsets.US_ASCII)
val mediumRowListFull = File("E:/Users/cepal/Downloads/Android studio resources/ASCII Art/medium.txt").readLines(Charsets.US_ASCII)

//makes a list with the first 2 characters, turns them into int so we can get the height of each font
val romanFontSize = (0 until 1).map { h -> (0 until 1).fold("") { height, _ -> height + romanRowListFull[h].substring(0, 2) } }[0].toInt()
val mediumFontSize = (0 until 1).map { h -> (0 until 1).fold("") { height, _ -> height + mediumRowListFull[h].substring(0, 2) } }[0].trim().toInt()

val romanRowList = romanRowListFull.subList(1, romanRowListFull.lastIndex)
val mediumRowList = mediumRowListFull.subList(1, mediumRowListFull.lastIndex)

//    calculates the length of the name when converted to ASCII
val nameLength = (0 until 1).joinToString { h ->
    nameString.fold("") { acc, c ->
        if (c != ' ') {
            if (c.isUpperCase()) acc + romanRowList[h + (c - 'A' + 26) * 11 + 1]
            else acc + romanRowList[h + (c - 'a') * 11 + 1]
        } else "$acc          "
    }
}.length

//    calculates the length of the status when converted to ASCII
val statusLength = (0 until 1).joinToString { h ->
    statusString.fold("") { acc, c ->
        if (c != ' ') acc + mediumRowList[h + (c - 'a') * 4 + 1] else "$acc     "
    }
}.length

//    getting the longest string comparing the name and the status after turned to ASCII
var greatestLength = if (nameLength > statusLength) nameLength + 2 else statusLength + 2

var baseRow = "88  88"
var printingRow = "88  88"
var borders = "88888"

val stringBuilder: StringBuilder = StringBuilder()


fun main() {
//    creating the border string using the greatestLength + 5 (borders)
    repeat(greatestLength) { stringBuilder.append("8") }
    borders = baseRow.replaceRange(2..baseRow.lastIndex - 2, "8${stringBuilder}8")
    baseRow = stringBuilder.toString().replace("8", " ")
    println(borders)

//    makes and prints each row taking the nameString and turning it into ASCII
    (0 until romanFontSize).map { h ->
        nameString.fold("") { acc, c ->
            if (c != ' ') {
                if (c == 'Z' && h == 9) acc + romanRowList[h + (c - 'A' + 26) * 11] else {
                    if (c.isUpperCase()) acc + romanRowList[h + (c - 'A' + 26) * 11 + 1]
                    else acc + romanRowList[h + (c - 'a') * 11 + 1]
                }
            } else "$acc          "
        }
    }.forEach {
        counter++
        printingRow = if (nameLength % 2 == 0) {
            baseRow.replaceRange((greatestLength / 2 - it.length / 2) until (greatestLength / 2 + it.length / 2 + 1), it)
//            }
        } else {
            if (greatestLength % 2 == 0) {
                baseRow.replaceRange((greatestLength / 2 - it.length / 2 - 1) until (greatestLength / 2 + it.length / 2 + 1), it)
            } else {
                baseRow.replaceRange((greatestLength / 2 - it.length / 2) until (greatestLength / 2 + it.length / 2 + 2), it)

            }
        }
//            printingRow = baseRow.replaceRange((greatestLength / 2 - it.length / 2) until (greatestLength / 2 + it.length / 2 + 1), it)
        if (counter == 10) print("88 $printingRow  88") else {
            println("88 $printingRow  88")
            counter = 0
            printingRow = baseRow.replace("[a-z]".toRegex(), " ")
        }
    }
//    makes and prints each row taking the statusString and turning it into ASCII
    (0 until mediumFontSize).map { h ->
        statusString.fold("") { acc, c ->
            if (c != ' ') acc + mediumRowList[h + (c - 'a') * 4 + 1] else "$acc     "
        }
    }.forEach {
        counter++
        printingRow = if (statusLength % 2 == 0) {
            baseRow.replaceRange((greatestLength / 2 - it.length / 2) until (greatestLength / 2 + it.length / 2 + 1), it)
        } else {
            if (greatestLength % 2 == 0) {
                baseRow.replaceRange((greatestLength / 2 - it.length / 2 - 1) until (greatestLength / 2 + it.length / 2 + 1), it)
            } else {
                baseRow.replaceRange((greatestLength / 2 - it.length / 2) until (greatestLength / 2 + it.length / 2 + 2), it)
            }
        }
//        printingRow = baseRow.replaceRange((printingRow.length / 2 - it.length / 2) until (printingRow.length / 2 + it.length / 2 + 1), it)
        if (counter == 3) print("88 $printingRow  88") else {
            println("88 $printingRow  88")
            counter = 0
        }
    }
    println(borders)
}
