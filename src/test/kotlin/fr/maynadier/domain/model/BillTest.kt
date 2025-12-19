package fr.maynadier.domain.model

import fr.maynadier.domain.TaxeCalculator
import fr.maynadier.domain.model.ImportStatus.LOCAL
import fr.maynadier.domain.model.TaxedClassification.UN_TAXED
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever
import java.math.BigDecimal

class BillTest {

    private val taxeCalculator: TaxeCalculator = mock()
    var panier = Panier(emptyList())

    @Test
    fun `pour un produit sans taxe le montant total est le prix du produit et les taxe sont à 0`() {
        panier = panier.ajouteProduit(Product("Banane", BigDecimal(10.00), UN_TAXED, LOCAL))
        whenever(taxeCalculator.getTaxeAmount(any())) doReturn BigDecimal.ZERO.setScale(2)
        val bill = Bill.buildBill(panier, taxeCalculator).print()
        assertThat(bill).contains("Total : 10.00")
        assertThat(bill).contains("Montant des taxes : 0.00")
    }

    @Test
    fun `pour un produit avec taxe le montant total est le prix du produit + taxe et les taxes sont indiquées`() {
        panier = panier.ajouteProduit(Product("Jouet", BigDecimal(10.00), UN_TAXED, LOCAL))
        whenever(taxeCalculator.getTaxeAmount(any())) doReturn BigDecimal(8.00).setScale(2)
        val bill = Bill.buildBill(panier, taxeCalculator).print()
        assertThat(bill).contains("Total : 18.00")
        assertThat(bill).contains("Montant des taxes : 8.00")
    }

}