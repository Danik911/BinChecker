package com.example.binchecker.presentation.main_screen

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.binchecker.R.drawable.ic_vertical_menu
import com.example.binchecker.presentation.components.DisplayAlertDialog
import com.example.binchecker.presentation.ui.theme.topAppBarBackgroundColor
import com.example.binchecker.presentation.ui.theme.topAppBarContentColor


@Composable
fun MainScreenTopAppBar(
    onDeleteAllConfirmed: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = "Search a bank",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            ProfileTopBarActions(
                onDeleteAllConfirmed = onDeleteAllConfirmed
            )
        }
    )
}

@Composable
fun ProfileTopBarActions(
    onDeleteAllConfirmed: () -> Unit,
) {
    var openDialog by remember { mutableStateOf(false) }

    DisplayAlertDialog(
        openDialog = openDialog,
        onYesClicked = { onDeleteAllConfirmed() },
        onDialogClosed = { openDialog = false }
    )

    DeleteAllAction(onDelete = { openDialog = true})
}


@Composable
fun DeleteAllAction(onDelete: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = ic_vertical_menu),
            contentDescription = "Vertical Menu",
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onDelete()
                }
            ) {
                Text(
                    text = "Delete Account",
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}

@Composable
@Preview
fun LoginTopAppBarPreview() {
    MainScreenTopAppBar( onDeleteAllConfirmed = {})
}