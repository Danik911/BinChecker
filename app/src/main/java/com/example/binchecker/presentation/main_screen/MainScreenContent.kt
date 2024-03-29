package com.example.binchecker.presentation.main_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.presentation.components.BankListItem
import com.example.binchecker.presentation.components.MessageBar
import com.example.binchecker.presentation.components.SearchButton
import com.example.binchecker.presentation.ui.theme.LoadingBlue
import com.example.binchecker.presentation.ui.theme.MEDIUM_PADDING
import com.example.binchecker.presentation.ui.theme.SMALL_PADDING
import com.example.binchecker.util.MessageBarState
import com.example.binchecker.util.RequestState

@Composable
fun MainScreenContent(
    apiResponse: RequestState<ApiResponse>,
    messageBarState: MessageBarState,
    binBank: String,
    onBinBankChanged: (String) -> Unit,
    bank: Bank?,
    onSearchClicked: (String) -> Unit,
    onBankLinkClicked: (String?) -> Unit,
    onBankPhoneClicked: (String?) -> Unit,
    onBankLocationClicked: (String?) -> Unit
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
                bank = bank,
                onSearchClicked = { onSearchClicked(binBank) },
                loadingState = apiResponse,
                onBankLinkClicked = onBankLinkClicked,
                onBankPhoneClicked = onBankPhoneClicked,
                onBankLocationClicked = onBankLocationClicked
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun CentralContent(
    binBank: String,
    onFirstNameChanged: (String) -> Unit,
    bank: Bank?,
    onSearchClicked: (String) -> Unit,
    loadingState: RequestState<ApiResponse>,
    onBankLinkClicked: (String?) -> Unit,
    onBankPhoneClicked: (String?) -> Unit,
    onBankLocationClicked: (String?) -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier.padding(SMALL_PADDING)
    ) {

        BankListItem(
            bank = bank,
            onBankLinkClicked = onBankLinkClicked,
            onBankPhoneClicked = onBankPhoneClicked,
            onBankLocationClicked = onBankLocationClicked
        )

        OutlinedTextField(
            value = binBank,
            onValueChange = { onFirstNameChanged(it) },
            label = { Text(text = "Insert BIN") },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true,
            modifier = Modifier.padding(top = MEDIUM_PADDING),
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
            ),
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
        )

        SearchButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            primaryText = "Search bank",
            secondaryText = "Searching...",
            onClick = {
                onSearchClicked(binBank)
            },
            loadingState = loadingState

        )
    }
}

