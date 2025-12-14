package fr.maynadier.domain

import java.math.BigDecimal

interface Rounder {

    fun round(amount : BigDecimal) : BigDecimal
}
