package com.example.quick_point

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import com.example.quick_point.ui.theme.Quick_pointTheme

// La clase principal de la actividad.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Quick_pointTheme {
                // Llama a la pantalla principal de la aplicación.
                MainScreen()
            }
        }
    }
}

/**
 * El composable principal que construye la interfaz de usuario de la pantalla.
 * Representa toda la pantalla del teléfono visible en la imagen.
 */
@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        // Un Column es un contenedor que organiza a sus hijos verticalmente.
        // Aquí lo usamos para organizar el saludo en la parte superior y los botones en la inferior.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Sección de Saludo: Este composable muestra el texto "¡Hola David!".
            // Ocupa el espacio restante en el medio de la pantalla.
            Greeting(name = "David", modifier = Modifier.weight(1f))

            // Sección de Botones: Este Row es un contenedor que organiza a sus hijos horizontalmente.
            // Se coloca en la parte inferior de la pantalla.
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), // Agrega un relleno alrededor de los botones.
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Botón "Pagar": Visualmente se encuentra en la parte inferior izquierda de la pantalla.
                Button(
                    onClick = { /* TODO: Agrega la funcionalidad para 'Pagar' aquí */ },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 4.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        // Icono de flecha hacia arriba.
                        Icon(painter = painterResource(id = android.R.drawable.arrow_up_float), contentDescription = "Pagar")
                        // Texto "Pagar" debajo del icono.
                        Text(text = "Pagar", textAlign = TextAlign.Center)
                    }
                }
                // Botón "Cobrar": Visualmente se encuentra en la parte inferior derecha de la pantalla.
                Button(
                    onClick = { /* TODO: Agrega la funcionalidad para 'Cobrar' aquí */ },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        // Icono de flecha hacia abajo.
                        Icon(painter = painterResource(id = android.R.drawable.arrow_down_float), contentDescription = "Cobrar")
                        // Texto "Cobrar" debajo del icono.
                        Text(text = "Cobrar", textAlign = TextAlign.Center)
                    }
                }
            }
        }
    }
}

/**
 * Este composable muestra el mensaje de saludo "¡Hola David!".
 * Se ve como el texto azul y grande en el centro de la pantalla.
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "¡Hola $name!",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E88E5) // El color azul del texto en la imagen.
        )
    }
}

/**
 * Este composable es una vista previa de la pantalla completa en Android Studio.
 * No es parte de la aplicación, solo te permite ver cómo se verá el diseño.
 */
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Quick_pointTheme {
        MainScreen()
    }
}