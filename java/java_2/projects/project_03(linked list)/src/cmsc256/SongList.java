/*
* SongComparator.java
* Sam Taylor
* Project 3
* CMSC 256
* Fall 2021
* The purpose of this program is to create a list of songs using the bridges API and group songs by the same artist. List the songs 
* that are in the same album together in alphabetical order and list the albums in alphabetical order as well.
*/


package cmsc256;

import bridges.base.SLelement;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.Song;

import java.util.*;

public class SongList implements cmsc256.List<Song> {
    public static void main(String[] args){
        Bridges bridges = new Bridges(0, "sam_tlor", "1134158751539");      //login to API
        DataSource ds = bridges.getDataSource();

        SongList songData = new SongList();                                 
        try{
            for(Song i : ds.getSongData()){
                songData.append(i);
            }
        }
        catch (Exception e){
            System.out.println("Unable to connect to bridges");
        }
        
        while(!songData.isAtEnd()){
            String var = songData.curr.getValue().getArtist();
            int position = songData.currPos();

            System.out.println(songData.getSongsByArtist(var));
            songData.moveToPos(position + 1);
        }
	}



    private SLelement<Song> head;      // Pointer to list header
    private SLelement<Song> tail;      // Pointer to last element
    private SLelement<Song> curr;      // Access to current element
    private int listSize;              // Size of list
  
    // Constructors
    public SongList(int size) { this(); }     // Constructor -- Ignore size
    public SongList() { clear(); }
  
    // Remove all elements
    public void clear() {
      	curr = tail = new SLelement<Song>();      // Create trailer
      	head = new SLelement<Song>(tail);         // Create header
        listSize = 0;
    }
    
    // Insert "it" at current position
    public boolean insert(Song it) {
		curr.setNext(new SLelement<Song>(curr.getValue(), curr.getNext()));
		curr.setValue(it);
		if (tail == curr) tail = curr.getNext();  // New tail
		listSize++;
		return true;
    }
    
    // Append "it" to list
    public boolean append(Song it) {
      tail.setNext(new SLelement<Song>());
      tail.setValue(it);
      tail = tail.getNext();
      listSize++;
      return true;
    }

    public Song remove () throws NoSuchElementException {   // Remove and return current element
        if (curr == tail)                                   // Nothing to remove
            return null;
        Song it = curr.getValue();                          // Remember value
        curr.setValue(curr.getNext().getValue());           // Pull forward the next element
        if (curr.getNext() == tail) tail = curr;            // Removed last, move tail
        curr.setNext(curr.getNext().getNext());             // Point around unneeded SLelement
        listSize--;                                         // Decrement element count
        return it;                                          // Return value
    }
  
    public void moveToStart() { curr = head.getNext(); }    // Set curr at list start
        public void moveToEnd() { curr = tail; }            // Set curr at list end
    
        public void prev() {                                            // Move curr one step left; no change if now at front
            if (head.getNext() == curr) return;                         // No previous element
            SLelement<Song> temp = head;
            while (temp.getNext() != curr) temp = temp.getNext();       // March down list until we find the previous element
        curr = temp;
    }
  
    // Move curr one step right; no change if now at end
    public void next() { if (curr != tail) curr = curr.getNext(); }
  
    public int length() { return listSize; }                    // Return list length
  
    public int currPos() {                                      // Return the position of the current element
        if (listSize == 0){
            return -1;
        }
        SLelement<Song> temp = head.getNext();
        int i;
        for (i=0; curr != temp; i++)
            temp = temp.getNext();
        return i;
    }
    
    public boolean moveToPos(int pos) {                         // Move down list to "pos" position
        if ((pos < 0) || (pos > listSize)) return false;
        curr = head.getNext();
        for(int i=0; i<pos; i++) curr = curr.getNext();
        return true;
    }
  
    public boolean isAtEnd() { return curr == tail; }           // Return true if current position is at end of the list
  
    // Return current element value. Note that null gets returned if curr is at the tail
    public Song getValue() throws NoSuchElementException {
        if (curr == tail)                                       //No current element
            return null;
        return curr.getValue(); 
   }
    
    public boolean isEmpty() {                                  //Tell if the list is empty or not
        return listSize == 0;
    }

	public String getSongsByArtist(String artist){

        moveToStart();                                          //to go through the entire list start the beginning
        ArrayList<Song> ordered = new ArrayList<>();            //to hold the songs that I want later

        while(!isAtEnd()){                                      //while it's not at the end of the list, go through the list
            Song current = curr.getValue();                     //gets the song object
            if (artist.equals(current.getArtist())){            //if the search artist is the same as the artist of the current song
                ordered.add(current);                           //add it to my arraylist of songs that I want now
            }
            next();                                             //increment
        }


        if (ordered.isEmpty()){
            return ("There are no songs by " + artist + " in this playlist");
        }
        else{
            String ending = "";
            ordered.sort(new SongComparator());    //sort them

            for(Song i : ordered){
                ending += "Title: " + i.getSongTitle() + " Artist: " + i.getArtist() + " Album: " + i.getAlbumTitle() + "\n";
            }

            return ending;
        }
	}
}