 package com.example.vernam

 class calcular(var pass: String, var key: String){

    operator fun invoke(): String {
        var finalpass = diccionario(pass)
        return finalpass
    }

    fun diccionario(pass: String):String {

        var pass = pass
        var key = key
        var auxNullChar: Char
        var contador: Int
        var aux:String
        var final = ""
        val passSeparada = arrayOfNulls<Char>(pass.length)
        val keySeparada = arrayOfNulls<Char>(pass.length)
        val passBinaria = arrayOfNulls<String>(pass.length)
        val keyBinaria = arrayOfNulls<String>(pass.length)
        val encriptada = arrayOfNulls<Int>(pass.length)

        for (i in pass.indices) {
            passSeparada[i] = pass[i]
            keySeparada[i] = key[(key.length) - 1]
        }
        if (pass.length <= key.length){
            for (i in pass.indices) {
                keySeparada[i] =key[i]
            }
        } else{
            for (i in key.indices) {
                keySeparada[i] =key[i]
            }
        }

        for (i in pass.indices){
            auxNullChar = passSeparada[i]!!
            passBinaria[i] = Integer.toBinaryString(auxNullChar.toInt())
            auxNullChar = keySeparada[i]!!
            keyBinaria[i] = Integer.toBinaryString(auxNullChar.toInt())
        }

        for (i in pass.indices){
            encriptada[i]= xor(passBinaria[i]!!, keyBinaria[i]!!).toInt()
        }

        for (i in pass.indices) {
            aux = Integer.parseInt(encriptada[i].toString(), 2).toString()
            aux = Character.toString((aux.toInt()).toChar())
            final = "$final$aux"
        }
        return final
    }

    private fun xor(passBinaria: String, keyBinaria: String): String {

        var passNumero = arrayOfNulls<Char>(8)
        var keyNumero = arrayOfNulls<Char>(8)
        var encriptadaNumero = arrayOfNulls<String>(8)
        var aux:String
        var finalNumero = "0"

        passNumero = binario8(passBinaria, passNumero)
        keyNumero = binario8(keyBinaria, keyNumero)

        for(i in 0 until 8){
            if (passNumero[i] == '0' && keyNumero[i] == '0'){
                encriptadaNumero[i] = "0"
            } else if (passNumero[i] == '1' && keyNumero[i] == '1'){
                encriptadaNumero[i] = "0"
            } else if (passNumero[i] == '1' && keyNumero[i] == '0'){
                encriptadaNumero[i] = "1"
            } else if (passNumero[i] == '0' && keyNumero[i] == '1'){
                encriptadaNumero[i] = "1"
            }
        }

        for (i in 0 until 8) {
            aux = encriptadaNumero[i].toString()
            finalNumero = "$finalNumero$aux"
        }

        return finalNumero
    }

    fun binario8(binario: String, numero: Array<Char?>): Array<Char?> {

        var contador: Int

        for (i in 0 until 8) {
            numero[i] = '0'
        }
        if (binario.length == 8){
            for (i in (binario.length-1) downTo (binario.length-8)) {
                numero[i] = binario[i]
            }
        } else if(binario.length < 8){
            contador = 7
            for (i in (binario.length-1) downTo 0) {
                numero[contador] = binario[i]
                contador -= 1
            }
        }else{
            contador = 7
            for (i in (binario.length-1) downTo (binario.length-8)) {
                numero[contador] = binario[i]
                contador -= 1
            }
        }
        return numero
    }
}