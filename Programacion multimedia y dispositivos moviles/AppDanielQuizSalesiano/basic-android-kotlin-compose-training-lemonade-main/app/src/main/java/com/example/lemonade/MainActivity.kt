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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.LemonadeViewModel
import com.example.lemonade.ui.LemonadeUiState
import com.example.lemonade.ui.theme.AppTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
    val lemonadeViewModel: LemonadeViewModel = viewModel()  // Aquí lo inicializamos de manera correcta
    val uiState by lemonadeViewModel.uiState.collectAsState()

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
                    text = "¿Quién aparece en la siguiente fotografía?",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp) // Más espacio entre pregunta y campo
                )

                // Espacio reducido entre la pregunta y el campo de texto
                Spacer(modifier = Modifier.height(8.dp)) // Menos espacio entre la pregunta y el campo

                // Campo de texto editable
                OutlinedTextField(
                    value = uiState.userInput,
                    onValueChange = { lemonadeViewModel.updateUserInput(it) },
                    label = { Text("Escribe su nombre") },
                    modifier = Modifier.fillMaxWidth()
                )

                // Espaciado aumentado entre la imagen y el campo de texto
                Spacer(modifier = Modifier.height(24.dp)) // Más espacio entre la imagen y el campo de texto

                // Imagen y descripción dinámica
                LemonTextAndImage(
                    drawableResourceId = uiState.drawableResourceId,
                    contentDescriptionResourceId = R.string.persona
                )

                // Texto de retroalimentación (correcto o incorrecto) debajo de la imagen
                if (uiState.feedback.isNotEmpty()) {
                    Text(
                        text = uiState.feedback,
                        color = when {
                            uiState.feedback == "Correcto" -> Color.Green
                            uiState.feedback.startsWith("La solución es") -> Color.Black
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
                            lemonadeViewModel.navigatePrevious()
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
                            lemonadeViewModel.navigateNext()
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
                            lemonadeViewModel.checkAnswer()
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
                            lemonadeViewModel.showSolution()
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF19478C)),
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
