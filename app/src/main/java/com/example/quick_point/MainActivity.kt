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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quick_point.ui.theme.Quick_PointTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // El `NavHost` y el `navController` ahora están dentro de un Composable.
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    Quick_PointTheme {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "main_screen") {
            composable("main_screen") {
                MainScreen(navController = navController)
            }
            composable("pay_screen") {
                PayScreen()
            }
            composable("collect_screen") {
                CollectScreen()
            }
        }
    }
}

/**
 * El composable principal de la pantalla, ahora recibe el controlador de navegación.
 */
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Sección de Saludo
            Greeting(name = "David", modifier = Modifier.weight(1f))

            // Sección de Botones
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Botón "Pagar"
                Button(
                    onClick = {
                        // Código de navegación para el botón "Pagar"
                        navController.navigate("pay_screen")
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 4.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(painter = painterResource(id = android.R.drawable.arrow_up_float), contentDescription = "Pagar")
                        Text(text = "Pagar", textAlign = TextAlign.Center)
                    }
                }
                // Botón "Cobrar"
                Button(
                    onClick = {
                        // Código de navegación para el botón "Cobrar"
                        navController.navigate("collect_screen")
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(painter = painterResource(id = android.R.drawable.arrow_down_float), contentDescription = "Cobrar")
                        Text(text = "Cobrar", textAlign = TextAlign.Center)
                    }
                }
            }
        }
    }
}

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
            color = Color(0xFF1E88E5)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Quick_PointTheme {
        // La vista previa no necesita el controlador de navegación,
        // por lo que no lo pasamos.
        Greeting("Android")
    }
}