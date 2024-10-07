data class Hospede(val nome: String, val idade: Int)

fun cadastrarHospedes(nomeDoHotel: String, nomeUsuario: String) {
    print("Qual o valor  padrão da diária? ")
    val diaria = readLine()?.toDoubleOrNull() ?: 0.0

    var totalHospedes = 0
    var totalGratuidades = 0
    var totalMeias = 0
    var valorTotal = 0.0

    while (true) {
        print("Nome do hóspede (ou 'PARE' para finalizar): ")
        val nome = readLine()!!
        if (nome.equals("PARE", ignoreCase = true)) break

        print("Idade do hóspede: ")
        val idade = readLine()?.toIntOrNull() ?: 0

        val hospede = Hospede(nome, idade)
        totalHospedes++

        when {
            idade < 6 -> {
                println("$nome cadastrado(a) com sucesso. $nome possui gratuidade")
                totalGratuidades++
            }
            idade >= 60 -> {
                println("$nome cadastrado(a) com sucesso. $nome paga meia")
                totalMeias++
                valorTotal += diaria / 2
            }
            else -> {
                println("$nome cadastrado(a) com sucesso.")
                valorTotal += diaria
            }
        }
    }

    println("$nomeUsuario, o valor total das hospedagens é: R$ $valorTotal; $totalGratuidades gratuidade(s); $totalMeias meia(s)")
}