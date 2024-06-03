package Practise4

import kotlin.random.Random

fun main() {
    // Введення даних про зал
    println("Введіть кількість рядів: ")
    val rows = readln().toInt()
    println("Введіть кількість місць у ряду: ")
    val seatsPerRow = readln().toInt()

    // Створення масиву для зберігання стану місць
    val seats = Array(rows) { IntArray(seatsPerRow) { 0 } }

    // Меню програми
    while (true) {
        showMenu()
        val choice = readln().toInt()

        when (choice) {
            1 -> showSeats(seats)
            2 -> buyTicket(seats, rows, seatsPerRow)
            3 -> showStatistics(seats, rows, seatsPerRow)
            0 -> break
            else -> println("Неправильний вибір!")
        }
    }
}

fun showMenu() {
    println("1. Показати місця")
    println("2. Купити квиток")
    println("3. Статистика")
    println("0. Вихід")
    print("> ")
}

fun showSeats(seats: Array<IntArray>) {
    for (row in seats) {
        for (seat in row) {
            print(if (seat == 0) "S" else "B")
            print(" ")
        }
        println()
    }
}

fun buyTicket(seats: Array<IntArray>, rows: Int, seatsPerRow: Int): Int {
    var rowNum: Int
    var seatNum: Int

    do {
        print("Введіть номер ряду: ")
        rowNum = readln().toInt()
    } while (rowNum < 1 || rowNum > rows)

    do {
        print("Введіть номер місця в ряду: ")
        seatNum = readln().toInt()
    } while (seatNum < 1 || seatNum > seatsPerRow)

    val seatIndex = rowNum - 1
    val seatPrice = getTicketPrice(rowNum, rows, seatsPerRow)

    if (seats[seatIndex][seatNum - 1] == 0) {
        seats[seatIndex][seatNum - 1] = 1
        println("Ціна квитка: $$seatPrice")
        return seatPrice
    } else {
        println("Це місце вже заброньовано!")
        return 0
    }
}

fun showStatistics(seats: Array<IntArray>, rows: Int, seatsPerRow: Int) {
    val purchasedTickets = seats.sumBy { row -> row.count { it == 1 } }
    val percentage = purchasedTickets.toDouble() / (rows * seatsPerRow) * 100
    val currentIncome = getTicketPrice(1, rows, seatsPerRow) * purchasedTickets
    val totalIncome = rows * seatsPerRow * getTicketPrice(1, rows, seatsPerRow)

    println("Кількість проданих квитків: $purchasedTickets")
    println("Відсоток: ${"%.2f".format(percentage)}%")
    println("Поточний дохід: $$currentIncome")
    println("Загальний дохід: $$totalIncome")
}

fun getTicketPrice(rowNum: Int, rows: Int, seatsPerRow: Int): Int {
    return if (rows * seatsPerRow <= 60) {
        10
    } else {
        if (rowNum <= rows / 2) {
            10
        } else {
            8
        }
    }
}
