package com.example.teayudaapp.ui.composable.registerscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.R

@Composable
fun RadioButtonAgree(
    padding: Dp,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
    ) {
        RadioButton(
            selected = false,
            onClick = { /*TODO: Set on click */},
            modifier = Modifier
                .size(14.dp),
            colors = RadioButtonDefaults.colors(
                unselectedColor = MaterialTheme.colors.onSecondary,
                selectedColor = MaterialTheme.colors.onSecondary)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = stringResource(id = R.string.app_terms),
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Right
        )
    }
}