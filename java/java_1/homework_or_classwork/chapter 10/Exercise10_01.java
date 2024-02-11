import java.util.Scanner;

public class Exercise10_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Time t1 = new Time();
        Time t2 = new Time(555550000);
        Time t3 = new Time(5,23,55);

        System.out.println(t1.hour + ":" + t1.minute + ":" + t1.second);
        System.out.println(t2.hour + ":" + t2.minute + ":" + t2.second);
        System.out.println(t3.hour + ":" + t3.minute + ":" + t3.second);
    }
}

class Time{
    long hour;
    long minute; 
    long second;
    
    public long getHour(){
        return hour;
    }
    public long getMinute(){
        return minute;
    }
    public long getSecond(){
        return second;
    }
    public void setTime(long elapseTime){
        long totalSeconds = elapseTime / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;
    }
    

    Time(){
        long totalMilliseconds = System.currentTimeMillis();

        long totalSeconds = totalMilliseconds / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;


        this.hour = currentHour;
        this.minute = currentMinute;
        this.second = currentSecond;
    }
    Time(long elapseTime){

        long totalSeconds = elapseTime/ 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;

        this.hour = currentHour;
        this.minute = currentMinute;
        this.second = currentSecond;
    }
    Time(long theHour, long theMinute, long theSecond){
        this.hour = theHour;
        this.minute = theMinute;
        this.second = theSecond;
    }
}