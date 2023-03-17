package com.example.teayudaapp.homescreen.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.R

@Composable
fun HomeViewList(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(34.dp)
            .background(MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Text(text = stringResource(id = R.string.news_string), style = MaterialTheme.typography.body2, fontWeight = FontWeight.Bold)
        Text(text = stringResource(id = R.string.top_string), style = MaterialTheme.typography.body2, fontWeight = FontWeight.Bold)
        Text(text = stringResource(id = R.string.trends_string), style = MaterialTheme.typography.body2, fontWeight = FontWeight.Bold)
    }
}

@Composable
@Preview(showBackground = true)
fun HomeViewListPreview(){
    HomeViewList()
}