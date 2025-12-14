package fr.maynadier.steps

import fr.maynadier.Rounder
import fr.maynadier.TaxeRounder
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions.assertThat
import java.math.BigDecimal


class ArrondiSteps {

    private var montantTaxe: BigDecimal = BigDecimal.ZERO
    private var montantFinal: BigDecimal = BigDecimal.ZERO

    private val rounder : Rounder = TaxeRounder()

    @Given("un montant de taxe calculée de {montant}")
    fun unMontantDeTaxeCalculéeDe(montant: BigDecimal) {
        montantTaxe = montant
    }

    @When("J'arrondi le montant")
    fun jArrondiLeMontant() {
        montantFinal =  rounder.round(montantTaxe)
    }

    @Then("le montant final est {montant}")
    fun leMontantFinalEst(resultatAttendu: BigDecimal) {
        assertThat(montantFinal).isEqualTo(resultatAttendu)
    }
}