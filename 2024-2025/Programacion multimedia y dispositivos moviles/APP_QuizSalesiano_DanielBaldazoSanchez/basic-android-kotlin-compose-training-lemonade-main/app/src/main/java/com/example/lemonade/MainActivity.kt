package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.AppTheme

// Clase principal que define la actividad de la app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Habilita la funcionalidad de diseño sin bordes en dispositivos modernos
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            // Establece el tema de la app y llama a la función principal de la UI
            AppTheme {
                LemonadeApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    // Variables de estado para la aplicación
    var currentStep by remember { mutableStateOf(1) } // Controla la foto/persona actual
    var userInput by remember { mutableStateOf("") } // Almacena la entrada del usuario
    var feedback by remember { mutableStateOf("") } // Retroalimentación para el usuario

    // Lista de nombres de personas que el usuario debe identificar
    val personas = listOf(
        "Domingo Savio",
        "Don Bosco",
        "Mama Margarita",
        "Maria Auxiliadora"
    )

    // Contenedor principal con una barra superior y el cuerpo
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    // Título de la app en la barra superior
                    Text(
                        text = "APP de Daniel",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color(0xFFDC0814) // Fondo rojo para la barra superior
                )
            )
        }
    ) { innerPadding ->
        // Superficie que ocupa toda la pantalla
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer), // Color de fondo
            color = MaterialTheme.colorScheme.background
        ) {
            // Estructura en columna para los elementos
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente
                verticalArrangement = Arrangement.Top, // Coloca los elementos en la parte superior
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp) // Margen interno
            ) {
                // Imagen del logotipo del colegio
                Image(
                    painter = painterResource(R.drawable.salesianosdosa),
                    contentDescription = "Logotipo del Colegio",
                    modifier = Modifier
                        .width(180.dp)
                        .height(38.dp)
                )

                // Texto de la pregunta para el usuario
                Text(
                    text = "¿Quién aparece en la siguiente fotografía?",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 15.dp) // Espaciado superior
                )

                Spacer(modifier = Modifier.height(5.dp)) // Espacio entre elementos

                // Campo de texto donde el usuario escribe su respuesta
                OutlinedTextField(
                    value = userInput,
                    onValueChange = { userInput = it }, // Actualiza el estado con el texto ingresado
                    label = { Text("Escribe su nombre") },
                    modifier = Modifier.fillMaxWidth() // Ocupa todo el ancho disponible
                )

                Spacer(modifier = Modifier.height(24.dp)) // Más espacio antes de la imagen

                // Determina qué imagen mostrar según el paso actual
                val drawableRes = when (currentStep) {
                    1 -> R.drawable.domingo_savio
                    2 -> R.drawable.don_bosco
                    3 -> R.drawable.mama_margarita
                    4 -> R.drawable.maria_auxiliadora
                    else -> R.drawable.domingo_savio
                }

                // Muestra la imagen correspondiente
                LemonTextAndImage(
                    drawableResourceId = drawableRes,
                    contentDescriptionResourceId = R.string.persona
                )

                // Muestra retroalimentación si hay contenido en `feedback`
                if (feedback.isNotEmpty()) {
                    Text(
                        text = feedback,
                        color = when {
                            feedback == "Correcto" -> Color.Green // Verde para respuestas correctas
                            feedback.startsWith("La solución es") -> Color.Black // Negro para soluciones
                            else -> Color.Red // Rojo para incorrectas
                        },
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre elementos

                // Botones de navegación (anterior y siguiente)
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly, // Distribuye uniformemente
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            feedback = "" // Limpia retroalimentación
                            userInput = "" // Limpia la entrada del usuario
                            currentStep = if (currentStep > 1) currentStep - 1 else 4 // Retrocede o vuelve al final
                        },
                        shape = RoundedCornerShape(12.dp), // Bordes redondeados
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                        modifier = Modifier
                            .weight(1f) // Tamaño proporcional
                            .padding(4.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.previous), // Texto del botón
                            fontSize = 16.sp
                        )
                    }

                    Button(
                        onClick = {
                            feedback = "" // Limpia retroalimentación
                            userInput = "" // Limpia la entrada del usuario
                            currentStep = if (currentStep < 4) currentStep + 1 else 1 // Avanza o vuelve al inicio
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.next),
                            fontSize = 16.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre secciones

                // Botones de acción (Comprobar y Mostrar solución)
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Centra en la columna
                    verticalArrangement = Arrangement.spacedBy(8.dp), // Espaciado entre botones
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            feedback = if (userInput == personas[currentStep - 1]) "Correcto" else "Incorrecto"
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC0814)),
                        modifier = Modifier.width(200.dp) // Botón de tamaño fijo
                    ) {
                        Text(
                            text = "Comprobar",
                            fontSize = 16.sp
                        )
                    }

                    Button(
                        onClick = {
                            feedback = "La solución es: ${personas[currentStep - 1]}"
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF19478C)),
                        modifier = Modifier.width(200.dp)
                    ) {
                        Text(
                            text = "Mostrar Solución",
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}

// Componente para mostrar imagen y su descripción
@Composable
fun LemonTextAndImage(
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(drawableResourceId),
            contentDescription = stringResource(contentDescriptionResourceId),
            modifier = Modifier
                .width(220.dp)
                .height(250.dp)
        )
        Spacer(modifier = Modifier.height(8.dp)) // Espaciado inferior
    }
}

// Función para previsualizar el diseño en Android Studio
@Preview
@Composable
fun LemonPreview() {
    AppTheme {
        LemonadeApp()
    }
}
