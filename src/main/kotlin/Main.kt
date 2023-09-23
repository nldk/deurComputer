import kotlin.random.Random

fun main() {
    print("Veranderen van keuze (ja/nee)? ")
    val jaNee = readln()
    print("Hoeveel keer? ")
    val hoeveelKeer = readln().toInt()
    var aantalKeerVerloren = 0
    var aantalKeerGewonnen = 0

    repeat(hoeveelKeer) {
        val deurMetPrijs = Random.nextInt(1, 4)
        var deurGekozen = 0
        val deurKiezen = Random.nextInt(1, 4)
        while (deurGekozen !in 1..3) {
            print("Welke deur kies je (1,2 of 3)? ")
            println("$deurKiezen")
            deurGekozen = deurKiezen
        }
        val deurOmTeTonenSet = mutableSetOf(1, 2, 3)
        deurOmTeTonenSet.remove(deurGekozen)
        deurOmTeTonenSet.remove(deurMetPrijs)
        val deurKiezenOmTeTonen = deurOmTeTonenSet.random()

        val deurenSet = mutableSetOf(1, 2, 3)
        deurenSet.remove(deurGekozen)
        deurenSet.remove(deurKiezenOmTeTonen)
        val deurOmNaarTeVeranderen = deurenSet.first()

        println("Je koos deur $deurGekozen.")
        println("Ik open deur $deurKiezenOmTeTonen, waar geen prijs achter zit.")
        print("Wil je veranderen naar deur $deurOmNaarTeVeranderen? (J/N) ")

        if (jaNee == "ja") {
            println("J")
            deurGekozen = deurOmNaarTeVeranderen
        } else {
            println("N")
        }

        println("Je koos uiteindelijk voor deur $deurGekozen")
        println("De prijs zit achter deur $deurMetPrijs.")

        val isGewonnen = (deurGekozen == deurMetPrijs)

        if (isGewonnen) {
            aantalKeerGewonnen += 1
        }
        else {
            aantalKeerVerloren += 1
        }

    }
    println("Hoeveel keer gewonnen $aantalKeerGewonnen")
    println("Hoeveel keer verloren $aantalKeerVerloren")
}