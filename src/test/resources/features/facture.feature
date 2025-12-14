# language: fr
Fonctionnalité: Edition de la facture

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