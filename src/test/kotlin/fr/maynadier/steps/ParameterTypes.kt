package fr.maynadier.steps

import io.cucumber.java.ParameterType
import java.math.BigDecimal

class ParameterTypes {
    @ParameterType("\\d+\\.\\d+")
    fun montant(value: String): BigDecimal {
        return BigDecimal(value)
    }
    @ParameterType("true|false")
    fun boolean(value: String): Boolean {
        return value == "true"
    }
}