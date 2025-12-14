package fr.maynadier

import java.math.BigDecimal

data class Product(val string: String, val montant: BigDecimal) {


        fun getTaxeAmount(): BigDecimal {
            // exemple : taxe de 20 %
            return BigDecimal(0.00).setScale(2)
        }
}
