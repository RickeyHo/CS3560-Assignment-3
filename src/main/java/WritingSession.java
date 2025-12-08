import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class WritingSession {

    private static HashMap<LocalDateTime, Version> history = new HashMap<>();
    private static ArrayList<LocalDateTime> saves = new ArrayList<>();

    public static void save(String content){

        LocalDateTime saveTime = LocalDateTime.now();
        history.put(saveTime, ToggledFactory.createVersion(content));
        saves.add(saveTime);

    }

    public static ArrayList<LocalDateTime> getTimestamps(){

        return (ArrayList<LocalDateTime>) saves.clone();


    }


    public static Version getSave(LocalDateTime localDateTime) throws RuntimeException{

            if (history.get(localDateTime) != null){

                return history.get(localDateTime);

            } else {

                throw new RuntimeException("Save not found.");

            }

    }

    public static Version getSave(int index) throws RuntimeException{

        LocalDateTime localDateTime = saves.get(index);

        if (history.get(localDateTime) != null){

            return history.get(localDateTime);

        } else {

            throw new RuntimeException("Save not found.");

        }

    }

    public static LocalDateTime mostRecentChangeTime(){

        return saves.getLast();

    }

}
