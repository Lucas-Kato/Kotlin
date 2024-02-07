package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.AluguelDAO
import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.GamerDAO
import br.com.alura.alugames.dados.JogosDAO
import br.com.alura.alugames.modelo.Periodo

fun main() {
    val manager = Banco.getEntityManager()
    val jogosDAO = JogosDAO(manager)
    val gamerDAO = GamerDAO(manager)
    val aluguelDAO = AluguelDAO(manager)

    val gamer = gamerDAO.recuperarPeloId(1)
    val jogo = jogosDAO.recuperarPeloId(3)
    val aluguel = gamer.alugaJogo(jogo, Periodo())

    aluguelDAO.adicionar(aluguel)

    val listaAluguel = aluguelDAO.getLista()
    println(listaAluguel)

    manager.close()
}