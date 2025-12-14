package fr.maynadier.domain.model

class Panier(val produits: List<Product>) {
    fun ajouteProduit(produit: Product): Panier {
        return Panier(produits.plus(produit))
    }
}
