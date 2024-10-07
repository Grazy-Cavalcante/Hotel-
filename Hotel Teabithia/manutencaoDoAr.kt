fun manutencaoDoAr(nomeDoHotel: String, nomeUsuario: String) {
    fun main() {
        var menorValor = Double.MAX_VALUE
        var empresaComMenorValor = ""

        do {
            print("Qual o nome da empresa? ")
            val nomeEmpresa = readLine()!!
            print("Qual o valor por aparelho? ")
            val valorPorAparelho = readLine()!!.toDouble()
            print("Qual a quantidade de aparelhos? ")
            val quantidadeAparelhos = readLine()!!.toInt()
            print("Qual a porcentagem de desconto? ")
            val desconto = readLine()!!.toDouble()
            print("Qual o número mínimo de aparelhos para conseguir o desconto? ")
            val quantidadeMinima = readLine()!!.toInt()

            val valorTotal = valorPorAparelho * quantidadeAparelhos
            val valorDesconto = if (quantidadeAparelhos >= quantidadeMinima) valorTotal * (desconto / 100) else 0.0
            val valorFinal = valorTotal - valorDesconto

            println("O serviço de $nomeEmpresa custará R$ ${"%.2f".format(valorFinal)}")

            if (valorFinal < menorValor) {
                menorValor = valorFinal
                empresaComMenorValor = nomeEmpresa
            }

            print("Deseja informar novos dados, ${nomeEmpresa}? (S/N) ")
        } while (readLine()?.lowercase() == "s")

        println("O orçamento de menor valor é o de $empresaComMenorValor por R$ ${"%.2f".format(menorValor)}")
    }
}