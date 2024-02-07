package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.GamerDAO
import br.com.alura.alugames.dados.PlanosDAO
import br.com.alura.alugames.modelo.Gamer

fun main() {
    val gamer = Gamer("Monica", "monica@email.com", "15/03/1995", "moni")

    val manager = Banco.getEntityManager()
    val gamerDAO = GamerDAO(manager)
    val planoDAO = PlanosDAO(manager)

    gamer.plano = planoDAO.recuperarPeloId(3)


    gamerDAO.adicionar(gamer)


    val listaGamersBanco = gamerDAO.getLista()
    println(listaGamersBanco)

    manager.close()
}