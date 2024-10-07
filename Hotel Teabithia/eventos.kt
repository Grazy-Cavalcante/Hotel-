fun eventos(nomeDoHotel: String, nomeUsuario: String) {

    val capacidadeLaranja = 150
    val capacidadeAdicionalLaranja = 70
    val capacidadeColorado = 350

    // Solicita o número de convidados
    print("Qual o número de convidados para o seu evento? ")
    val numConvidados = readLine()?.toIntOrNull() ?: 0

    // Verifica se o número de convidados é válido
    if (numConvidados < 0 || numConvidados > capacidadeColorado) {
        println("Número de convidados inválido.")
    } else {
        // Seleciona o auditório
        val auditorio = if (numConvidados <= capacidadeLaranja + capacidadeAdicionalLaranja) {
            "Laranja"
        } else {
            "Colorado"
        }

        // Verifica se o auditório Laranja precisa de cadeiras adicionais
        if (auditorio == "Laranja") {
            val cadeirasAdicionais = maxOf(0, numConvidados - capacidadeLaranja)
            println("Use o auditório $auditorio (inclua mais $cadeirasAdicionais cadeiras)")
        } else {
            println("Use o auditório $auditorio")
        }

        println("Agora vamos ver a agenda do evento.")

        // Chama a função para verificar disponibilidade
        val (diaSemana, hora, nomeEmpresa) = verificarDisponibilidade()

        if (diaSemana != null && hora != null && nomeEmpresa != null) {
            // Chama a função para calcular garçons e custos
            val (numGarcons, custoTotalGarcons) = calcularGarconsECusto(numConvidados)

            // Chama a função para calcular buffet e gerar o relatório
            calcularBuffetEGerarRelatorio(
                numConvidados, auditorio, diaSemana, hora, nomeEmpresa, numGarcons, custoTotalGarcons
            )
        }
    }
}

fun verificarDisponibilidade(): Triple<String?, Int?, String?> {
    // Horários de funcionamento
    val horarioAbertura = 7
    val horarioFechamento = 23
    val horarioFechamentoFinalSemana = 15

    // Solicita os dados do evento
    print("Qual o dia do seu evento? ")
    val diaSemana = readLine()?.lowercase() ?: ""
    print("Qual a hora do seu evento? ")
    val hora = readLine()?.toIntOrNull() ?: 0

    // Verifica a disponibilidade
    val estaDisponivel = when (diaSemana) {
        "segunda", "terca", "quarta", "quinta", "sexta" -> hora in horarioAbertura..horarioFechamento
        "sabado", "domingo" -> hora in horarioAbertura..horarioFechamentoFinalSemana
        else -> false
    }

    return if (estaDisponivel) {
        print("Qual o nome da empresa? ")
        val nomeEmpresa = readLine() ?: ""
        println("Auditório reservado para $nomeEmpresa. $diaSemana às $hora hs.")
        Triple(diaSemana, hora, nomeEmpresa)
    } else {
        println("Auditório indisponível.")
        Triple(null, null, null)
    }
}

fun calcularGarconsECusto(numConvidados: Int): Pair<Int, Double> {
    val precoPorGarcomPorHora = 10.50

    print("Qual a duração do evento em horas? ")
    val duracaoEvento = readLine()?.toIntOrNull() ?: 0

    // Calcula o número de garçons baseado na duração e no número de convidados
    val numGarcons = (numConvidados.toDouble() / 12.0).toInt() + duracaoEvento / 2

    val custoTotalGarcons = numGarcons * duracaoEvento * precoPorGarcomPorHora

    println("São necessários $numGarcons garçons.")
    println("Custo: R$ ${"%.2f".format(custoTotalGarcons)}")

    return Pair(numGarcons, custoTotalGarcons)
}

fun calcularBuffetEGerarRelatorio(
    numConvidados: Int, auditorio: String, diaSemana: String, hora: Int, nomeEmpresa: String,
    numGarcons: Int, custoTotalGarcons: Double
) {

    val litrosCafe = numConvidados * 0.2
    val litrosAgua = numConvidados * 0.5
    val numSalgados = numConvidados * 7

    val custoCafe = litrosCafe * 0.8
    val custoAgua = litrosAgua * 0.4
    val custoSalgados = (numSalgados / 100) * 34
    val custoTotalBuffet = custoCafe + custoAgua + custoSalgados

    println("O evento precisará de ${"%.2f".format(litrosCafe)} litros de café, ${"%.2f".format(litrosAgua)} litros de água, $numSalgados salgados.")

    val custoTotalEvento = custoTotalGarcons + custoTotalBuffet

    println("\nEvento no Auditório $auditorio.")
    println("Nome da Empresa: $nomeEmpresa.")
    println("Data: $diaSemana, $hora hs.")
    println("Duração do evento: $numGarcons horas.")
    println("Quantidade de garçons: $numGarcons")
    println("Quantidade de Convidados: $numConvidados")

    println("\nCusto do garçons: R$ ${"%.2f".format(custoTotalGarcons)}")
    println("Custo do Buffet: R$ ${"%.2f".format(custoTotalBuffet)}")
    println("\nValor total do Evento: R$ ${"%.2f".format(custoTotalEvento)}")

    print("\nGostaria de efetuar a reserva? S/N: ")
    val resposta = readLine()?.lowercase() ?: ""
    if (resposta == "s") {
        println("Reserva efetuada com sucesso.")
    } else {
        println("Reserva não efetuada.")
    }
}


