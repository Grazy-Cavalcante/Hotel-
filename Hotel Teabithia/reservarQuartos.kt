data class Quarto(val numero: Int, var ocupado: Boolean = false, var hospede: String? = null)

fun reservarQuartos(nomeDoHotel: String, nomeUsuario: String) {
    val quartos = List(20) { index -> Quarto(index + 1) }

    while (true) {
        print("Qual o valor da diária? ")
        val diaria = readLine()?.toDoubleOrNull() ?: 0.0
        if (diaria <= 30) {
            println("Valor inválido.")
            continue
        }

        print("Quantas diárias? ")
        val dias = readLine()?.toIntOrNull() ?: 0
        if (dias <= 0 || dias > 30) {
            println("Quantidade de dias inválida.")


            continue
        }
var total=diaria*dias
        println(" O valor total da hospedagem é de R$$total")

        print("Nome do hóspede: ")
        val hospede = readLine()!!

        var quartoEscolhido = 0
        do {
            print("Número do quarto (1-20): ")
            quartoEscolhido = readLine()?.toIntOrNull() ?: 0
            if (quartoEscolhido !in 1..20 || quartos[quartoEscolhido - 1].ocupado) {
                println("Quarto inválido ou já ocupado.")
            }
        } while (quartoEscolhido !in 1..20 || quartos[quartoEscolhido - 1].ocupado)

        println("Quarto livre.")

        print("$nomeUsuario, você confirma a reserva para $hospede por $dias dias para o quarto $quartoEscolhido por R$$total? S/N ")
        val confirmacao = readLine()?.toUpperCase() ?: "N"
        if (confirmacao == "S") {
            quartos[quartoEscolhido - 1].ocupado = true
            quartos[quartoEscolhido - 1].hospede = hospede
            println("Reserva efetuada para $hospede no quarto $quartoEscolhido.")
            break
        }
    }
}