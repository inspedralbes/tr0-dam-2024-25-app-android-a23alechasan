package com.example.projecte0alexcharles.data


class Pregunta {
    var index: Int = 0
    var pregunta: String = ""
    var respostes: List<String> = listOf()
    var numeroImatge: Int = 0

    constructor(index: Int, pregunta: String, respostes: List<String>, numeroImatge: Int) {
        this.index = index
        this.pregunta = pregunta
        this.respostes = respostes
        this.numeroImatge = numeroImatge
    }
    constructor()

    public fun getPreguntes(){
        // Agafar Preguntes
        // posar valors JocActivity
    }

    public fun contestarPreguntes(numeroResposta: Int){
        respostesUsuari.add(numeroResposta)
        preguntaActual += 1
        // actualitzar valors JocActivity
    }
}

val respostesUsuari: MutableList<Int> = mutableListOf()
val preguntes = MutableList(0) {Pregunta()}

var preguntaActual = 0
