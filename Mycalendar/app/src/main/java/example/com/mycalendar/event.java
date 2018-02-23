package example.com.mycalendar;

/**
 * Created by hasee on 2017/9/19.
 */

public class Event {
    private String eventtime;
    private String eventname;
    public Event(String eventname,String eventtime){
        this.eventname=eventname;
        this.eventtime=eventtime;
    }
    public String getName(){
        return eventname;
    }
    public String getTime(){
        return  eventtime;
    }
}
