package com.example.clickbehavior

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clickbehavior.ui.LemonadeUiState
import com.example.clickbehavior.ui.LemonadeViewModel
import com.example.clickbehavior.ui.theme.ClickBehaviorTheme


// https://developer.android.com/courses/android-basics-compose/course?hl=es-419

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClickBehaviorTheme {
                val lemonadeViewModel = LemonadeViewModel()
                Greeting(lemonadeViewModel = lemonadeViewModel)
            }
        }
    }
}

@Composable
fun Greeting(lemonadeViewModel: LemonadeViewModel) {
    val lemonadeUiState by lemonadeViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.lemonade_content_description),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF9E44C))
                .padding(25.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        ImageAndText(
            lemonadeUiState = lemonadeUiState,
            onImageClick = { lemonadeViewModel.handleClick() }
        )
    }
}

@Composable
fun ImageAndText(
    modifier: Modifier = Modifier,
    lemonadeUiState: LemonadeUiState,
    onImageClick: () -> Unit
) {
    val (imagen, textoID, sufijo) = when (lemonadeUiState.screen) {
        1 -> Triple(R.drawable.lemon_tree, R.string.lemon_select, "")
        2 -> Triple(
            R.drawable.lemon_squeeze,
            R.string.lemon_squeeze,
            "(${lemonadeUiState.squeezeCount}/${lemonadeUiState.squeeze})"
        )
        3 -> Triple(R.drawable.lemon_drink, R.string.lemon_drink, "")
        else -> Triple(R.drawable.lemon_restart, R.string.lemon_empty_glass, "")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = imagen),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(Color(0xFFC2EAD1))
                .size(220.dp)
                .clickable { onImageClick() }
        )
        Text(
            text = stringResource(textoID) + sufijo,
            modifier = Modifier
                .padding(8.dp)
                .padding(top = 16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClickBehaviorTheme {
        Greeting(LemonadeViewModel())
    }
}