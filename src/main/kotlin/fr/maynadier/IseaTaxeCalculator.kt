package fr.maynadier

import java.math.BigDecimal

class IseaTaxeCalculator(val rounder: Rounder) : TaxeCalculator {


    override fun getTaxeAmount(product: Product): BigDecimal {
        val importedTaxe = if (product.imported) {
            product.price
                .multiply(BigDecimal(5))
                .divide(BigDecimal(100))
        } else {
            BigDecimal(0.00).setScale(2)

        }
        val taxe = if (product.taxed) {
            product.price
                .multiply(BigDecimal(10))
                .divide(BigDecimal(100))
        } else {
            BigDecimal(0.00).setScale(2)
        }
        return rounder.round(importedTaxe.add(taxe))
    }
}
