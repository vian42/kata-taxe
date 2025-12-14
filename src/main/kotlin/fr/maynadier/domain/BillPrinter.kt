package fr.maynadier.domain

import fr.maynadier.domain.obj.Panier
import java.math.BigDecimal

interface BillPrinter {
    val taxeCalculator: TaxeCalculator
    fun print(panier: Panier): String {
        var taxes = BigDecimal.ZERO
        var total = BigDecimal.ZERO
        val content = StringBuilder()
        panier.produits.forEach { product ->
            val productTaxe = taxeCalculator.getTaxeAmount(product)
            taxes = taxes.plus(productTaxe)
            val taxedPrice = product.price.plus(productTaxe)
            total = total.plus(taxedPrice)
            content.appendLine("1 ${product.name} : $taxedPrice")
        }
        content.appendLine("Montant des taxes : $taxes")
        content.append("Total : $total")
        return content.toString()
    }

}
