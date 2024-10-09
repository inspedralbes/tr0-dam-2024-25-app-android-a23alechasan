package com.example.projecte0alexcharles

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.projecte0alexcharles.ui.theme.Projecte0AlexCharlesTheme
import com.example.projecte0alexcharles.ui.theme.VerdEncertades
import com.example.projecte0alexcharles.ui.theme.VermellFallades


var encertades = "0"
var fallades = "0"
class FinalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projecte0AlexCharlesTheme {
                pantallaFinal(this)
            }
        }
    }
}

@Composable
fun pantallaFinal(activity: ComponentActivity) {

    Surface (
        modifier = Modifier.fillMaxWidth()
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        )
        {
            Text(text = "Encertades:",
                style = MaterialTheme.typography.headlineMedium,
                color = VerdEncertades,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "${encertades}",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 70.sp
                ),
                color = VerdEncertades,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Fallades:",
                style = MaterialTheme.typography.headlineMedium,
                color = VermellFallades,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "${fallades}",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 70.sp
                ),
                color = VermellFallades,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(30.dp))


            Button(onClick = { pantallaInici(activity) },
                colors = ButtonDefaults.buttonColors(containerColor = GrocBoto),
                modifier = Modifier.size(width = 200.dp, height = 60.dp)
                    .border(BorderStroke(1.dp, ContornBotoGroc) ,RoundedCornerShape(50.dp))
            ) {
                Text(text = "Tornar a Jugar",
                    fontSize = 20.sp,
                    color = Negre)
            }

        }
    }
}

fun pantallaInici(activity: ComponentActivity) {
    val intent = Intent(activity, MainActivity::class.java)
    activity.startActivity(intent)
}

