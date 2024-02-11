package cmsc256;

public class Dog implements Comparable<Dog>{
    String dogName;
    int count;

    //constructors
    public Dog(){
        dogName = "";
    }
    public Dog(String theDogName, int theCount){
        dogName = theDogName;
        count = theCount;
    }

    //getters
    public String getDogName() {
        return dogName;
    }
    public int getCount(){
        return count;
    }

    //setters
    public void setDogName(String theDogName){
        dogName = theDogName;
    }
    public void setCount(int theCount){
        count = theCount;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    public int compareTo(Dog theDog) {
        return this.getDogName().compareTo(theDog.getDogName());
    }

}