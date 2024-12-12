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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
    // Estado que guarda el paso actual
    var currentStep by remember { mutableStateOf(1) }

    // Estado del campo de texto
    var userInput by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "APP de Daniel",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
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
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                // Campo de texto editable
                OutlinedTextField(
                    value = userInput,
                    onValueChange = { userInput = it },
                    label = { Text("Escribe algo") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.padding_horizontal))
                )

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))

                // Texto dinámico que refleja lo que el usuario escribe
                Text(
                    text = "$userInput",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))


                // Muestra el contenido basado en el paso actual


                when (currentStep) {

                    1 -> {
                        LemonTextAndImage(
                            textLabelResourceId = R.string.persona,
                            drawableResourceId = R.drawable.domingo_savio,
                            contentDescriptionResourceId = R.string.lemon_tree_content_description
                        )
                    }
                    2 -> {
                        LemonTextAndImage(
                            textLabelResourceId = R.string.persona,
                            drawableResourceId = R.drawable.don_bosco,
                            contentDescriptionResourceId = R.string.pregunta
                        )
                    }
                    3 -> {
                        LemonTextAndImage(
                            textLabelResourceId = R.string.persona,
                            drawableResourceId = R.drawable.mama_margarita,
                            contentDescriptionResourceId = R.string.pregunta
                        )
                    }
                    4 -> {
                        LemonTextAndImage(
                            textLabelResourceId = R.string.persona,
                            drawableResourceId = R.drawable.maria_auxiliadora,
                            contentDescriptionResourceId = R.string.pregunta
                        )
                    }
                }

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Botón "Anterior"
                    Button(
                        onClick = {
                            currentStep = if (currentStep > 1) currentStep - 1 else 4
                        },
                        shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Text(text = stringResource(R.string.previous))
                    }

                    // Botón "Siguiente"
                    Button(
                        onClick = {
                            currentStep = if (currentStep < 4) currentStep + 1 else 1
                        },
                        shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Text(text = stringResource(R.string.next))
                    }
                }
            }
        }
    }
}

@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int,
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
                .width(dimensionResource(R.dimen.button_image_width))
                .height(dimensionResource(R.dimen.button_image_height))
                .padding(dimensionResource(R.dimen.button_interior_padding))
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
        Text(
            text = stringResource(textLabelResourceId),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun LemonPreview() {
    AppTheme {
        LemonadeApp()
    }
}