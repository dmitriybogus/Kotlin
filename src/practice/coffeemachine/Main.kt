package practice.coffeemachine
import practice.coffeemachine.*

fun main() {
    val coffeeMachine = CoffeeMachine()

    while (true) {
        println("\nWrite action (buy, fill, take, remaining, exit):")
        val action = readLine().toString().lowercase()

        when (action) {
            "buy" -> buyCoffee(coffeeMachine)
            "fill" -> fillResources(coffeeMachine)
            "take" -> takeMoney(coffeeMachine)
            "remaining" -> printResources(coffeeMachine)
            "exit" -> break
            else -> println("Invalid action!")
        }
    }

    println("\nThe coffee machine is turned off.")
}

private fun buyCoffee(coffeeMachine: CoffeeMachine) {
    println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    val choice = readLine().toString()

    when (choice) {
        "1" -> coffeeMachine.makeCoffee(CoffeeType.ESPRESSO)
        "2" -> coffeeMachine.makeCoffee(CoffeeType.LATTE)
        "3" -> coffeeMachine.makeCoffee(CoffeeType.CAPPUCCINO)
        "back" -> return
        else -> println("Invalid choice!")
    }
}

private fun fillResources(coffeeMachine: CoffeeMachine) {
    println("\nWrite how many ml of water do you want to add:")
    val waterToAdd = readLine().toString().toIntOrNull() ?: 0
    println("\nWrite how many ml of milk do you want to add:")
    val milkToAdd = readLine().toString().toIntOrNull() ?: 0
    println("\nWrite how many grams of coffee beans do you want to add:")
    val coffeeBeansToAdd = readLine().toString().toIntOrNull() ?: 0
    println("\nWrite how many disposable cups do you want to add:")
    val disposableCupsToAdd = readLine().toString().toIntOrNull() ?: 0

    coffeeMachine.addResources(waterToAdd, milkToAdd, coffeeBeansToAdd, disposableCupsToAdd)
    println("\nResources have been added!")
}

private fun takeMoney(coffeeMachine: CoffeeMachine) {
    coffeeMachine.takeMoney()
    println("\nMoney has been taken!")
}

private fun printResources(coffeeMachine: CoffeeMachine) {
    coffeeMachine.printResources()
}