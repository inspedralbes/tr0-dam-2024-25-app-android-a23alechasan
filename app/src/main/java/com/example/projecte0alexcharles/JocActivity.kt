package com.example.projecte0alexcharles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecte0alexcharles.ui.theme.BlancBoto
import com.example.projecte0alexcharles.ui.theme.BlauText
import com.example.projecte0alexcharles.ui.theme.ContornBotoGroc
import com.example.projecte0alexcharles.ui.theme.GrocBoto
import com.example.projecte0alexcharles.ui.theme.Negre
import com.example.projecte0alexcharles.data.Pregunta
import com.example.projecte0alexcharles.ui.theme.Projecte0AlexCharlesTheme


val pregunta = "Exemple"
val resposta1 = "Exemple"
val resposta2 = "Exemple"
val resposta3 = "Exemple"
val resposta4 = "Exemple"
val cronometre = 30
class JocActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projecte0AlexCharlesTheme {
                pantallaCronometre()
            }
        }
    }
}

@Composable
fun pantallaCronometre(){
    Surface (
        modifier = Modifier.fillMaxWidth()
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(text = "${pregunta}",
                style = MaterialTheme.typography.headlineSmall,
                color = BlauText,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(50.dp))

            val imatge = painterResource(R.drawable.novoylogo)
            Image(painter = imatge, contentDescription = "novoylogo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp))

            Spacer(modifier = Modifier.height(50.dp))

            Button(onClick = {  },
                colors = ButtonDefaults.buttonColors(containerColor = BlancBoto),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, BlauText), RoundedCornerShape(50.dp))
            ) {
                Text(text = resposta1,
                    fontSize = 15.sp,
                    color = Negre
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = { /*opcio2*/ },
                colors = ButtonDefaults.buttonColors(containerColor = BlancBoto),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, BlauText), RoundedCornerShape(50.dp))
            ) {
                Text(text = resposta2,
                    fontSize = 15.sp,
                    color = Negre
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = { /*opcio3*/ },
                colors = ButtonDefaults.buttonColors(containerColor = BlancBoto),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, BlauText), RoundedCornerShape(50.dp))
            ) {
                Text(text = resposta3,
                    fontSize = 15.sp,
                    color = Negre
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = { /*opcio4*/ },
                colors = ButtonDefaults.buttonColors(containerColor = BlancBoto),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, BlauText), RoundedCornerShape(50.dp))
            ) {
                Text(text = resposta4,
                    fontSize = 15.sp,
                    color = Negre
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(text = "${cronometre}s",
                fontSize = 40.sp,
                color = Negre
            )

        }
    }
}
