package fr.maynadier.domain.model

import fr.maynadier.domain.TaxeCalculator
import java.math.BigDecimal

data class Bill private constructor(
    val taxedProducts: List<TaxedProduct>,
    val totalTaxes: BigDecimal,
    val billTotal: BigDecimal
) {
    fun print(): String {
        val content = StringBuilder()
        taxedProducts.forEach { product ->
            content.appendLine("1 ${product.name} : ${product.taxedPrice}")
        }
        content.appendLine("Montant des taxes : $totalTaxes")
        content.append("Total : $billTotal")
        return content.toString()
    }

    companion object {
        fun buildBill(panier: Panier, taxeCalculator: TaxeCalculator): Bill {
            var totalTaxes = BigDecimal.ZERO
            var billTotal = BigDecimal.ZERO
            val taxedProducts = mutableListOf<TaxedProduct>()
            panier.produits.forEach { product ->
                val productTaxe = taxeCalculator.getTaxeAmount(product)
                totalTaxes = totalTaxes.plus(productTaxe)
                val taxedPrice = product.price.plus(productTaxe)
                billTotal = billTotal.plus(taxedPrice)
                taxedProducts.add(TaxedProduct(product.name, taxedPrice))
            }
            return Bill(taxedProducts, totalTaxes, billTotal)
        }
    }
}
