package fr.maynadier.domain

import fr.maynadier.domain.obj.Product
import java.math.BigDecimal

interface TaxeCalculator {
    fun getTaxeAmount(product: Product): BigDecimal
}
