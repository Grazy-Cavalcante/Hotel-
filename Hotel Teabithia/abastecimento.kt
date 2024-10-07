fun abastecimento(nomeDoHotel: String, nomeUsuario: String) {
    val capacidadeTanque = 42.0

    print("Qual o valor do álcool no posto Wayne Oil? ")
    val alcoolWayne = readLine()?.toDoubleOrNull() ?: 0.0
    print("Qual o valor da gasolina no posto Wayne Oil? ")
    val gasolinaWayne = readLine()?.toDoubleOrNull() ?: 0.0

    print("Qual o valor do álcool no posto Stark Petrol? ")
    val alcoolStark = readLine()?.toDoubleOrNull() ?: 0.0
    print("Qual o valor da gasolina no posto Stark Petrol? ")
    val gasolinaStark = readLine()?.toDoubleOrNull() ?: 0.0

    // Cálculo do custo total para cada opção
    val custoAlcoolWayne = alcoolWayne * capacidadeTanque
    val custoGasolinaWayne = gasolinaWayne * capacidadeTanque
    val custoAlcoolStark = alcoolStark * capacidadeTanque
    val custoGasolinaStark = gasolinaStark * capacidadeTanque

    // Verificando a regra do álcool
    val diferencaAlcoolGasolinaWayne = (gasolinaWayne - alcoolWayne) / gasolinaWayne
    val diferencaAlcoolGasolinaStark = (gasolinaStark - alcoolStark) / gasolinaStark

    // Encontrando a opção mais barata
    var postoMaisBarato = ""
    var combustivelMaisBarato = ""
    var menorCusto = Double.MAX_VALUE

    if (custoAlcoolWayne < custoGasolinaWayne && diferencaAlcoolGasolinaWayne >= 0.3) {
        postoMaisBarato = "Wayne Oil"
        combustivelMaisBarato = "álcool"
        menorCusto = custoAlcoolWayne
    } else if (custoGasolinaWayne < custoAlcoolWayne) {
        postoMaisBarato = "Wayne Oil"
        combustivelMaisBarato = "gasolina"
        menorCusto = custoGasolinaWayne
    }

    if (custoAlcoolStark < custoGasolinaStark && diferencaAlcoolGasolinaStark >= 0.3) {
        if (custoAlcoolStark < menorCusto) {
            postoMaisBarato = "Stark Petrol"
            combustivelMaisBarato = "álcool"
            menorCusto = custoAlcoolStark
        }
    } else if (custoGasolinaStark < menorCusto) {
        postoMaisBarato = "Stark Petrol"
        combustivelMaisBarato = "gasolina"
        menorCusto = custoGasolinaStark
    }

    println("$nomeUsuario, é mais barato abastecer com $combustivelMaisBarato no posto $postoMaisBarato.")
}