package fr.maynadier.steps

import fr.maynadier.domain.model.Bill
import fr.maynadier.domain.model.ImportStatus.IMPORTED
import fr.maynadier.domain.model.ImportStatus.LOCAL
import fr.maynadier.domain.model.Panier
import fr.maynadier.domain.model.Product
import fr.maynadier.domain.model.TaxedClassification.TAXED
import fr.maynadier.domain.model.TaxedClassification.UN_TAXED
import fr.maynadier.infra.IseaTaxeCalculator
import fr.maynadier.infra.TaxeRounder
import fr.maynadier.steps.tools.SharedContext
import io.cucumber.datatable.DataTable
import io.cucumber.java.fr.Alors
import io.cucumber.java.fr.Et
import io.cucumber.java.fr.Etantdonné
import io.cucumber.java.fr.Quand
import org.assertj.core.api.Assertions.assertThat
import java.math.BigDecimal

class FactureSteps(private val context: SharedContext) {

    var panier = Panier(emptyList())
    val rounder = TaxeRounder()
    val taxeCalculator = IseaTaxeCalculator(rounder)

    @Etantdonné("une commande avec les produits suivant:")
    fun uneCommandeAvecLesProduitsSuivant(dataTable: DataTable) {
        val rows: List<Map<String, String>> = dataTable.asMaps(String::class.java, String::class.java)
        for (row in rows) {
            val produit = Product(
                row["nom"]!!, row["prix"]!!.toBigDecimal(),
                if (row["taxe"]!! == "taxe") TAXED else UN_TAXED,
                if (row["origine"]!! == "local") LOCAL else IMPORTED
            )

            panier = panier.ajouteProduit(produit)
        }
    }

    @Quand("la facture est émise")
    fun laFactureEstEmise() {
        val bill = Bill.buildBill(panier, taxeCalculator)
        context.printedBill = bill.print()
    }

    @Alors("les produits sont listés avec le prix taxé:")
    fun lesProduitsSontListesAvecLePrixTaxe(dataTable: DataTable) {
        val rows: List<Map<String, String>> = dataTable.asMaps(String::class.java, String::class.java)
        for (row in rows) {
            assertThat(context.printedBill).contains(row["nom"]!!)
            assertThat(context.printedBill).contains(row["prix"]!!)
        }
    }

    @Et("au bas de la facture figurent le montant total \\(TTC) {montant}")
    fun auBasDeLaFactureFigurentLeMontantTotalTTC(montant: BigDecimal) {
        assertThat(context.printedBill).contains("Total : $montant")
    }

    @Et("figure le montant total des taxes {montant}")
    fun figureLeMontantTotalDesTaxes(montant: BigDecimal) {
        assertThat(context.printedBill).contains("Montant des taxes : $montant")
    }
}