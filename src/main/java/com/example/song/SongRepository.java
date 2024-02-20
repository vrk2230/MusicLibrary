package com.example.song;

import java.util.ArrayList;

public interface SongRepository {

    public ArrayList<Song> getAllSongs();
    public Song addSong(Song song);
    public Song getSongById(int songId);
    public Song updateSongById(int songId,Song song);
    public void deleteSongById(int songId);


}
