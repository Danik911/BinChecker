package com.example.binchecker.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.binchecker.R
import com.example.binchecker.presentation.ui.theme.EXTRA_LARGE_PADDING
import com.example.binchecker.presentation.ui.theme.LARGE_PADDING
import com.example.binchecker.presentation.ui.theme.LoadingBlue
import com.example.binchecker.presentation.ui.theme.SMALL_PADDING

@Composable
fun SearchButton(
    modifier: Modifier = Modifier,
    primaryText: String = "Search Bank",
    secondaryText: String = "Loading...",
    shape: Shape = MaterialTheme.shapes.medium,
    loadingState: Boolean = false,
    icon: Int = R.drawable.logo,
    onClick: () -> Unit,
    strokeColor: Color = Color.LightGray,
    backgroundColor: Color = MaterialTheme.colors.surface,
    indicatorColor: Color = LoadingBlue
) {
    val text = remember {
        mutableStateOf(primaryText)
    }
    LaunchedEffect(key1 = loadingState) {
        text.value = if (loadingState) secondaryText else primaryText
    }
    Surface(
        modifier = modifier
            .clickable(enabled = !loadingState) {
                onClick()
            },
        shape = shape,
        border = BorderStroke(1.dp, color = strokeColor),
        color = backgroundColor,

        ) {
        Row(
            modifier = Modifier
                .padding(SMALL_PADDING)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painterResource(id = icon),
                contentDescription = "Search bank icon",
                tint = Color.Unspecified,
            )
            Spacer(modifier = Modifier.width(SMALL_PADDING))
            Text(text = text.value)

            if (loadingState) {
                Spacer(modifier = Modifier.width(EXTRA_LARGE_PADDING))
                CircularProgressIndicator(
                    modifier = Modifier.size(LARGE_PADDING),
                    color = indicatorColor,
                    strokeWidth = 2.dp,
                )
            }

        }
    }
}

@Preview
@Composable
fun GoogleButtonPreview() {
    SearchButton(onClick = { })
}