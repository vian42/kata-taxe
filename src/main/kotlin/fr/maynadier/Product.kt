package fr.maynadier

import java.math.BigDecimal

data class Product(val name: String, val price: BigDecimal, val taxed: TaxedClassification, val imported: ImportStatus)
