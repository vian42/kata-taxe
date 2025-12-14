package fr.maynadier

import java.math.BigDecimal

data class Product(val name: String, val price: BigDecimal, val taxed: Boolean, val imported: Boolean) {

    private val rounder = TaxRounder()

    fun getTaxeAmount(): BigDecimal {
        // exemple : taxe de 20 %
        val importedTaxe = if (imported) {
             price
                .multiply(BigDecimal(5))
                .divide(BigDecimal(100))
        } else {
            BigDecimal(0.00).setScale(2)

        }
        val taxe = if (taxed) {
             price
                .multiply(BigDecimal(10))
                .divide(BigDecimal(100))
        } else {
            BigDecimal(0.00).setScale(2)
        }
        return rounder.round(importedTaxe.add(taxe))
    }
}
