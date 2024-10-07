package com.example.projecte0alexcharles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.projecte0alexcharles.ui.theme.BlauText
import com.example.projecte0alexcharles.ui.theme.GrocBoto
import com.example.projecte0alexcharles.ui.theme.Projecte0AlexCharlesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projecte0AlexCharlesTheme {
                PantallaInici()
            }
        }
    }
}

@Composable
fun PantallaInici() {
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

            Button(onClick = { /* Saltar a pantalla Jugar */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCCD120)),
                modifier = Modifier.size(width = 200.dp, height = 60.dp)
            ) {
                Text(text = "Jugar",
                    color = GrocBoto,
                    fontSize = 20.sp)
            }

            //Afegir si al final es fa

            /*Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { /* Saltar a pantalla Estudiar */ }) {
                Text(text = "Estadístiques")
            }*/
        }
    }
}
