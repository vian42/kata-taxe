package fr.maynadier

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class IseaTaxeCalculatorTest {

    val taxeCalculator = IseaTaxeCalculator(TaxeRounder())

    @Test
    fun `le calcul de la taxe pour un produit exempte retourne 0`() {
        val produit = Product("bannane", BigDecimal(5), false, false)
        val taxeAmount = taxeCalculator.getTaxeAmount(produit)
        assertThat(taxeAmount).isEqualTo(BigDecimal(0.00).setScale(2))
    }
    @Test
    fun `le calcul de la taxe pour un produit taxé_coutant_10 retourne 1`() {
        val produit = Product("jouet", BigDecimal(10), true, false)
        val taxeAmount = taxeCalculator.getTaxeAmount(produit)
        assertThat(taxeAmount).isEqualTo(BigDecimal(1.00).setScale(2))
    }
    @Test
    fun `le calcul de la taxe pour un produit exempte coutant 10 et importé retourne 0,5`() {
        val produit = Product("bannane", BigDecimal(10), false, true)
        val taxeAmount = taxeCalculator.getTaxeAmount(produit)
        assertThat(taxeAmount).isEqualTo(BigDecimal(0.50).setScale(2))
    }
    @Test
    fun `le calcul de la taxe pour un produit taxé_coutant 10 et importé retourne 1,5`() {
        val produit = Product("jouet", BigDecimal(10), true, true)
        val taxeAmount = taxeCalculator.getTaxeAmount(produit)
        assertThat(taxeAmount).isEqualTo(BigDecimal(1.50).setScale(2))
    }
}