# language: fr
Fonctionnalité: Calculateur de taxe - Exemple

  #exemple de l'énoncé
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