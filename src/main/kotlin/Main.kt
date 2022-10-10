import java.util.*

//Exchange rates
//Курс валют
private const val USD_RATE = 65.0
private const val EUR_RATE = 70.0
private const val JPY_RATE = 65.0


fun main() {

    val expenses = DoubleArray(7)
    val scanner = Scanner(System.`in`)

    println("Hello, i your finance assistant Bit, let's get acquainted")
    println("Enter your name")
    val userName = scanner.nextLine()
    println("Nice to meet you, $userName")

    println("How much money do you have?")
    var remainingMoney = scanner.nextDouble()

    println("How many days until payday?")
    val userPayDaySalary = scanner.nextInt()

    while (true) {
        println("What do you want to do?")
        println("1 - Get an advice.")
        println("2 - Convert currency")
        println("3 - Enter spending")
        println("4 - Show weekly spending")
        println("5 - Show the highest amount spent in a week")
        println("6 - Set aside on target.")
        println("0 - Exit")

        val command = scanner.nextInt()

        if (command == 1) {
            if (remainingMoney < 3000) {
                println("Stay at home today.")
            }else if (remainingMoney < 1000) {
                if (userPayDaySalary < 10) {
                    println("Go to KFC!!")
                }else {
                    println("Today it is better to be economical and stay at home")
                }
            }else if (remainingMoney < 30000) {
                if (userPayDaySalary < 10) {
                    println("You are good at saving, you can buy shares!")
                }else {
                    println("Go to KFC!!")
                }
            }else {
                if (userPayDaySalary < 10) {
                    println("Buy dollars and a couple of shares of large companies!")
                } else {
                    println("You are good at saving money, go to a restaurant or order sushi!")
                }
            }
        }else if (command == 2) {
            println("Your saving: $remainingMoney RUB")
            println("What currency do you want to convert to? Available currencies: 1 - USD, 2 - EUR, 3 - JPY.")

            when (scanner.nextInt()) {
                1 -> {
                    println("Your savings in dollars: ${remainingMoney / USD_RATE}")
                }
                2 -> {
                    println("Your savings in euro: ${remainingMoney / EUR_RATE}")
                }
                3 -> {
                    println("Your savings in jpy: ${remainingMoney / JPY_RATE}")
                }
                else -> {
                    println("Unknown currency")
                }
            }
        }else if (command == 3){
            println("For which day do you want to enter spending: 1-Mon, 2-Tue, 3-Wed, 4-Thurs, 5-Fri, 6-Sat, 7-Sun?")

            val day = scanner.nextInt()
            println("Enter spending amount")
            val expense = scanner.nextDouble()
            remainingMoney -= expense
            expenses[day - 1] += expense
            println("Value saved! Your balance in rubles: $remainingMoney")
        }else if (command == 4) {
            for (i in expenses.indices) {
                println("Day " + (i + 1) + ". Spent " + expenses[i] + " RUB")
            }
        }else if (command == 5) {
            var maxExpense = 0.0
            for (i in expenses.indices) {
                if (expenses[i] > maxExpense) {
                    maxExpense = expenses[i]
                }
                println("The largest amount spent this week was : $maxExpense RUB")
            }
        }else if (command == 6) {
            println("Enter the amount you want to save: ")
            val accumulations = scanner.nextInt()
            println("You can save per month:")
            val mothPay = scanner.nextInt()
            var accumulationsTotal = 0
            var month = -1
            while (accumulationsTotal <= accumulations) {
                accumulationsTotal += mothPay
                month += 1
            }
            println("If you save monthly: $mothPay RUB you will accumulate $accumulations RUB through $month month")
        }else if (command == 0) {
            println("See you")
        }else {
            println("Unknown command")
        }
    }
}


