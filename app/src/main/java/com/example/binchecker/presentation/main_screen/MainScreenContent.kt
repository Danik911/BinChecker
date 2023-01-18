package com.example.binchecker.presentation.main_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.binchecker.R.drawable
import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.presentation.components.MessageBar
import com.example.binchecker.presentation.components.SearchButton
import com.example.binchecker.presentation.ui.theme.LoadingBlue
import com.example.binchecker.util.MessageBarState
import com.example.binchecker.util.RequestState

@Composable
fun MainScreenContent(
    apiResponse: RequestState<ApiResponse>,
    messageBarState: MessageBarState,
    binBank: String,
    onBinBankChanged: (String) -> Unit,
    profilePhoto: String?,
    onSearchClicked: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.weight(1f)) {
            if (apiResponse is RequestState.Loading) {
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth(),
                    color = LoadingBlue
                )
            } else {
                MessageBar(messageBarState = messageBarState)
            }
        }
        Column(
            modifier = Modifier
                .weight(9f)
                .fillMaxWidth(0.7f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CentralContent(
                binBank = binBank,
                onFirstNameChanged = onBinBankChanged,
                profilePhoto = profilePhoto,
                onSearchClicked = {onSearchClicked(binBank)}
            )
        }
    }
}

@Composable
private fun CentralContent(
    binBank: String,
    onFirstNameChanged: (String) -> Unit,
    profilePhoto: String?,
    onSearchClicked: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AsyncImage(
            modifier = Modifier.size(200.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(profilePhoto)
                .crossfade(1000)
                .placeholder(drawableResId = drawable.ic_placeholder)
                .transformations(CircleCropTransformation())
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = "Profile image"
        )

        OutlinedTextField(
            value = binBank,
            onValueChange = { onFirstNameChanged(it) },
            label = { Text(text = "First Name") },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )

        SearchButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            primaryText = "Sign Out",
            secondaryText = "Sign Out",
            onClick = {
                onSearchClicked(binBank)
            }
        )
    }
}

