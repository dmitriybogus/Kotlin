package Practise3

import kotlin.random.Random

fun main() {
    // Варіанти гри
    val options = listOf("Камінь", "Ножиці", "Папір")

    // Випадковий вибір комп'ютера
    val computerChoice = options[Random.nextInt(options.size)]

    // Вибір користувача
    var userChoice: String?
    do {
        println("Введіть ваш вибір (Камінь, Ножиці, Папір):")
        userChoice = readLine()?.trim()
    } while (userChoice !in options)

    // Визначення результату
    val result = when {
        computerChoice == userChoice -> "Нічия!"
        computerChoice == options[0] && userChoice == options[2] -> "Ви перемогли!"
        computerChoice == options[1] && userChoice == options[0] -> "Ви перемогли!"
        computerChoice == options[2] && userChoice == options[1] -> "Ви перемогли!"
        else -> "Ви програли!"
    }

    // Виведення результату
    println("Комп'ютер вибрав: $computerChoice")
    println("Ваш вибір: $userChoice")
    println(result)
}