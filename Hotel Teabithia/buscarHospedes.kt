

fun buscarHospedes(nomeDoHotel: String, nomeUsuario: String) {
    val hospedes = mutableListOf<String>()
    val maxHospedes = 20

    while (true) {
        println("Selecione uma opção:")
        println("1. Cadastrar")
        println("2. Pesquisar")
        println("3. Listar")
        println("4. Sair")

        print("Opção: ")
        val opcao = readLine()?.toIntOrNull() ?: 0

        when (opcao) {
            1 -> {
                if (hospedes.size >= maxHospedes) {
                    println("Máximo de cadastros atingido.")
                } else {
                    print("Nome do hóspede: ")
                    val nome = readLine()!!
                    hospedes.add(nome)
                    println("Hóspede $nome cadastrado(a) com sucesso!")
                }
            }
            2 -> {
                print("Nome do hóspede para pesquisa: ")
                val nome = readLine()!!
                if (hospedes.contains(nome)) {
                    println("Hóspede $nome foi encontrado(a).")
                } else {
                    println("Hóspede $nome não foi encontrado(a).")
                }
            }
            3 -> {
                println("Lista de hóspedes:")
                hospedes.forEach { println(it) }
            }
            4 -> {
                println("Saindo...")
                break
            }
            else -> {
                println("Opção inválida.")
            }
        }
    }
}