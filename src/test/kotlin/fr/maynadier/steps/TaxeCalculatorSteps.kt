package fr.maynadier.steps

import fr.maynadier.Product
import io.cucumber.java.fr.Alors
import io.cucumber.java.fr.Etantdonné
import io.cucumber.java.fr.Quand
import org.assertj.core.api.Assertions.assertThat
import java.math.BigDecimal


class TaxeCalculatorSteps {

    lateinit var product: Product
    lateinit var taxeAmount: BigDecimal

    @Etantdonné("l'achat d'un produit de type {string} de cout {montant} € et exempté de taxe")
    fun l_achat_d_un_produit_de_type_de_cout(string: String, montant: BigDecimal) {
        product = Product(string, montant, false, false)
    }

    @Etantdonné("l'achat d'un produit de type {string} de cout {montant} € et taxé")
    fun l_achat_d_un_produit_de_type_de_cout_et_taxé(string: String, montant: BigDecimal) {
        product = Product(string, montant, true, false)
    }

    @Etantdonné("l'achat d'un produit de type {string}, de cout {montant} €, et {boolean} et importé")
    fun l_achat_d_un_produit_de_type_pommes_de_cout_et_importé(name:String, montant: BigDecimal, taxed: Boolean) {
        product = Product(name, montant, taxed, true)
    }

    @Quand("Je calcule le montant de sa taxe")
    fun je_calcule_le_montant_de_sa_taxe() {
        taxeAmount = product.getTaxeAmount()
    }

    @Alors("elle de valeur {montant} €")
    fun elle_de_valeur(montant: BigDecimal) {
        assertThat(taxeAmount).isEqualTo(montant)
    }
}
