package com.example.projecte0alexcharles.data

import com.example.projecte0alexcharles.JocActivity
import com.example.projecte0alexcharles.activityJoc
import com.example.projecte0alexcharles.encertades
import com.example.projecte0alexcharles.pantallaResultats
import com.example.projecte0alexcharles.pregunta
import com.example.projecte0alexcharles.resposta1
import com.example.projecte0alexcharles.resposta2
import com.example.projecte0alexcharles.resposta3
import com.example.projecte0alexcharles.resposta4

val respostesUsuari: MutableList<Int> = mutableListOf()
val preguntes = MutableList(0) {Pregunta()}
var IndexpreguntaActual = 0

public fun getPreguntes(){
    val pregunta1 = Pregunta(
        index = 1,
        pregunta = "¿Está permitido entablar competiciones de velocidad en las autopistas?",
        respostes = listOf(
            Resposta(1, "A) No, está totalmente prohibido."),
            Resposta(2, "B) No se podrá realizar en autopistas, pero sí en vías secundarias."),
            Resposta(3, "C) Sí, pero siempre y cuando se haga por conductores experimentados."),
            Resposta(4, "D) Sí, pero solo si son coches con licencia para ello.")
        ),
        numeroImatge = 1
    )
    val pregunta2 = Pregunta(
        index = 1,
        pregunta = "¿Quant és 2 + 2?",
        respostes = listOf(
            Resposta(1, "A) 1"),
            Resposta(2, "B) 2"),
            Resposta(3, "C) 3"),
            Resposta(4, "D) 4")
        ),
        numeroImatge = 1
    )
    val pregunta3 = Pregunta(
        index = 1,
        pregunta = "¿El pepe?",
        respostes = listOf(
            Resposta(1, "A) Si"),
            Resposta(2, "B) No"),
            Resposta(3, "C) Puede"),
            Resposta(4, "D) Ns/Nc")
        ),
        numeroImatge = 1
    )

    preguntes.add(pregunta1)
    preguntes.add(pregunta2)
    preguntes.add(pregunta3)

    actualitzarPreguntes()
}

fun contestarPreguntes(numeroResposta: Int){
    respostesUsuari.add(numeroResposta)
    IndexpreguntaActual += 1

    if (IndexpreguntaActual >= preguntes.size){
        comprovarPreguntes(respostesUsuari)
        pantallaResultats(activityJoc)
    } else {
        actualitzarPreguntes()
    }
}

fun actualitzarPreguntes(){
    pregunta.value = preguntes[IndexpreguntaActual].pregunta
    resposta1.value = preguntes[IndexpreguntaActual].respostes[0].etiqueta
    resposta2.value = preguntes[IndexpreguntaActual].respostes[1].etiqueta
    resposta3.value = preguntes[IndexpreguntaActual].respostes[2].etiqueta
    resposta4.value = preguntes[IndexpreguntaActual].respostes[3].etiqueta
}

fun comprovarPreguntes(respostes: MutableList<Int>){
    //comprovar al servidor

    // encertades = ??
    // fallades = ??
}

data class Resposta(
    val id: Int,
    val etiqueta: String
)

class Pregunta {
    var index: Int = 0
    var pregunta: String = ""
    var respostes: List<Resposta> = listOf()
    var numeroImatge: Int = 0

    constructor(index: Int, pregunta: String, respostes: List<Resposta>, numeroImatge: Int) {
        this.index = index
        this.pregunta = pregunta
        this.respostes = respostes
        this.numeroImatge = numeroImatge
    }
    constructor()
}