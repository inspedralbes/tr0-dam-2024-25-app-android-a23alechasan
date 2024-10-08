package com.example.projecte0alexcharles

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.projecte0alexcharles.ui.theme.BlauText
import com.example.projecte0alexcharles.ui.theme.ContornBotoGroc
import com.example.projecte0alexcharles.ui.theme.GrocBoto
import com.example.projecte0alexcharles.ui.theme.Negre
import com.example.projecte0alexcharles.ui.theme.Projecte0AlexCharlesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projecte0AlexCharlesTheme {
                PantallaInici(this)
            }
        }
    }
}
private fun canviarPantallaJoc(activity: ComponentActivity) {
    val intent = Intent(activity, JocActivity::class.java)
    activity.startActivity(intent)
}

@Composable
fun PantallaInici(activity: ComponentActivity) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        //color = Color(0xFFBBDEFB)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val image = painterResource(R.drawable.novoylogo)
            Image(painter = image, contentDescription = "novoylogo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp))    

            Spacer(modifier = Modifier.height(50.dp))

            Text(text = "Benvingut a Testos de Conduir!",
                style = MaterialTheme.typography.headlineSmall,
                color = BlauText,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(50.dp))

            Button(onClick = { canviarPantallaJoc(activity) },
                colors = ButtonDefaults.buttonColors(containerColor = GrocBoto),
                modifier = Modifier.size(width = 200.dp, height = 60.dp)
                    .border(BorderStroke(1.dp, ContornBotoGroc) ,RoundedCornerShape(50.dp))
            ) {
                Text(text = "Jugar",
                    fontSize = 20.sp,
                    color = Negre)
            }

            //Afegir si al final es fa

            /*Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { /* Saltar a pantalla Estudiar */ }) {
                Text(text = "Estadístiques")
            }*/
        }
    }
}
