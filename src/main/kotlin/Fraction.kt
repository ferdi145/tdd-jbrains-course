import kotlin.math.min

data class Fraction(val number: Int, val denominator: Int) {

    fun add(otherFraction: Fraction): Fraction {
        val commonDenominator = calculateDenominator(otherFraction)
        val (number1) = this.withDenominator(commonDenominator)
        val (number2) = otherFraction.withDenominator(commonDenominator)

        return Fraction(number1 + number2, commonDenominator)
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
        return if (isEven(this.denominator) && isEven(otherFraction.denominator)) {
            min(this.denominator, otherFraction.denominator)
        } else {
            1
        }
    }

    private fun isEven(number: Int) = number % 2 == 0
}
