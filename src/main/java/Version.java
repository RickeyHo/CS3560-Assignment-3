import java.time.LocalDateTime;

public class Version {

    public LocalDateTime localDateTime;
    private String content;

    public Version (String content){

        this.content = content;
        this.localDateTime = LocalDateTime.now();

    }

    public String getContent(){

        return content;

    }


}
