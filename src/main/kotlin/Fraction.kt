import kotlin.math.max
import kotlin.math.min

data class Fraction(val number: Int, val denominator: Int) {

    fun add(otherFraction: Fraction): Fraction {
        val commonDenominator = calculateDenominator(otherFraction)
        return Fraction(this.number + otherFraction.number, commonDenominator)
    }

    private fun calculateDenominator(otherFraction: Fraction): Int {
        return if(this.denominator == otherFraction.denominator) {
            this.denominator
        } else {
            findCommonDenominator(otherFraction)
        }
    }

    private fun findCommonDenominator(otherFraction: Fraction): Int {
        return if(isEven(this.denominator) && isEven(otherFraction.denominator)) {
            min(this.denominator, otherFraction.denominator)
        } else {
            1
        }
    }

    private fun isEven(denominator1: Int) = denominator1 % 2 == 0
}
