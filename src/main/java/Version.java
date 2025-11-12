import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Version {

    public LocalDateTime localDateTime;
    public String content;

    public Version (String content){

        this.content = content;
        this.localDateTime = LocalDateTime.now();

    }
}
