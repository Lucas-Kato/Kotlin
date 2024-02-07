package br.com.alura.alugames.modelo

import br.com.alura.alugames.utilitario.formatoComDuasCasasDecimais
import java.math.BigDecimal
import java.math.RoundingMode

class PlanoAvulso(
    tipo: String,
    id: Int = 0): Plano(tipo, id) {

    override fun obterValor(aluguel: Aluguel): Double {
        var valorOriginal = super.obterValor(aluguel)
        if (aluguel.gamer.media > 8) {
            valorOriginal -= valorOriginal * 0.1
        }
        return valorOriginal.formatoComDuasCasasDecimais()
    }
}
