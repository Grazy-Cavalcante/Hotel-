fun main() {

    val nomeDoHotel = "Mirante"

    while (true) {
        println("\nBem-vindo ao $nomeDoHotel")
        println("Digite seu nome:")
        val nomeUsuario = readLine()!!
        println("Digite a senha:")
        val senha = readLine()!!

        if (senha == "2678") {
            println("Bem-vindo ao Hotel $nomeDoHotel, $nomeUsuario. É um imenso prazer ter você por aqui!")
            inicio(nomeDoHotel, nomeUsuario)
        } else {
            println("Senha incorreta!")
        }
    }
}

fun inicio(nomeDoHotel: String, nomeUsuario: String) {
    while (true) {
        println("\nMenu Principal:")
        println("1. Reservar quartos")
        println("2. Cadastrar hóspedes")
        println("3. Buscar hóspedes")  // Corrigido para buscarHospedes aparecer no menu
        println("4. Abastecimento")
        println("5. Eventos")
        println("6. Manutenção do ar")
        println("7. Sair")  // Agora corretamente listado como opção 7

        print("Digite a opção desejada: ")
        val opcao = readLine()?.toIntOrNull() ?: 0

        when (opcao) {
            1 -> reservarQuartos(nomeDoHotel, nomeUsuario)
            2 -> cadastrarHospedes(nomeDoHotel, nomeUsuario)
            3 -> buscarHospedes(nomeDoHotel, nomeUsuario)  // Agora essa opção está correta
            4 -> abastecimento(nomeDoHotel, nomeUsuario)
            5 -> eventos(nomeDoHotel, nomeUsuario)
            6 -> manutencaoDoAr(nomeDoHotel, nomeUsuario)
            7 ->  {
                println("Muito obrigado e até logo, $nomeUsuario.")
                break
            }
            else -> println("Opção inválida!")
        }
    }
}
