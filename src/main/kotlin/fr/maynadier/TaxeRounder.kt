package fr.maynadier

import java.math.BigDecimal
import java.math.RoundingMode

class TaxeRounder : Rounder {
    override fun round(amount: BigDecimal): BigDecimal {
        val factor = BigDecimal("0.05")
        return amount
            .divide(factor, 0, RoundingMode.CEILING)
            .multiply(factor)
            .setScale(2)
    }

}