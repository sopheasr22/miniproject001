package com.example.bankapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.bankapplication.ui.theme.BankApplicationTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankApplicationTheme {
                val backgroundColor = Color(0xFF295F98)
                SetBarColor(color = backgroundColor)
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = backgroundColor),
                            color = backgroundColor
                ) {
                    HomeScreen()
                }
            }

        }
    }
}

@Composable
private fun SetBarColor(color:Color) {
    val systemUiController =  rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = color
        )
    }
}


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

            Balance()
            BankingOptions()
            PreNewInfo()
            EditHomes()


        }
    }

}