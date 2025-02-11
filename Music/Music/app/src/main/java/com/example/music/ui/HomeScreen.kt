package com.example.music

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


@Composable
fun HomeScreen(navController: NavController, emptyList: List<Any>) {
    // Criando uma lista de músicas fictícias
    val musicList = remember {
        listOf(
            Music("Música 1", "Artista 1", "Genre 1", "album1", "1"),
            Music("Música 2", "Artista 2", "Genre 2" , "album2", "2"),
            Music("Música 3", "Artista 3", "Genre 3", "album3", "3")
        )
    }

    // Verificando se a lista está vazia
    if (musicList.isEmpty()) {
        Text(
            text = "A lista está vazia",
            modifier = Modifier.fillMaxSize().padding(16.dp),
            style = MaterialTheme.typography.h6
        )
    } else {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(musicList) { music ->
                MusicItem(music)
            }
        }
    }
}

@Composable
fun MusicItem(music: Music) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = music.title, style = MaterialTheme.typography.h6)
        Text(text = "Artista: ${music.artist}", style = MaterialTheme.typography.body2)
        Text(text = "Gênero: ${music.genre}", style = MaterialTheme.typography.body2)
    }
}

