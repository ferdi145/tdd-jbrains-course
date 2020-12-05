import kotlin.test.Test
import kotlin.test.assertEquals

class FractionTest {
    @Test
    fun `should add two fractions`() {
        val result = Fraction(1,2).add(Fraction(1,2))

        assertEquals(Fraction(2,2), result)
    }
}