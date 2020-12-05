data class Fraction(private val number: Int,private val denominator: Int) {

    fun add(fraction: Fraction): Fraction {
        return Fraction(this.number + fraction.number, calculateDenominator(fraction))
    }

    private fun calculateDenominator(fraction: Fraction): Int {
        return if(this.denominator == fraction.denominator) this.denominator else this.denominator
    }
}
