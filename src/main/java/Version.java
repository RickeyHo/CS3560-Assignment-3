import java.time.LocalDateTime;

public class Version {

    private LocalDateTime localDateTime;
    private String content;

    public Version (String content){

        this.content = content;
        this.localDateTime = LocalDateTime.now();

    }

    public String getContent(){

        return content;

    }


    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
