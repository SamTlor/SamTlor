package cmsc256;

import bridges.data_src_dependent.Song;


public class SongComparator implements java.util.Comparator<Song>{
    @Override
    public int compare(Song a, Song b){                                 
        int var = a.getAlbumTitle().compareTo(b.getAlbumTitle());       //returns a number

        if (var != 0){                                                  //if a and b dont have the same album
            return var;                                                 //return which one is bigger
        }
        return a.getSongTitle().compareTo(b.getSongTitle());            //if a and b are the same album return which song is bigger
    }
}