package com.example.bankapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EditHomes() {
    var isSheetOpen by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Themes") }

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
        BottomSheetComponent(
            isSheetOpen = isSheetOpen,
            onDismiss = { isSheetOpen = false },
            selectedOption = selectedOption,
            onOptionClick = { option -> selectedOption = option }
        )
    }
}

//BottomSheetComponent
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetComponent(
    isSheetOpen: Boolean,
    onDismiss: () -> Unit,
    selectedOption: String,
    onOptionClick: (String) -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    if (isSheetOpen) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { onDismiss() }
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color(0xFFF8F8F8))
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Text(text = "Appearance", style = MaterialTheme.typography.titleLarge)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    FilledTonalButton(
                        shape = RoundedCornerShape(8.dp),
                        colors = if (selectedOption == "Themes") {
                            ButtonDefaults.buttonColors(Color(0xFFCBE5FF))
                        } else {
                            ButtonDefaults.buttonColors(Color(0xFFE4E4E4))
                        },
                        onClick = { onOptionClick("Themes") }
                    ) {
                        Text(
                            "Themes",
                            color = Color.Black,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }

                    FilledTonalButton(
                        shape = RoundedCornerShape(8.dp),
                        colors = if (selectedOption == "Dark Mode") {
                            ButtonDefaults.buttonColors(Color(0xFFCBE5FF))
                        } else {
                            ButtonDefaults.buttonColors(Color(0xFFE4E4E4))
                        },
                        onClick = { onOptionClick("Dark Mode") }
                    ) {
                        Text(
                            "Dark Mode",
                            color = Color.Black,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    FilledTonalButton(
                        colors = if (selectedOption == "Language") {
                            ButtonDefaults.buttonColors(Color(0xFFCBE5FF))
                        } else {
                            ButtonDefaults.buttonColors(Color(0xFFE4E4E4))
                        },
                        shape = RoundedCornerShape(8.dp),
                        onClick = { onOptionClick("Language") }
                    ) {
                        Text(
                            "Language",
                            color = Color.Black,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                Spacer(modifier = Modifier.padding(14.dp))

                //  selected option
                when (selectedOption) {
                    "Themes" -> ThemesContent()
                    "Dark Mode" -> DarkModeContent()
                    "Language" -> LanguageContent()
                }

                Spacer(modifier = Modifier.padding(14.dp))

                Button(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF295F98))
                ) {
                    Text(text = "Save")
                }
            }
        }
    }
}


//ThemesContent
@Composable
fun ThemesContent() {
    // Display content for Themes
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),

        ) {
        items(4) {
            Box(
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .padding(10.dp, vertical = 12.dp)
            ) {
                Image(

                    painter = painterResource(id = R.drawable.img),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .align(Alignment.Center)
                        .border(4.dp, color = Color.Cyan, shape = RoundedCornerShape(10.dp))
                )
            }
        }
    }

}


@Composable
fun DarkModeContent() {
    val modes = listOf(
        R.drawable.dark,
        R.drawable.light,
        R.drawable.mode
    )

    // Display content for Dark Mode
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(modes) { mode ->
            Row(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Image(
                    painter = painterResource(id = mode),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)

                )
            }
        }
    }
}

    //LanguageContent
    @Composable
    fun LanguageContent() {
        //  data for countries
        val countries = listOf(
            Pair("Khmer", R.drawable.cambodia),
            Pair("Thai", R.drawable.download),
            Pair("Loas", R.drawable.downloadl),
            Pair("Vietnam", R.drawable.downloadv)
        )

        // Display content for Language
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(countries.size) { index ->
                val country = countries[index]
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = country.first,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Image(
                            painter = painterResource(id = country.second),
                            contentDescription = "${country.first} flag",
                            modifier = Modifier
                                .size(24.dp)
                                .clip(RoundedCornerShape(4.dp))
                        )
                    }
                }
            }
        }



@Preview
@Composable
fun PreEdit() {
    EditHomes()
}
