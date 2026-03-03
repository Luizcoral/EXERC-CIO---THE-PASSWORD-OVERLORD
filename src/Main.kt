//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val listaDeRegras = listOf(
    Requisito("PRECISA TER EXATAMENTE 21 CARACTERES") { it.length >= 8 },
    Requisito("Deve conter o ano do que o inter foi fundado!") { it.contains("1909") },
    Requisito("Deve conter o nome do unico time do RS campeao do mundo e que nunca foi rebaixado 3 vezes (letra maiscula)! ") { it.contains("INTERNACIONAL") },
    Requisito("Deve conter o nome da melhor linguagem de programação (letra maiscula)! ") { it.contains("JAVA") })

    var senhaAprovada = false

    do {
        println("\nDigite sua senha:")
        val entrada = readLine() ?: "" // Null Safety com operador Elvis

        var erroEncontrado: String? = null

        for (regra in listaDeRegras) {
            if (!regra.validacao(entrada)) {
                erroEncontrado = regra.mensagemErro
                break
            }


        }
        if (erroEncontrado != null) {
            println("X ERRO: $erroEncontrado")
        } else {
            println("SUCESSO! Senha aceite pelo Overlord.")
            senhaAprovada = true
        }
        } while (!senhaAprovada)


}


data class Requisito(
     val mensagemErro: String,
     val  validacao: (String) -> Boolean
){
}