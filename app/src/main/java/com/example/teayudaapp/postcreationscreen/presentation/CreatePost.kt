package com.example.teayudaapp.postcreationscreen.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.teayudaapp.postcreationscreen.presentation.components.CreatePostTopBar
import com.example.teayudaapp.postcreationscreen.presentation.components.PostField
import com.example.teayudaapp.sharedcomponents.LoadingDialog


@Composable
fun CreatePost(
    close: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CreatePostViewModel = hiltViewModel()
) {
    val tittleText = remember {
        mutableStateOf("")
    }
    val descriptionText = remember {
       mutableStateOf("")
    }
    val hashtagText = remember {
        mutableStateOf("")
    }
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current

    if (viewModel.state.error){
        Toast.makeText(context, "Ocurrio un error", Toast.LENGTH_SHORT).show()
    }
    if (viewModel.state.realized){
        viewModel.changeRealized()
        Toast.makeText(context, "Post agregado con exito", Toast.LENGTH_SHORT).show()
        close()
    }
    if (viewModel.state.isLoading){
        LoadingDialog()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        backgroundColor = MaterialTheme.colors.primary,
        topBar = { CreatePostTopBar( close ) }

    ) { paddingValues ->

        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues
                        .calculateTopPadding()
                        .plus(52.dp), start = 15.dp, end = 15.dp
                ),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            //Title box
            item {
                PostField(
                    mutableText = tittleText,
                    title = "Titulo",
                    placeholderString = "Ej: Aeropuerto cerrado",
                    height = 49.dp,
                    1,
                    true,
                )
            }
            item {
                //Description box
                PostField(
                    mutableText = descriptionText,
                    title = "Descipcion",
                    placeholderString = "Puede escribir hasta 255 caracteres",
                    height = 173.dp,
                    255,
                    false,
                )
            }
            item {
                //Hashtag box
                PostField(
                    mutableText = hashtagText,
                    title = "Hashtag",
                    placeholderString = "#Aeropuertocerrado",
                    height = 49.dp,
                    1,
                    true,
                )
            }
            item {
                //Button Box
                Spacer(modifier = Modifier.height(20.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomEnd) {
                    Button(
                        onClick = {
                            viewModel.addPost(tittleText.value, descriptionText.value, hashtagText.value)
                                  },
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier.width(124.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)

                    ) {
                        Text(
                            text = "Postear",
                            style = MaterialTheme.typography.h3,
                            color = MaterialTheme.colors.primary)
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun CreatePostPreview() {
    CreatePost({ } )
}