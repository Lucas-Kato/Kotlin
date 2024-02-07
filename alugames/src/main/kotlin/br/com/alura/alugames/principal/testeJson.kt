package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamer = consumo.buscaGamers()
    val listaJogo = consumo.buscaJogosJson()
    val gamerCaroline = listaGamer.get(3)
    val jogoResidentVillage = listaJogo.get(10)
    val jogoSpider = listaJogo.get(13)
    val jogoDandara = listaJogo.get(5)
    val jogoAssassins = listaJogo.get(4)
    val jogoCyber = listaJogo.get(6)
    val jogoGod = listaJogo.get(7)
    val jogoSkyrim = listaJogo.get(18)

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
//    gamerCamila.plano = PlanoAssinatura("PRATA", "9.90", 3, 0.15)

    gamerCamila.alugaJogo(jogoTheLastOfUs, periodoTheLastOfUs)
    gamerCamila.alugaJogo(jogoSpiderMan, periodoSpiderMan)
    gamerCamila.alugaJogo(jogoResidentVillage, periodoResidentVillage)
    gamerCamila.alugaJogo(jogoResidentVillage, periodoResidentVillage)
    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
    println(gamerCamila)

    gamerCamila.alugaJogo(jogoResidentVillage, periodoResidentVillage)
    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)

    gamerCaroline.recomendarJogo(jogoResidentVillage, 8)
    gamerCaroline.recomendarJogo(jogoTheLastOfUs, 9)

    println("Recomendações da Camila")
    println(gamerCamila.jogosRecomendados)
    println("Recomendações da Caroline")
    println(gamerCaroline.jogosRecomendados)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)
    println(serializacao)

    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)

}
