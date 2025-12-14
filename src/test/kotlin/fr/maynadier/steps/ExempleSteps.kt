package fr.maynadier.steps

import fr.maynadier.steps.tools.SharedContext
import io.cucumber.java.fr.Et
import org.assertj.core.api.Assertions.assertThat
import java.math.BigDecimal

class ExempleSteps(private val context: SharedContext) {

    @Et("le montant des taxes est {montant}")
    fun leMontantDesTaxesEst(montant: BigDecimal) {
        assertThat(context.bill).contains(montant.toString())
    }

    @Et("le total de la facture est {montant}")
    fun leTotalDeLaFactureEst(montant: BigDecimal) {
        assertThat(context.bill).contains(montant.toString())
    }
}