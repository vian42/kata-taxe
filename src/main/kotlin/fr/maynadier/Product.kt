package fr.maynadier

import java.math.BigDecimal
import java.math.RoundingMode

data class Product(val name: String, val price: BigDecimal, val taxed: Boolean) {

        private val rounder = TaxRounder()

        fun getTaxeAmount(): BigDecimal {
            // exemple : taxe de 20 %
            return if (taxed){
                val amount = price
                    .multiply(BigDecimal(10))
                    .divide(BigDecimal(100))
                rounder.round(amount)
            } else {
                BigDecimal(0.00).setScale(2)
            }
        }
}
