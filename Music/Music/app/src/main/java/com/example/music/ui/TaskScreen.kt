package com.example.music

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TaskScreen(navController: NavController, music: Music?) {
    var title by remember { mutableStateOf(music?.title ?: "") }
    var artist by remember { mutableStateOf(music?.artist ?: "") }
    var genre by remember { mutableStateOf(music?.genre ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = title, onValueChange = { title = it }, label = { Text("Título") })
        TextField(value = artist, onValueChange = { artist = it }, label = { Text("Artista") })
        TextField(value = genre, onValueChange = { genre = it }, label = { Text("Gênero") })
        Button(onClick = {
            // Adicione ou edite a música via API REST
        }) {
            Text("Salvar")
        }
        Button(onClick = {
            // Exclua a música via API REST
        }) {
            Text("Excluir")
        }
    }
}
