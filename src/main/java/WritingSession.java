import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class WritingSession {

    private HashMap<LocalDateTime, Version> history = new HashMap<>();
    private ArrayList<LocalDateTime> saves = new ArrayList<>();
    private String content;


    public void save(String content){

        this.content = content;
        LocalDateTime saveTime = LocalDateTime.now();
        history.put(saveTime, new Version(this.content));
        saves.add(saveTime);

    }

    public ArrayList<LocalDateTime> getTimestamps(){

        return (ArrayList<LocalDateTime>) saves.clone();


    }


    public Version getSave(LocalDateTime localDateTime) throws RuntimeException{

            if (history.get(localDateTime) != null){

                return history.get(localDateTime);

            } else {

                throw new RuntimeException("Save not found.");

            }

    }

}
