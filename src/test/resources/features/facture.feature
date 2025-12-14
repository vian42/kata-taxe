# language: fr
Fonctionnalité: Edition de la facture

  Scénario: Informations présentes sur la facture
    Etant donné une commande avec les produits suivant:
      | quantite | nom   | prix  | taxe     | origine |
      | 1        | livre | 12.49 | non taxé | local   |
      | 1        | cd    | 14.99 | taxe     | local   |
    Quand la facture est émise
    Alors les produits sont listés avec le prix taxé:
      | quantite | nom   | prix  |
      | 1        | livre | 12.49 |
      | 1        | cd    | 16.49 |
    Et au bas de la facture figurent le montant total (TTC) 28.98
    Et figure le montant total des taxes 1.50