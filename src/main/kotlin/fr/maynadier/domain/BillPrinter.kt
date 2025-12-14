package fr.maynadier.domain

import fr.maynadier.domain.model.Panier

interface BillPrinter {
    val taxeCalculator: TaxeCalculator
    fun print(panier: Panier): String

}
