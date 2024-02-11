package cmsc256;

import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.ActorMovieIMDB;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class SortingLab {
    public static void main(String[] args){
        Bridges bridges = new Bridges(0, "sam_tlor", "1134158751539");      //login to API
        DataSource ds = bridges.getDataSource();                            
        List<ActorMovieIMDB> movieData = null;                              //gets list of all of IMDB

        try {
            movieData = ds.getActorMovieIMDBData(Integer.MAX_VALUE);
        } catch (Exception e) {
            System.out.println("Unable to connect to Bridges.");
        }

        System.out.println("actor and movie title for first 5 objects in list:\n");
        for (int i = 0; i < 5; i++){
            ActorMovieIMDB entry = movieData.get(i);
            System.out.println(i + ". " + entry.getActor() + "was in " + entry.getMovie());
        }

        System.out.println("\n\nunfiltered list\n");
        ArrayList <ActorMovieIMDB> filteredMovieList = new ArrayList<>();   //even tho rn its unfiltered
        for (ActorMovieIMDB i : movieData){
            if (i.getMovie().equals("Being_John_Malkovich_(1999)")){        //if the movie is JM
                System.out.println(i.getActor());                           //get the actors
                filteredMovieList.add(i);
            }
        }

        System.out.println("\n\nfiltered list: \n");
        ActorComparator obj = new ActorComparator();
        filteredMovieList.sort(obj);
        for (ActorMovieIMDB entry : filteredMovieList){
            System.out.println(entry.getActor());
        }
    }
}

class ActorComparator implements Comparator<ActorMovieIMDB>{
    public int compare(ActorMovieIMDB a, ActorMovieIMDB b){
        return a.getActor().compareTo(b.getActor());
    }
}