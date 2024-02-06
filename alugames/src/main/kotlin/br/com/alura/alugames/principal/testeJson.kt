package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.servicos.ConsumoApi
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamer = consumo.buscaGamers()
    val listaJogo = consumo.buscaJogosJson()
    val gamerCaroline = listaGamer.get(3)
    val jogoResidentVillage = listaJogo.get(10)

    val jogoSpiderMan = listaJogo.get(13)
    val jogoTheLastOfUs = listaJogo.get(2)

//    println(listaGamer)
//    println(listaJogo)
//    println(gamerCaroline)
//    println(jogoResidentVillage)

    val periodoResidentVillage = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodoSpiderMan = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodoTheLastOfUs = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodoSpiderMan1 = Periodo(LocalDate.of(2023,8,2), LocalDate.of(2023,8,15))

    gamerCaroline.alugaJogo(jogoResidentVillage, periodoResidentVillage)
    gamerCaroline.alugaJogo(jogoSpiderMan, periodoSpiderMan)
    gamerCaroline.alugaJogo(jogoTheLastOfUs, periodoTheLastOfUs)
//    println(gamerCaroline.jogosAlugados)
    gamerCaroline.alugaJogo(jogoSpiderMan, periodoSpiderMan1)

//    println(gamerCaroline.jogosDoMes(7))

    val gamerCamila = listaGamer.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3)

    gamerCamila.alugaJogo(jogoTheLastOfUs, periodoTheLastOfUs)
    gamerCamila.alugaJogo(jogoSpiderMan, periodoSpiderMan)
    gamerCamila.alugaJogo(jogoResidentVillage, periodoResidentVillage)
    gamerCamila.alugaJogo(jogoResidentVillage, periodoResidentVillage)
    println(gamerCamila.jogosAlugados)
}
