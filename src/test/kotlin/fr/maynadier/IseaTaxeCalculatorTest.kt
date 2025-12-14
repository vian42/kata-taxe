package fr.maynadier

import fr.maynadier.ImportStatus.IMPORTED
import fr.maynadier.ImportStatus.LOCAL
import fr.maynadier.TaxedClassification.TAXED
import fr.maynadier.TaxedClassification.UN_TAXED
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class IseaTaxeCalculatorTest {

    val taxeCalculator = IseaTaxeCalculator(TaxeRounder())

    @Test
    fun `le calcul de la taxe pour un produit exempte retourne 0`() {
        val produit = Product("bannane", BigDecimal(5), UN_TAXED, LOCAL)
        val taxeAmount = taxeCalculator.getTaxeAmount(produit)
        assertThat(taxeAmount).isEqualTo(BigDecimal(0.00).setScale(2))
    }
    @Test
    fun `le calcul de la taxe pour un produit taxé_coutant_10 retourne 1`() {
        val produit = Product("jouet", BigDecimal(10), TAXED, LOCAL)
        val taxeAmount = taxeCalculator.getTaxeAmount(produit)
        assertThat(taxeAmount).isEqualTo(BigDecimal(1.00).setScale(2))
    }
    @Test
    fun `le calcul de la taxe pour un produit exempte coutant 10 et importé retourne 0,5`() {
        val produit = Product("banane", BigDecimal(10), UN_TAXED, IMPORTED)
        val taxeAmount = taxeCalculator.getTaxeAmount(produit)
        assertThat(taxeAmount).isEqualTo(BigDecimal(0.50).setScale(2))
    }
    @Test
    fun `le calcul de la taxe pour un produit taxé_coutant 10 et importé retourne 1,5`() {
        val produit = Product("jouet", BigDecimal(10), TAXED, IMPORTED)
        val taxeAmount = taxeCalculator.getTaxeAmount(produit)
        assertThat(taxeAmount).isEqualTo(BigDecimal(1.50).setScale(2))
    }
}