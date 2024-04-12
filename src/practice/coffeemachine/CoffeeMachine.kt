package practice.coffeemachine
import java.util.concurrent.TimeUnit
import practice.coffeemachine.CoffeeType.*
import practice.coffeemachine.Resource.*


class CoffeeMachine(
    private var water: Int = 400,
    private var milk: Int = 540,
    private var coffeeBeans: Int = 120,
    private var disposableCups: Int = 9,
    private var money: Int = 550
) {

    fun makeCoffee(type: CoffeeType) {
        when (type) {
            ESPRESSO -> makeEspresso()
            LATTE -> makeLatte()
            CAPPUCCINO -> makeCappuccino()
        }
    }

    private fun makeEspresso() {
        if (checkResources(ESPRESSO)) {
            useResources(ESPRESSO)
            water -= 250
            coffeeBeans -= 16
            money += 4

            println("I have enough resources, making you a coffee!")
            TimeUnit.SECONDS.sleep(1)  // Wait for 1 second

            println("Grinding coffee beans")
            TimeUnit.SECONDS.sleep(1)

            println("Boiling water")
            TimeUnit.SECONDS.sleep(1)

            println("Mixing boiled water with crushed coffee beans")
            TimeUnit.SECONDS.sleep(1)

            println("Pouring coffee into the cup")
            TimeUnit.SECONDS.sleep(1)

            println("Pouring some milk into the cup")
            TimeUnit.SECONDS.sleep(1)

            println("Here's your ESPRESSO")
            TimeUnit.SECONDS.sleep(1)

        } else {
            print("Sorry, not enough resources!")
        }
    }

    private fun makeLatte() {
        if (checkResources(LATTE)) {
            useResources(LATTE)
            water -= 350
            milk -= 75
            coffeeBeans -= 20
            money += 7

            println("I have enough resources, making you a coffee!")
            TimeUnit.SECONDS.sleep(1)  // Wait for 1 second

            println("Grinding coffee beans")
            TimeUnit.SECONDS.sleep(1)

            println("Boiling water")
            TimeUnit.SECONDS.sleep(1)

            println("Mixing boiled water with crushed coffee beans")
            TimeUnit.SECONDS.sleep(1)

            println("Pouring coffee into the cup")
            TimeUnit.SECONDS.sleep(1)

            println("Pouring some milk into the cup")
            TimeUnit.SECONDS.sleep(1)

            println("Here's your LATTE")
            TimeUnit.SECONDS.sleep(1)
        } else {
            print("Sorry, not enough resources!")
        }
    }

    private fun makeCappuccino() {
        if (checkResources(CAPPUCCINO)) {
            useResources(CAPPUCCINO)
            water -= 200
            milk -= 100
            coffeeBeans -= 12
            money += 6

            println("I have enough resources, making you a coffee!")
            TimeUnit.SECONDS.sleep(1)  // Wait for 1 second

            println("Grinding coffee beans")
            TimeUnit.SECONDS.sleep(1)

            println("Boiling water")
            TimeUnit.SECONDS.sleep(1)

            println("Mixing boiled water with crushed coffee beans")
            TimeUnit.SECONDS.sleep(1)

            println("Pouring coffee into the cup")
            TimeUnit.SECONDS.sleep(1)

            println("Pouring some milk into the cup")
            TimeUnit.SECONDS.sleep(1)

            println("Here's your CAPPUCCINO")
            TimeUnit.SECONDS.sleep(1)
        } else {
            print("Sorry, not enough resources!")
        }
    }

    private fun checkResources(type: CoffeeType): Boolean {
        return when (type) {
            ESPRESSO -> water >= 250 && coffeeBeans >= 16
            LATTE -> water >= 350 && milk >= 75 && coffeeBeans >= 20
            CAPPUCCINO -> water >= 200 && milk >= 100 && coffeeBeans >= 12
        }
    }

    private fun useResources(type: CoffeeType) {
        when (type) {
            ESPRESSO -> {
                water -= 250
                coffeeBeans -= 16
            }
            LATTE -> {
                water -= 350
                milk -= 75
                coffeeBeans -= 20
            }
            CAPPUCCINO -> {
                water -= 200
                milk -= 100
                coffeeBeans -= 12
            }
        }
    }

    fun addResources(water: Int, milk: Int, coffeeBeans: Int, disposableCups: Int) {
        this.water += water
        this.milk += milk
        this.coffeeBeans += coffeeBeans
        this.disposableCups += disposableCups
    }

    fun takeMoney() {
        val moneyToTake = money
        money = 0
        println("I gave you $moneyToTake")
    }

    fun printResources() {
        println("The coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$coffeeBeans ml of coffee beans")
        println("$disposableCups of disposable cups")
        println("$money $ of money")
    }
}