# language: fr
Fonctionnalité: Calculateur de taxe

  Scénario: pour les produit exempté, la taxe est de 0%
    #ivres, de la nourriture et des médicaments
    Etant donné l'achat d'un produit de type "livre" de cout 10.00 € et exempté de taxe
    Quand Je calcule le montant de sa taxe
    Alors elle de valeur 0.00 €

  Scénario: pour les produit classique  10%
    Etant donné l'achat d'un produit de type "parfum" de cout 10.00 € et taxé
    Quand Je calcule le montant de sa taxe
    Alors elle de valeur 1.00 €

  Plan du Scénario: pour les produits importés, taxe additionnel de 5%
    Etant donné l'achat d'un produit de type <type> de cout <cout> € et importé
    Quand Je calcule le montant de sa taxe
    Alors elle de valeur <valeur> €
    Exemples:
      | type   | cout | valeur |
      | pommes | 10   | 10.5   |
      | jouet  | 10   | 11.5   |