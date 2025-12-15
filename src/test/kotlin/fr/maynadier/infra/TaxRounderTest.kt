package fr.maynadier.infra

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class TaxRounderTest {

    val rounder = TaxeRounder()

    @Test
    fun `l'arrondi d'un montant sans décimale est lui même`() {
        val montant : BigDecimal = BigDecimal.valueOf(1.00)
        val result = rounder.round(montant)
        Assertions.assertThat(result).isEqualTo(BigDecimal.valueOf(1.00).setScale(2))
    }
    @Test
    fun `l'arrondi d'un montant est arrondi au 5 centieme supérieur`() {
        val montant : BigDecimal = BigDecimal.valueOf(1.02)
        val result = rounder.round(montant)
        Assertions.assertThat(result).isEqualTo(BigDecimal.valueOf(1.05))
    }

}