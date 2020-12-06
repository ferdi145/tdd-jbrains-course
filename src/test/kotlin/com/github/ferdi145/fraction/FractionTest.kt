package com.github.ferdi145.fraction

import kotlin.test.Test
import kotlin.test.assertEquals

class FractionTest {
    @Test
    fun `should add two fractions with same denominator`() {
        val result = Fraction(1,2).add(Fraction(1,2))

        assertEquals(Fraction(1,1), result)
    }

    @Test
    fun `should add two fractions with different denominator returning a whole number`() {
        val result = Fraction(1,2).add(Fraction(2,4))

        assertEquals(Fraction(1,1), result)
    }

    @Test
    fun `should add two fractions with even denominators and distinct denominators returning a fraction`() {
        val result = Fraction(1,2).add(Fraction(1,4))

        assertEquals(Fraction(1, 2), result)
    }

    @Test
    fun `should add two fractions with uneven denominators and distinct denominators returning a fraction`() {
        val result = Fraction(7,3).add(Fraction(4,5))

        assertEquals(Fraction(47, 15), result)
    }

    @Test
    fun `should add two fractions with one negative fraction`() {
        val result = Fraction(-7,3).add(Fraction(4,5))

        assertEquals(Fraction(-23, 15), result)
    }

    @Test
    fun `should add two even numbers with different denominator returning a fraction`() {
        val result = Fraction(1,2).add(Fraction(1,4))

        assertEquals(Fraction(1, 2), result)
    }

    @Test
    fun `should add whole numbers`() {
        val result = 1.toFraction().add(1.toFraction())

        assertEquals(2, result.number)
    }

    @Test
    fun `should add zeros`() {
        val result = 0.toFraction().add(0.toFraction())

        assertEquals(0, result.number)
    }
}