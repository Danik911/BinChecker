package com.example.binchecker.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.binchecker.R
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.presentation.ui.theme.*


@Composable
fun BankListItem(
    bank: Bank?,
    onBankLinkClicked: (String?) -> Unit,
    onBankPhoneClicked: (String?) -> Unit,
    onBankLocationClicked: (String?) -> Unit,
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.bankItemBackgroundColor,
        shape = RectangleShape,
        elevation = TASK_ITEM_ELEVATION,

        ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .padding(SMALL_PADDING)
                    .weight(8f)
            ) {
                Row {
                    Text(
                        modifier = Modifier.weight(8f),
                        text = bank?.bankName ?: "No information",
                        color = MaterialTheme.colors.taskItemTextColor,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )

                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(enabled = bank?.phone != null && bank.phone.length > 1) {
                            onBankPhoneClicked(bank?.phone)
                        },
                    text = bank?.phone ?: "No information",
                    color = MaterialTheme.colors.taskItemTextColor,
                    style = MaterialTheme.typography.subtitle1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textDecoration = TextDecoration.Underline
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(enabled = bank?.url != null && bank.url.length > 1) {
                            onBankLinkClicked(bank?.url)
                        },
                    text = bank?.url ?: "No information",
                    color = LoadingBlue,
                    style = MaterialTheme.typography.subtitle1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontStyle = FontStyle.Italic

                )
            }
            Icon(
                painterResource(id = R.drawable.ic_map),
                contentDescription = "map icon",
                tint = Color.Unspecified,
                modifier = Modifier
                    .weight(2f)
                    .padding(end = SMALL_PADDING)
                    .clickable(enabled = bank?.bankName != null) {
                    onBankLocationClicked(bank?.url)
                }
            )

        }
    }
}

@Composable
@Preview
fun BankListItemPreview() {
    BankListItem(
        bank = Bank(
            id = 1,
            city = "Moscow",
            bankName = "Tinkoff",
            phone = "+3939929",
            url = "www.someaddress.com",
        ),
        onBankPhoneClicked = {},
        onBankLinkClicked = {},
        onBankLocationClicked = {}
    )
}
