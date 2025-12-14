package fr.maynadier.infra

import fr.maynadier.domain.Rounder
import fr.maynadier.domain.TaxeCalculator
import fr.maynadier.domain.model.Product
import java.math.BigDecimal

class IseaTaxeCalculator(val rounder: Rounder) : TaxeCalculator {

    override fun getTaxeAmount(product: Product): BigDecimal {
        val importedTaxe = product.price
            .multiply(BigDecimal(product.imported.taxePercentage))
            .divide(BigDecimal(100))
        val taxe = product.price
            .multiply(BigDecimal(product.taxed.taxePercentage))
            .divide(BigDecimal(100))
        return rounder.round(importedTaxe.add(taxe))
    }
}
