package com.example.tiptime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiptime.ui.theme.TipTimeTheme
import java.text.NumberFormat

class PantallaPrincipal : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    DiseñoPrincipal()
                }
            }
        }
    }
}

@Composable
fun DiseñoPrincipal() {
    var importeIntroducido by remember { mutableStateOf("") }
    var porcentajePropinaIntroducido by remember { mutableStateOf("") }
    var redondearPropina by remember { mutableStateOf(false) }

    val importe = importeIntroducido.toDoubleOrNull() ?: 0.0
    val porcentajePropina = porcentajePropinaIntroducido.toDoubleOrNull() ?: 0.0
    val propinaFinal = calcularPropina(importe, porcentajePropina, redondearPropina)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        CampoTexto(
            etiqueta = R.string.bill_amount,
            iconoPrincipal = R.drawable.money,
            opcionesTeclado = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            valor = importeIntroducido,
            alCambiarValor = { importeIntroducido = it },
            modificador = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
        )
        CampoTexto(
            etiqueta = R.string.how_was_the_service,
            iconoPrincipal = R.drawable.percent,
            opcionesTeclado = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            valor = porcentajePropinaIntroducido,
            alCambiarValor = { porcentajePropinaIntroducido = it },
            modificador = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
        )
        FilaRedondearPropina(
            redondear = redondearPropina,
            alCambiarRedondeo = { redondearPropina = it },
            modificador = Modifier.padding(bottom = 32.dp)
        )
        Text(
            text = stringResource(R.string.tip_amount, propinaFinal),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun CampoTexto(
    @StringRes etiqueta: Int,
    @DrawableRes iconoPrincipal: Int,
    opcionesTeclado: KeyboardOptions,
    valor: String,
    alCambiarValor: (String) -> Unit,
    modificador: Modifier = Modifier
) {
    TextField(
        value = valor,
        singleLine = true,
        leadingIcon = { Icon(painter = painterResource(id = iconoPrincipal), null) },
        modifier = modificador,
        onValueChange = alCambiarValor,
        label = { Text(stringResource(etiqueta)) },
        keyboardOptions = opcionesTeclado
    )
}

@Composable
fun FilaRedondearPropina(
    redondear: Boolean,
    alCambiarRedondeo: (Boolean) -> Unit,
    modificador: Modifier = Modifier
) {
    Row(
        modifier = modificador.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            checked = redondear,
            onCheckedChange = alCambiarRedondeo
        )
    }
}

private fun calcularPropina(importe: Double, porcentaje: Double = 15.0, redondear: Boolean): String {
    var propina = porcentaje / 100 * importe
    if (redondear) {
        propina = kotlin.math.ceil(propina)
    }
    return NumberFormat.getCurrencyInstance().format(propina)
}

@Preview(showBackground = true)
@Composable
fun VistaPreviaDiseñoPrincipal() {
    TipTimeTheme {
        DiseñoPrincipal()
    }
}
