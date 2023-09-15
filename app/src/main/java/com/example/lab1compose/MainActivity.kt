package com.example.lab1compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab1compose.ui.theme.Lab1ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val text = remember {
        mutableStateOf("Lab 1 if when")
    }
    val age = remember {
        mutableStateOf("")
    }
    Row() {
        Text(
            text.value, modifier
        )
        TextField(value = age.value, onValueChange = {
            age.value = it
            var number = -1
            if (age.value.filter { it.isDigit() } != "")
                number = age.value.filter { it.isDigit() }.toInt()

            text.value = when (number)
            {
                in 0..20 -> "Вы слишком молоды!"
                30 -> "Поздравляем с повышением!"
                40 -> "Поздравляем с повышением!"
                50 -> "Поздравляем с повышением!"
                60 -> "Поздравляем с повышением!"
                65 -> "Преподносим вам золотые часы!"
                in 66..100 -> "Вы слишком Стары"
                in 21..29 -> "Продолжайте накапливать опыт"
                in 31..39 -> "Продолжайте накапливать опыт"
                in 41..49 -> "Продолжайте накапливать опыт"
                in 51..59 -> "Продолжайте накапливать опыт"
                in 61..64 -> "Продолжайте накапливать опыт"
                else -> "Неверно Ведено"
            }
        })
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab1ComposeTheme {
        Greeting()
    }
}