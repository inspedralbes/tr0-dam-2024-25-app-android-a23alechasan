package com.example.projecte0alexcharles.data

import android.util.Log
import com.example.projecte0alexcharles.JocActivity
import com.example.projecte0alexcharles.activityJoc
import com.example.projecte0alexcharles.encertades
import com.example.projecte0alexcharles.pantallaResultats
import com.example.projecte0alexcharles.pregunta
import com.example.projecte0alexcharles.resposta1
import com.example.projecte0alexcharles.resposta2
import com.example.projecte0alexcharles.resposta3
import com.example.projecte0alexcharles.resposta4
import com.example.projecte0alexcharles.network.*
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PreguntesViewModel : ViewModel() {
    val respostesUsuari: MutableList<Int> = mutableListOf()
    val preguntes = MutableList(0) { Pregunta() }
    var IndexpreguntaActual = 0
    var uuid = ""

    fun getPreguntes() {
        viewModelScope.launch {
            try {
                val listResult = PreguntesAPI.PreguntesAPi.retrofitService.getPreguntesJSON(20)
                val preguntesProvisional = parsePreguntes(listResult)

                for (pregunta in preguntesProvisional){
                    preguntes.add(pregunta)
                }

            } catch (e: Exception) {
                Log.e("PreguntesViewModel", "Error al carregar les preguntes: ${e.message}")
            }
        }
    }

    fun contestarPreguntes(numeroResposta: Int) {
        respostesUsuari.add(numeroResposta)
        IndexpreguntaActual += 1

        if (IndexpreguntaActual >= preguntes.size) {
            comprovarPreguntes(respostesUsuari)
            pantallaResultats(activityJoc)
        } else {
            actualitzarPreguntes()
        }
    }

    fun actualitzarPreguntes() {
        pregunta.value = preguntes[IndexpreguntaActual].pregunta
        resposta1.value = preguntes[IndexpreguntaActual].respostes[0].etiqueta
        resposta2.value = preguntes[IndexpreguntaActual].respostes[1].etiqueta
        resposta3.value = preguntes[IndexpreguntaActual].respostes[2].etiqueta
        resposta4.value = preguntes[IndexpreguntaActual].respostes[3].etiqueta
    }

    fun comprovarPreguntes(respostes: MutableList<Int>) {
        // comprovar al servidor
        // encertades = ??
        // fallades = ??
    }

    fun parsePreguntes(json: String): List<Pregunta> {
        val gson = Gson()
        val responseMap = gson.fromJson(json, Map::class.java)
        uuid = responseMap["sessionId"] as String
        val quizs = responseMap["quizs"] as List<Map<String, Any>>
        val preguntesProvisional = mutableListOf<Pregunta>()
        for ((index, quiz) in quizs.withIndex()) {
            val respostesJson = quiz["respostes"] as List<Map<String, Any>>
            val respostes = respostesJson.map { resposta ->
                Resposta(
                    id = resposta["id"] as Int,
                    etiqueta = resposta["etiqueta"] as String
                )
            }
            val novaPregunta = Pregunta(
                index = index,
                pregunta = quiz["pregunta"] as String,
                respostes = respostes,
                numeroImatge = quiz["id"] as Int
            )
            preguntesProvisional.add(novaPregunta)
        }
        return preguntesProvisional
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
}