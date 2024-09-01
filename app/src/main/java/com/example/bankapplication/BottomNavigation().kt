package com.example.bankapplication

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter

@Preview
@Composable
fun TopNavigationBar() {
    var showDialog by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,

        ) {
        Row(

        ) {
            Image(
                painter = painterResource(R.drawable.uwp2842396),
                contentDescription = "Circle Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .border(3.dp, color = Color.White, CircleShape)
            )
            Column(
                modifier = Modifier.padding(start = 16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Hello, Channa!",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                )
                Text(
                    text = "View Profile",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notification",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 16.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_bk),
                contentDescription = "QR",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 16.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() })
                    { showDialog = true }
            )
            FullWidthDialog(
                showDialog = showDialog,
                onDismiss = { showDialog = false },

                )
        }
    }
}

@Composable
fun FullWidthDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Box(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(500.dp),
                    contentAlignment = Alignment.Center

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.qrbg),
                        contentDescription = "QR frame",
                        modifier = Modifier.fillMaxSize()
                    )
                   Column(modifier = Modifier.padding(top = 100.dp)) {
                       GenerateQrCode()
                   }

                }
                Box(
                    modifier = Modifier
                        .padding(24.dp)
                        .background(color = Color.LightGray, shape = RoundedCornerShape(16.dp))
                        .align(Alignment.TopEnd)

                ){
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close",
                        tint = Color(0xFF295F98),
                        modifier = Modifier
                            .size(25.dp)
                            .align(Alignment.TopEnd)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }) {
                                onDismiss()
                            }
                    )
                }


            }

        }


    }
}


@Composable
fun GenerateQrCode(text: String = "hello987733"){
    val matrix = QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, 512, 512)
    val width = matrix.width
    val height = matrix.height
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)

    for (y in 0 until height) {
        for (x in 0 until width) {
            bitmap.setPixel(
                x, y,
                if (matrix.get(x, y)) android.graphics.Color.BLACK else android.graphics.Color.WHITE
            )
        }
    }

    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = "Generated QR Code",
        modifier = Modifier.size(200.dp)
    )


}


@Preview
@Composable
fun PreBottomNavigationBar() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF295F98))
    ) {
        TopNavigationBar()
    }
}




