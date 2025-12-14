package fr.maynadier

import java.math.BigDecimal

interface TaxeCalculator {
    fun getTaxeAmount(product: Product): BigDecimal
}
