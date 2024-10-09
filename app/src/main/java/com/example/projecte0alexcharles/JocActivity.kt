package com.example.projecte0alexcharles

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecte0alexcharles.ui.theme.BlancBoto
import com.example.projecte0alexcharles.ui.theme.BlauText
import com.example.projecte0alexcharles.ui.theme.Negre
import com.example.projecte0alexcharles.data.PreguntesViewModel
import com.example.projecte0alexcharles.ui.theme.Projecte0AlexCharlesTheme


var pregunta = mutableStateOf("")
var resposta1 = mutableStateOf("")
var resposta2 = mutableStateOf("")
var resposta3 = mutableStateOf("")
var resposta4 = mutableStateOf("")

var activityJoc = ComponentActivity()

class JocActivity : ComponentActivity() {
    private val viewModel: PreguntesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel.getPreguntes()
        super.onCreate(savedInstanceState)
        setContent {
            Projecte0AlexCharlesTheme {
                pantallaCronometre(activity = this, viewModel = viewModel)
                activityJoc = this
            }
        }
    }
}

@Composable
fun pantallaCronometre(activity: ComponentActivity, viewModel: PreguntesViewModel) {

    var tempsRestant by remember { mutableStateOf(30) }

    LaunchedEffect(Unit) {
        object : CountDownTimer(31000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tempsRestant = (millisUntilFinished / 1000).toInt()
            }

            override fun onFinish() {
                pantallaResultats(activity)
            }
        }.start()
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                    Text(
                        text = pregunta.value,
                        style = MaterialTheme.typography.headlineSmall,
                        color = BlauText,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .height(100.dp),
                        textAlign = TextAlign.Center
                    )

                    val imatge = painterResource(R.drawable.novoylogo)
                    Image(
                        painter = imatge,
                        contentDescription = "novoylogo",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Button(onClick = { viewModel.contestarPreguntes(1) },
                        colors = ButtonDefaults.buttonColors(containerColor = BlancBoto),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(BorderStroke(1.dp, BlauText), RoundedCornerShape(50.dp))
                    ) {
                        Text(text = resposta1.value,
                            fontSize = 15.sp,
                            color = Negre,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp))
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Button(onClick = { viewModel.contestarPreguntes(2) },
                        colors = ButtonDefaults.buttonColors(containerColor = BlancBoto),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(BorderStroke(1.dp, BlauText), RoundedCornerShape(50.dp))
                    ) {
                        Text(text = resposta2.value,
                            fontSize = 15.sp,
                            color = Negre,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp))
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Button(onClick = { viewModel.contestarPreguntes(3) },
                        colors = ButtonDefaults.buttonColors(containerColor = BlancBoto),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(BorderStroke(1.dp, BlauText), RoundedCornerShape(50.dp))
                    ) {
                        Text(text = resposta3.value,
                            fontSize = 15.sp,
                            color = Negre,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp))
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Button(onClick = { viewModel.contestarPreguntes(4) },
                        colors = ButtonDefaults.buttonColors(containerColor = BlancBoto),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(BorderStroke(1.dp, BlauText), RoundedCornerShape(50.dp))
                    ) {
                        Text(text = resposta4.value,
                            fontSize = 15.sp,
                            color = Negre,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp))
                    }
                }

                Text(text = "${tempsRestant}s",
                    fontSize = 40.sp,
                    color = Negre,
                    modifier = Modifier.padding(top = 16.dp))

        }
    }
}

fun pantallaResultats(activity: ComponentActivity) {
    val intent = Intent(activity, FinalActivity::class.java)
    activity.startActivity(intent)
}
