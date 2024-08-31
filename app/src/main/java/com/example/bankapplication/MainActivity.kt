package com.example.bankapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.bankapplication.ui.theme.BankApplicationTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankApplicationTheme {
//                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(color = MaterialTheme.colorScheme.error,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0xFF295F98))
                ) {
                    HomeScreen()
                }
            }

        }
    }
}

@Composable
private fun SetBarColor(color:Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = color
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color =Color(0xFF295F98)),
        topBar = {
            TopNavigationBar()
        }

    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF295F98))
                .padding(padding)
        ) {
            //biuld
//            TopNavigationBar()
            HomeIndicator()
            BankingOptions()
            PreNewInfo()
            EditHomes()


        }
    }

}