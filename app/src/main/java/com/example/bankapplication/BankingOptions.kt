package com.example.bankapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class CardItems(
    val imageResId: Int,
    val title: String,
    val description: String
)


@Composable
fun BankingOptions() {
    val brush = Brush.horizontalGradient(listOf(Color.White.copy(0.25f),Color.White.copy(0.0f)))
    //data of card
    val cardItemsList = listOf(
        CardItems(
            imageResId = R.drawable.ic_acc,
            title = "Account",
            description = "Your balance"
        ),
        CardItems(
            imageResId = R.drawable.ic_bills,
            title = "Pay bills",
            description = "School,shop,etc"
        ),
        CardItems(
            imageResId = R.drawable.ic_transfer,
            title = "Transfer",
            description = "Send money"
        ),
        CardItems(
            imageResId = R.drawable.ic_fav,
            title = "Favorites",
            description = "Users"
        ),
        CardItems(
            imageResId = R.drawable.ic_scan,
            title = "BAB Scan",
            description = "School,shop,etc"
        ),
        CardItems(
            imageResId = R.drawable.ic_service,
            title = "Service",
            description = "Your balance"
        )
    )
    // display items list card
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth().padding(16.dp)
            .background(brush = brush, shape = RoundedCornerShape(16.dp))
            .border(2.dp, color = Color.Magenta, shape = RoundedCornerShape(16.dp)),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(8.dp)

    ) {
        items(cardItemsList) { cardItem ->
            Card(cardItems = cardItem)
        }

    }
}
// card of item
@Composable
fun Card(cardItems: CardItems) {

    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF0F4F8)
        ),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .height(110.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,

            ) {
            Image(
                painter = painterResource(id = cardItems.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.End),
                contentScale = ContentScale.Crop,

                )

            Text(
                text = cardItems.title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp, fontWeight = FontWeight.Medium,
                    color = Color(0xFF1B1F23),
                    shadow = Shadow(
                        color = Color(0xFF606770).copy(alpha = 0.2f),
                        offset = Offset(2f, 2f),
                        blurRadius = 4f
                    )
                ),
                modifier = Modifier.padding(bottom = 8.dp, top = 4.dp)
            )

            Text(
                text = cardItems.description,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp,
                    color = Color(0xFF606770)
                ),
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}



@Preview
@Composable
fun Pre() {
   BankingOptions()

}
