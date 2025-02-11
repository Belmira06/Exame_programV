const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const app = express();

// Middleware...  
app.use(bodyParser.json());
app.use(cors());

// warehouse de músicas...
let musicLibrary = [];

// Rota para adicionar uma música...
app.post('/music', (req, res) => {
    const { genre, artist, title } = req.body;

    // Validação simples...
    
    if (!genre || !artist || !title) {
        return res.status(400).json({ message: 'Por favor, forneça gênero, artista e título da música.' });
    }

    const newMusic = {
        id: musicLibrary.length + 1,
        genre,
        artist,
        title,
    };

    musicLibrary.push(newMusic);
    res.status(201).json({ message: 'music added successfully!', music: newMusic });
});

// mostrar todas musicas
app.get('/music', (req, res) => {
    res.json(musicLibrary);
});

// pesquuosar por genros...
app.get('/music/genre/:genre', (req, res) => {
    const { genre } = req.params;
    const filteredMusic = musicLibrary.filter(music => music.genre.toLowerCase() === genre.toLowerCase());

    if (filteredMusic.length === 0) {
        return res.status(404).json({ message: `no music found "${genre}".` });
    }

    res.json(filteredMusic);
});

// pesquisa de musica por artistas...
app.get('/music/artist/:artist', (req, res) => {
    const { artist } = req.params;
    const filteredMusic = musicLibrary.filter(music => music.artist.toLowerCase() === artist.toLowerCase());

    if (filteredMusic.length === 0) {
        return res.status(404).json({ message: `No song found by "${artist}".` });
    }

    res.json(filteredMusic);
});

// a ligar ao servidor...
const PORT = 5000;
app.listen(PORT, () => console.log(`Servidor rodando na porta http://localhost:${PORT}`));
