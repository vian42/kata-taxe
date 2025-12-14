package fr.maynadier.infra

import fr.maynadier.domain.BillPrinter
import fr.maynadier.domain.TaxeCalculator

class IseaBillPrinter(override val taxeCalculator: TaxeCalculator) : BillPrinter
