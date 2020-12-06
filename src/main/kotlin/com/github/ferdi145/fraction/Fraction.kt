package com.github.ferdi145.fraction

import kotlin.math.min

data class Fraction(val number: Int, val denominator: Int = 1) {

    fun add(otherFraction: Fraction): Fraction {
        val commonDenominator = calculateDenominator(otherFraction)
        val (number1) = this.withDenominator(commonDenominator)
        val (number2) = otherFraction.withDenominator(commonDenominator)

        return Fraction(number1 + number2, commonDenominator).lowestDenominator()
    }

    private fun lowestDenominator(): Fraction {
        if (this.number == this.denominator) return Fraction(1, 1)

        if (isEven(this.number) && isEven(this.denominator)) {
            var tempNumber = this.number;
            var tempDenominator = this.denominator;
            while(tempNumber != 2 && tempDenominator != 2) {
                tempNumber = tempNumber / 2
                tempDenominator = tempDenominator / 2
            }

            return Fraction(tempNumber, tempDenominator)
        }

        return this
    }

    private fun withDenominator(targetDenominator: Int): Fraction {
        if (this.denominator == targetDenominator) return this

        val number = calculateNumber(targetDenominator)
        return Fraction(number, targetDenominator)
    }

    private fun calculateNumber(targetDenominator: Int): Int {
        var result = 0
        var commonDenominator = 1
        if (denominator < targetDenominator) {
            while ((denominator * commonDenominator) != targetDenominator) {
                commonDenominator++
            }
            result = this.number * commonDenominator
        } else {
            while ((denominator / commonDenominator) != targetDenominator) {
                commonDenominator++
            }
            result = this.number / commonDenominator
        }

        return result
    }

    private fun calculateDenominator(otherFraction: Fraction): Int {
        return if (this.denominator == otherFraction.denominator) {
            this.denominator
        } else {
            findCommonDenominator(otherFraction)
        }
    }

    private fun findCommonDenominator(otherFraction: Fraction): Int {
        return this.denominator * otherFraction.denominator
    }

    private fun isEven(number: Int) = number % 2 == 0
}

fun Int.toFraction(): Fraction {
    return Fraction(this)
}
