package com.example.bankapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeIndicator() {

    var isVisible by remember { mutableStateOf(false) }
    val brush = Brush.horizontalGradient(listOf(Color(0xFFB0BEC5),Color(0xFF295F98)))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                brush = brush,
                shape = RoundedCornerShape(15.dp)
            )
            .shadow(
                spotColor = Color.White,
                ambientColor = Color.White,
                elevation = 0.dp
            )
            .border(
                width = 2.dp,
                color = Color.Magenta,
                shape = RoundedCornerShape(15.dp)
            )
    ) {
        // Row for money and eye icon
        Row(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isVisible){
                Text(
                    text = "12345678910",
                    modifier = Modifier
                        .padding(5.dp)
                        .height(20.dp),
                    color = Color.White
                )
            }
            else
                Text(
                    text = "                   ",
                    modifier = Modifier
                        .background(color = Color.LightGray, shape = RoundedCornerShape(4.dp))
                        .padding(5.dp)
                        .height(20.dp),
                    color = Color.White
                )

            Box(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .background(color = Color.LightGray, shape = RoundedCornerShape(8.dp))
                    .size(25.dp),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = if (isVisible)  Icons.Filled.Visibility else Icons.Filled.VisibilityOff  ,
                    contentDescription = "eyecheck",
                    tint = Color.Black,
                    modifier = Modifier.size(14.dp)
                        .clickable() {
                           isVisible=!isVisible
                        }

                )
            }
        }
        // row for saving and default
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 3.dp)
                .fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color(0xFF00B8D4), shape = RoundedCornerShape(4.dp))
                    .width(50.dp)
                    .height(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "default",
                    color = Color.White,
                    style = MaterialTheme.typography.labelSmall
                )
            }

            Box(
                modifier = Modifier
                    .padding(start = 5.dp)
//                    .background(color = Color.LightGray, shape = RoundedCornerShape(4.dp))
                    .width(50.dp)
                    .height(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "saving",
                    color = Color.White,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
// Row Receive and send money
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 0.dp)
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_receive),
                    contentDescription = "Receive money",
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Receive money", color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Row(
                modifier = Modifier
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_pay),
                    contentDescription = "Send money",
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Send money", color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview
@Composable
fun HomePre() {
    HomeIndicator()
}



