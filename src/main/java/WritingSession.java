import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class WritingSession {

    private HashMap<LocalDateTime, Version> history = new HashMap<>();
    public ArrayList<LocalDateTime> saves = new ArrayList<>();
    public String content;
    private String title;

    public WritingSession (String title, String content){

        this.title = title;
        this.content = content;

        save();

    }

    public void save(){

        LocalDateTime saveTime = LocalDateTime.now();
        history.put(saveTime, new Version(this.content));
        saves.add(saveTime);

    }

    public Version getSave(LocalDateTime localDateTime){

            if (history.get(localDateTime) != null){

                return history.get(localDateTime);

            } else {

                return new Version("Save not found.");

            }


    }

}
