package fr.maynadier.steps

import io.cucumber.java.ParameterType
import java.math.BigDecimal

class ParameterTypes {
    @ParameterType("\\d+\\.\\d+")
    fun montant(value: String): BigDecimal {
        return BigDecimal(value)
    }
}