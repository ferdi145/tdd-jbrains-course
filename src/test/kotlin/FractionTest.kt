import kotlin.test.Test
import kotlin.test.assertEquals

class FractionTest {
    @Test
    fun `should add two fractions with same denominator`() {
        val result = Fraction(1,2).add(Fraction(1,2))

        assertEquals(Fraction(1,1), result)
    }

    @Test
    fun `should add two fractions with different denominator`() {
        val result = Fraction(1,2).add(Fraction(2,4))

        assertEquals(Fraction(1,1), result)
    }

    @Test
    fun `should calculate common denominator`() {
        val result = Fraction(1,2).add(Fraction(1,4))

        assertEquals(2, result.denominator)
    }

    @Test
    fun `should calculate whole numbers`() {
        val result = Fraction(1).add(Fraction(1))

        assertEquals(2, result.number)
    }
}