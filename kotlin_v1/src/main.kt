import basic.*

fun calcula(a:  Int, b: Int) :Int{
    return a*b*b
}

fun cad(nome: String = "", idade: Int ?= null, cpf: String="" ){
    println("Nome = $nome\nIdade = $idade\ncpf = $cpf")
}

fun media(vararg valores: Int): Float{
    if(valores.isNotEmpty()){
        var soma = 0;
        for(i in valores)
            soma+=i

        return (soma/valores.size).toFloat()
    }
    return 0f
}



fun main(){

    println("olá mundo imundo!")
    var nome = "Tarcisio"
    var idade = 10
    var po: Int ?= null
    println("Nome: $nome\nIdade = $idade")
    println("${calcula(10,20)} = Fim")
    println("PO = $po")

    //Operador Elvis verifica se uma variável é nula
    val op : Int = po ?: 1
    //caso po seja nula, op = 1

    when(nome){
        "Tarcisio" -> {
            idade+=10
        }
        else ->{
            println("Nada")
        }
    }
    for(i in 1..100){
        println(i)
    }
    for(i in 1..100 step 3){
        println("teste $i")
    }
    try {
        print("teste".toInt())
    }catch (e: Exception){
        println("Valor inválido")
    }
    ola()
    teste1()
    cad(nome= "Tarcisio",cpf = "123")
    println("Média = ${media(1,5,6,9,8,7,6,5,4,9,15,3,45,69)}")
}

