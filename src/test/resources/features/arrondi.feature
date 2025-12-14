# language: fr
Fonctionnalité: Arrondi

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