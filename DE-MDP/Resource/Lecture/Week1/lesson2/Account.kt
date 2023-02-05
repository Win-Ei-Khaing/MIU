package com.example.kotlinfundamendals

// Demonstrate how to customize getters and setters
class Account  (val accountNumber: Int, var accountBalance: Double) { // Primary Constructor
        val fees: Double = 25.00
        var balanceLessFees: Double
        get() {
            return accountBalance - fees
        }
        set(value) {
            accountBalance = value + accountBalance - fees
        }
    fun displayBalance() {
        println("Number $accountNumber")
        println("Current balance is $accountBalance")
    }

}