package com.example.lemonade

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                MakeLemonade()
            }
        }
    }
}


@Composable //отрисовка текущей страницы
fun MakeLemonade(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf(1) }

    val imageResource: Painter
    val stringResource: String

    when (result%4) {
        1 -> {
            imageResource = painterResource(R.drawable.lemon_tree);
            stringResource = stringResource(R.string.lemon_tree) }
        2 -> {
            imageResource = painterResource(R.drawable.lemon_squeeze);
            stringResource = stringResource(R.string.lemon_squeeze)}
        3 -> {
            imageResource = painterResource(R.drawable.lemon_drink);
            stringResource = stringResource(R.string.lemon_drink)}
        else -> {
            imageResource = painterResource(R.drawable.lemon_restart);
            stringResource = stringResource(R.string.lemon_restart); }
    }

    Box(
        modifier = Modifier.fillMaxSize()

    ) {
        Text(
            stringResource(R.string.app_name),
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.background(Color(0xFFFFCA28))
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .fillMaxSize()
            ){
                    Image(
                        painter = imageResource,
                        contentDescription = "1",
                        contentScale = ContentScale.Crop,
                        modifier = modifier
                            .clickable( onClick = { result++})
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFFB9F6CA))
                            .padding(32.dp, 16.dp, 32.dp, 16.dp)
                    )

                Text(
                    stringResource,
                    fontSize = 18.sp,
                    modifier = modifier
                        .padding(top = 32.dp)
                )
            }
}

@Preview(showBackground = true)
@Composable
fun CurrentPagePreview() {
    MakeLemonade()
}