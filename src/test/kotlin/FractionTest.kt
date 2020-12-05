import kotlin.test.Test
import kotlin.test.assertEquals

class FractionTest {
    @Test
    fun `should add two fractions with same denominator`() {
        val result = Fraction(1,2).add(Fraction(1,2))

        assertEquals(Fraction(2,2), result)
    }

    @Test
    fun `should calculate common denominator`() {
        val result = Fraction(1,2).add(Fraction(1,4))

        assertEquals(2, result.denominator)
    }
}