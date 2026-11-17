package com.example.comptadorjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.comptadorjc.ui.theme.ComptadorJCTheme

class CounterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterScreen()
        }
    }
}
@Preview
@Composable
fun CounterScreen(){
    ComptadorJCTheme(darkTheme = false) { // Esto envuelve el tema entero hace de "Context"
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            CounterCard(modifier = Modifier.fillMaxSize()
                .padding(innerPadding))
        }
    }
}

@Composable
fun Clicker(onIncrement: (Int) -> Unit, value: Int) {
    Button(onClick = { onIncrement(value) }) {
        Text(" + $value ")
    }
}

@Composable
fun NumberView(counter: Int) {
    Text(text = "$counter")
}

@Preview(showBackground = true)
@Composable
fun CounterCard(modifier: Modifier = Modifier) {
    var counter by remember { mutableIntStateOf(0) }
    val increment: (Int) -> Unit = { value -> counter += value }

    Column(modifier = modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        NumberView(counter = counter)
        Row {
            Clicker(onIncrement = increment, value = 1)
            Clicker(onIncrement = increment, value = 10)
            Clicker(onIncrement = increment, value = 100)
        }
    }
}



