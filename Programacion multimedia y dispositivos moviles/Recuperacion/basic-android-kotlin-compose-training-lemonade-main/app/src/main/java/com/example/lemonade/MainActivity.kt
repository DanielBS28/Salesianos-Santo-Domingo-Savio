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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                LemonadeApp()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    // Estados
    var currentStep by remember { mutableStateOf(1) }
    var userInput by remember { mutableStateOf("") }
    var feedback by remember { mutableStateOf("") }
    val personas = listOf(
        "Domingo Savio",
        "Don Bosco",
        "Mama Margarita",
        "Maria Auxiliadora"
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "APP de Daniel",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color(0xFFDC0814) // Rojo #dc0814
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Imagen del logotipo del colegio
                Image(
                    painter = painterResource(R.drawable.salesianosdosa),
                    contentDescription = "Logotipo del Colegio",
                    modifier = Modifier
                        .width(250.dp)
                        .height(70.dp)
                )

                // La pregunta: ¿Quién es la persona en la imagen? - Arriba del campo de texto
                Text(
                    text = "¿Quién es la persona que está en esta imagen?",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp) // Más espacio entre pregunta y campo
                )

                // Espacio reducido entre la pregunta y el campo de texto
                Spacer(modifier = Modifier.height(8.dp)) // Menos espacio entre la pregunta y el campo

                // Campo de texto editable
                OutlinedTextField(
                    value = userInput,
                    onValueChange = { userInput = it },
                    label = { Text("Escribe el nombre de la persona") },
                    modifier = Modifier.fillMaxWidth()
                )

                // Espacio aumentado entre la imagen y el campo de texto
                Spacer(modifier = Modifier.height(24.dp)) // Más espacio entre la imagen y el campo de texto

                // Imagen y descripción dinámica
                val drawableRes = when (currentStep) {
                    1 -> R.drawable.domingo_savio
                    2 -> R.drawable.don_bosco
                    3 -> R.drawable.mama_margarita
                    4 -> R.drawable.maria_auxiliadora
                    else -> R.drawable.domingo_savio
                }

                LemonTextAndImage(
                    drawableResourceId = drawableRes,
                    contentDescriptionResourceId = R.string.persona
                )

                // Texto de retroalimentación (correcto o incorrecto) debajo de la imagen
                if (feedback.isNotEmpty()) {
                    Text(
                        text = feedback,
                        color = when {
                            feedback == "Correcto" -> Color.Green
                            feedback.startsWith("La solución es") -> Color.Black
                            else -> Color.Red
                        },
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                // Espaciado entre los botones
                Spacer(modifier = Modifier.height(8.dp))

                // Fila para los botones "Anterior" y "Siguiente"
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            feedback = ""
                            currentStep = if (currentStep > 1) currentStep - 1 else 4
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                        modifier = Modifier
                            .weight(1f) // Asegura un tamaño uniforme
                            .padding(4.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.previous),
                            fontSize = 16.sp
                        )
                    }

                    Button(
                        onClick = {
                            feedback = ""
                            currentStep = if (currentStep < 4) currentStep + 1 else 1
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

                // Espaciado reducido entre los botones de comprobar y mostrar solución
                Spacer(modifier = Modifier.height(8.dp))

                // Botones "Comprobar" y "Mostrar Solución" en la misma columna
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp), // Menor espaciado entre botones
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Botón "Comprobar"
                    Button(
                        onClick = {
                            feedback = if (userInput == personas[currentStep - 1]) "Correcto" else "Incorrecto"
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC0814)), // Rojo #dc0814
                        modifier = Modifier
                            .width(200.dp) // Tamaño fijo para que no ocupe todo el ancho
                    ) {
                        Text(
                            text = "Comprobar",
                            fontSize = 16.sp
                        )
                    }

                    // Botón "Mostrar Solución"
                    Button(
                        onClick = {
                            feedback = "La solución es: ${personas[currentStep - 1]}"
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                        modifier = Modifier
                            .width(200.dp) // Tamaño fijo para que no ocupe todo el ancho
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
                .width(320.dp)
                .height(340.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview
@Composable
fun LemonPreview() {
    AppTheme {
        LemonadeApp()
    }
}
