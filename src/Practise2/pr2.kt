package lr2

import kotlin.random.Random

fun main() {
    val randomNumber = generateRandomNumber()
    println(getParity(randomNumber))
    println(multiplyBasedOnEvenOdd(randomNumber))
    println(getNegativeNumber(randomNumber))
    println(calculateYearsOld(randomNumber))
    println(findSmallest(generateRandomList(randomNumber)))
    println(findTwoBiggestNumbers(generateRandomList(randomNumber)))
    println(countPositivesSumNegatives(generateRandomList(randomNumber)))
    println(countVowelsInString("Hello World"))
    println(findMiddleCharacter("studdent"))
    printMultiplicationTable(generateRandomTableSize())
}

fun getParity(number: Int): String {
    return if (number % 2 == 0) "Even" else "Odd"
}

fun multiplyBasedOnEvenOdd(number: Int): Int {
    return if (number % 2 == 0) number * 4 else number * 5
}

fun getNegativeNumber(number: Int): Int {
    return -number
}

fun calculateYearsOld(birthYear: Int): Int {
    return (System.currentTimeMillis() / (1000L * 60 * 60 * 24 * 365) - birthYear / 100).toInt() + 1
} // Uses current year for age calculation

fun findSmallest(numbers: List<Int>): Int {
    return numbers.minOrNull() ?: 0
}

fun findTwoBiggestNumbers(numbers: List<Int>): List<Int> {
    val sortedNumbers = numbers.sortedDescending()
    return sortedNumbers.subList(0, 2)
}

fun countPositivesSumNegatives(numbers: List<Int>): List<Int> {
    val positiveCount = numbers.count { it > 0 }
    val negativeSum = numbers.filter { it < 0 }.sum()
    return listOf(positiveCount, negativeSum)
}

fun countVowelsInString(str: String): Int {
    val vowels = listOf('a', 'e', 'i', 'o', 'u', 'y')
    return str.count { it.toLowerCase() in vowels }
}

fun findMiddleCharacter(str: String): String {
    val middleIndex = str.length / 2
    return if (str.length % 2 == 0) {
        str.substring(middleIndex - 1, middleIndex + 1)
    } else {
        str[middleIndex].toString()
    }
}

fun generateRandomTableSize(): Int {
    return Random.nextInt(1, 11)  // Generates table size between 1 and 10 (inclusive)
}

fun generateRandomNumber(): Int {
    return Random.nextInt(-100, 101)
}

fun generateRandomList(size: Int): List<Int> {
    return List(size) { Random.nextInt(-100, 101) }
}

fun printMultiplicationTable(size: Int) {
    val matrix = List(size) { i ->
        List(size) { j -> (i + 1) * (j + 1) }
    }
    for (row in matrix) {
        for (cell in row) {
            print("$cell\t")
        }
        println()
    }
}
