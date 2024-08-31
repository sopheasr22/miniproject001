package com.example.bankapplication

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyApp(modifier: Modifier = Modifier) {

    val images = listOf(
        R.drawable.abacon,
        R.drawable.aba_chat_slider_en_v,
        R.drawable.aba_facepass_slider_en,
        R.drawable.abasd,
        R.drawable.abasd
    )
    val pagerState = rememberPagerState(
        pageCount = images.size
    )
    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.scrollToPage(nextPage)
        }
    }
//    val scope = rememberCoroutineScope()

    Column(
        modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "News and Information", color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp, modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp)
        )
        Box(modifier = modifier.wrapContentSize()) {
            HorizontalPager(
                state = pagerState,
                modifier
                    .wrapContentSize()

            ) { currentPage ->

                Card(
                    modifier
                        .wrapContentSize()
                        .padding(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = images[currentPage]),
                        contentDescription = "ad",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        contentScale = ContentScale.Crop
                    )

                }
                PageIndicator(
                    pageCount = images.size,
                    currentPage = pagerState.currentPage,
                    modifier =Modifier.padding(top=60.dp)



                )
            }
//            IconButton(
//                onClick = {
//                    val nextPage = pagerState.currentPage + 1
//                    if (nextPage < images.size) {
//                        scope.launch {
//                            pagerState.scrollToPage(nextPage)
//                        }
//                    }
//                },
//                modifier
//                    .padding(30.dp)
//                    .size(48.dp)
//                    .align(Alignment.CenterEnd)
//                    .clip(CircleShape),
//                colors = IconButtonDefaults.iconButtonColors(
//                    containerColor = Color(0x52373737)
//                )
//            ) {
////                Icon(
////                    imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "",
////                    modifier.fillMaxSize(),
////                    tint = Color.LightGray
////                )
//            }
//            IconButton(
//                onClick = {
//                    val prevPage = pagerState.currentPage -1
//                    if (prevPage >= 0) {
//                        scope.launch {
//                            pagerState.scrollToPage(prevPage)
//                        }
//                    }
//                },
//                modifier
//                    .padding(30.dp)
//                    .size(48.dp)
//                    .align(Alignment.CenterStart)
//                    .clip(CircleShape),
//                colors = IconButtonDefaults.iconButtonColors(
//                    containerColor = Color(0x52373737)
//                )
//            ) {
////                Icon(
////                    imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "",
////                    modifier.fillMaxSize(),
////                    tint = Color.LightGray
////                )
//            }
        }



    }
}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(pageCount) {
            IndicatorDots(isSelected = it == currentPage, modifier = modifier)
        }
    }
}

@Composable
fun IndicatorDots(isSelected: Boolean, modifier: Modifier) {
    val size = animateDpAsState(targetValue = if (isSelected) 12.dp else 10.dp, label = "")
    Box(
        modifier = modifier
            .padding(2.dp)
            .size(size.value)
            .clip(CircleShape)
            .background(if (isSelected) Color(0xff373737) else Color(0xA8373737))
    )
}

@Preview
@Composable
fun PreNewInfo() {
    MyApp()
}