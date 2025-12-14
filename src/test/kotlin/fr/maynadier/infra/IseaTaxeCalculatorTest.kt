package fr.maynadier.infra

import fr.maynadier.domain.model.ImportStatus
import fr.maynadier.domain.model.Product
import fr.maynadier.domain.model.TaxedClassification
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class IseaTaxeCalculatorTest {

    val taxeCalculator = IseaTaxeCalculator(TaxeRounder())

    @Test
    fun `le calcul de la taxe pour un produit exempte retourne 0`() {
        val produit = Product("bannane", BigDecimal(5), TaxedClassification.UN_TAXED, ImportStatus.LOCAL)
        val taxeAmount = taxeCalculator.getTaxeAmount(produit)
        Assertions.assertThat(taxeAmount).isEqualTo(BigDecimal(0.00).setScale(2))
    }

    @Test
    fun `le calcul de la taxe pour un produit taxé_coutant_10 retourne 1`() {
        val produit = Product("jouet", BigDecimal(10), TaxedClassification.TAXED, ImportStatus.LOCAL)
        val taxeAmount = taxeCalculator.getTaxeAmount(produit)
        Assertions.assertThat(taxeAmount).isEqualTo(BigDecimal(1.00).setScale(2))
    }

    @Test
    fun `le calcul de la taxe pour un produit exempte coutant 10 et importé retourne 0,5`() {
        val produit = Product("banane", BigDecimal(10), TaxedClassification.UN_TAXED, ImportStatus.IMPORTED)
        val taxeAmount = taxeCalculator.getTaxeAmount(produit)
        Assertions.assertThat(taxeAmount).isEqualTo(BigDecimal(0.50).setScale(2))
    }

    @Test
    fun `le calcul de la taxe pour un produit taxé_coutant 10 et importé retourne 1,5`() {
        val produit = Product("jouet", BigDecimal(10), TaxedClassification.TAXED, ImportStatus.IMPORTED)
        val taxeAmount = taxeCalculator.getTaxeAmount(produit)
        Assertions.assertThat(taxeAmount).isEqualTo(BigDecimal(1.50).setScale(2))
    }
}