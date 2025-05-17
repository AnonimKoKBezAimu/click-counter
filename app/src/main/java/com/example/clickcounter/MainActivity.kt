package com.example.clickcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clickcounter.ui.theme.ClickCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column()
            {
                var counter = remember {
                    mutableStateOf(0)
                }

                Box(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .fillMaxHeight(0.5f)
                            .fillMaxWidth(0.9f)
                            .border(5.dp, color = Color.LightGray)
                    ) {
                        Row (
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "You clicked ${counter.value} times",
                                color = Color.White,
                                fontSize = 35.sp,
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                }

                Box(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    CounterBox(
                        Modifier
                            .fillMaxSize(0.5f)
                    ) { newCount ->
                        counter.value = newCount

                    }
                }
            }
        }
    }
}

@Composable
fun CounterBox(
    modifier: Modifier = Modifier,
    updateCounter: (Int) -> Unit
){
    var localCounter by remember { mutableStateOf(0) }

    Box(modifier = Modifier
        .fillMaxWidth(0.65f)
        .fillMaxHeight(0.5f)
        .background(color = Color.Red)
        .border(5.dp, Color.LightGray)
        .clickable(onClick = {
            localCounter+=1
            updateCounter(localCounter)
        }
        )
    ){
        Row(modifier = Modifier
            .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Click here to +1",
                color = Color.White,
                fontSize = 35.sp
            )
        }
    }
}