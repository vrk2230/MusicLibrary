package com.example.song;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }




    @Override
    public ArrayList<Song> getAllSongs() {
        return new ArrayList<>(playlist.values());
    }

    @Override
    public Song addSong(Song song) {
        int newId = playlist.size() + 1;
        song.setSongId(newId);
        playlist.put(newId,song);
        return playlist.get(newId);

    }

    @Override
    public Song getSongById(int songId) {
        if (!playlist.containsKey(songId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return playlist.get(songId);
    }

    @Override
    public Song updateSongById(int songId, Song updatedSong) {
        if (!playlist.containsKey(songId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        updatedSong.setSongId(songId);
        playlist.put(songId,updatedSong);
        return updatedSong;
    }

    @Override
    public void deleteSongById(int songId) {
        Song song = playlist.get(songId);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}