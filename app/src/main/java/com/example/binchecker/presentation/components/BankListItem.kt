package com.example.binchecker.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.presentation.ui.theme.*


@Composable
fun BankListItem(
    bank: Bank?,
    onBankLinkClicked: (String?) -> Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.bankItemBackgroundColor,
        shape = RectangleShape,
        elevation = TASK_ITEM_ELEVATION,

        ) {
        Column(
            modifier = Modifier.padding(SMALL_PADDING)
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
                modifier = Modifier.fillMaxWidth(),
                text = bank?.phone ?: "No information",
                color = MaterialTheme.colors.taskItemTextColor,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
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
                textDecoration = TextDecoration.Underline
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
            bankName = "Some name",
            phone = "234543",
            url = "www.jyskebank.dk"
        )
    ) {}
}
