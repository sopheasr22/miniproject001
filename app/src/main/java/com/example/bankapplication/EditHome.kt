package com.example.bankapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EditHomes() {
    var isSheetOpen by remember { mutableStateOf(false) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        Button(
            onClick = { isSheetOpen = true },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFFFFF),
                contentColor = Color.Black
            )

        ) {
            Text(text = "Edit Home", color = Color.Black)
        }
        BottomSheetComponent(isSheetOpen, onDismiss = { isSheetOpen = false })

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetComponent(isSheetOpen: Boolean, onDismiss: () -> Unit) {
    val sheetState = rememberModalBottomSheetState()
    if (isSheetOpen) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { onDismiss() }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Text(text = "Appearance", style = MaterialTheme.typography.headlineSmall  )
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(top = 16.dp)) {
                    FilledTonalButton(
                        shape = RoundedCornerShape(8.dp),
                        onClick = {}) {
                        Text("Themes",style = MaterialTheme.typography.bodyLarge)
                    }
                    FilledTonalButton(
                        shape = RoundedCornerShape(8.dp),
                        enabled = false,
                        onClick = {}) {
                        Text("Dark Mode",style = MaterialTheme.typography.bodyLarge)
                    }
                    FilledTonalButton(
                        shape = RoundedCornerShape(8.dp),
                        enabled = false,
                        onClick = {}) {
                        Text("Language",style = MaterialTheme.typography.bodyLarge)
                    }
                }
                Spacer(modifier = Modifier.padding(14.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier.fillMaxWidth(),

                    ) {
                    items(4) {
                        Image(
                            painter = painterResource(id = R.drawable.img),
                            contentDescription = null,
                            modifier = Modifier
                                .size(150.dp)
                               
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(14.dp))
                Button(
                    onClick = { },
                    modifier = Modifier.align(Alignment.End).padding(end = 16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF295F98) ),
                ) {
                    Text(text = "Save", )

                }

            }
        }
    }
}

@Preview
@Composable
fun PreEdit() {
    EditHomes()
}