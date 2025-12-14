package fr.maynadier.infra

import fr.maynadier.domain.BillPrinter
import fr.maynadier.domain.TaxeCalculator
import fr.maynadier.domain.model.Panier
import java.math.BigDecimal

class IseaBillPrinter(override val taxeCalculator: TaxeCalculator) : BillPrinter {
    override fun print(panier: Panier): String {
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
