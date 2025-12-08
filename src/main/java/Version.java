import java.time.LocalDateTime;

public class Version implements VersionFactory{

    private LocalDateTime localDateTime;
    private String content;

    Version(String content){

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

    @Override
    public Version createVersion(String content) {
        return new Version(content);
    }
}
