# language: fr
Fonctionnalité: Calculateur de taxe

  Plan du Scénario: Arrondi de la valeur de la taxe : 5 cents supérieur
    Etant donné un montant de taxe calculée de <montant>
    Quand J'arrondi le montant
    Alors le montant final est <resultat>

    Exemples:
      | montant | resultat |
      | 0.99    | 1.00     |
      | 1.00    | 1.00     |
      | 1.01    | 1.05     |
      | 1.02    | 1.05     |

  Scénario: pour les produit exempté, la taxe est de 0%
    #ivres, de la nourriture et des médicaments
    Etant donné l'achat d'un produit de type "livre" de cout 10 €
    Quand Je calcule le montant de sa taxe
    Alors elle de valeur 0 €

  Scénario: pour les produit classique  10%
    Etant donné l'achat d'un produit de type "parfum" de cout 10 €
    Quand Je calcule le montant de sa taxe
    Alors elle de valeur 1 €

  Plan du Scénario: pour les produits importés, taxe additionnel de 5%
    Etant donné l'achat d'un produit de type <type> de cout <cout> € et importé
    Quand Je calcule le montant de sa taxe
    Alors elle de valeur <valeur> €
    Exemples:
      | type   | cout | valeur |
      | pommes | 10   | 10.5   |
      | jouet  | 10   | 11.5   |

  Scénario: Informations présentes sur la facture
    Etant donné une commande avec les produits suivant:
      | 1 | livre | 12.49 |
      | 1 | cd    | 14.99 |
    Quand la facture est émise
    Alors les produits sont listés avec le prix taxé:
      | 1 | livre | 12.49 |
      | 1 | cd    | 16.49 |
    Et au bas de la facture figurent le montant total (TTC)
    Et figure le montant total des taxes


    # exemple de l'énoncé

  Scénario: scénario 1
    Etant donné une commande avec les produits suivant:
      | 1 | livre             | 12.49 |
      | 1 | cd                | 14.99 |
      | 1 | barre de chocolat | 0.85  |
    Quand la facture est émise
    Alors les produits sont listés avec le prix taxé:
      | 1 | livre             | 12.49 |
      | 1 | cd                | 16.49 |
      | 1 | barre de chocolat | 0.85  |
    Et le montant des taxes est 1.50
    Et le total de la facture est 29.83

  Scénario:  scénario 2
    Etant donné une commande avec les produits suivant:
      | 1 | boite de chocolats importée | 10.00 |
      | 1 | flacon de parfum importé    | 47.50 |
    Quand la facture est émise
    Alors les produits sont listés avec le prix taxé:
      | 1 | boite de chocolats importée | 10.50 |
      | 1 | flacon de parfum importé    | 54.65 |
    Et le montant des taxes est 7.65
    Et le total de la facture est 65.15

  Scénario:  scénario 3
    Etant donné une commande avec les produits suivant:
      | 1 | flacon de parfum importé            | 27.99 |
      | 1 | flacon de parfum                    | 18.99 |
      | 1 | boîte de pilules contre la migraine | 9.75  |
      | 1 | boite de chocolats importée         | 11.25 |
    Quand la facture est émise
    Alors les produits sont listés avec le prix taxé:
      | 1 | flacon de parfum importé            | 32.19 |
      | 1 | flacon de parfum                    | 20.89 |
      | 1 | boîte de pilules contre la migraine | 9.75  |
      | 1 | boite de chocolats importée         | 11.85 |
    Et le montant des taxes est 6.70
    Et le total de la facture est 74.68