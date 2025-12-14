package fr.maynadier

import java.math.BigDecimal

interface Rounder {

    fun round(amount : BigDecimal) : BigDecimal
}
