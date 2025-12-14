package fr.maynadier.domain.obj

enum class TaxedClassification(val taxePercentage: Int) {
    TAXED(10), UN_TAXED(0)
}