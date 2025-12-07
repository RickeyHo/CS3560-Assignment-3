import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class JUnit {


    @Test
    void checkWritingSession(){

        String content = "The culture and history of China.";

        WritingSession writingSession = new WritingSession();
        writingSession.save(content);

        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(0)).getContent().equals(content));

    }

    @Test
    void checkWritingSessionSpecialCharsZH(){

        String content = "中国的文化历史。";

        WritingSession writingSession = new WritingSession();
        writingSession.save(content);

        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(0)).getContent().equals(content));

    }
    @Test
    void checkWritingSessionSpecialCharsVI(){

        String content = "Lịch sử và Văn hoá của Trung Quốc.";

        WritingSession writingSession = new WritingSession();
        writingSession.save(content);

        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(0)).getContent().equals(content));

    }

    @Test
    void checkWritingHistoryRU(){

        String content = "Сколько человек в нашей семье?";

        WritingSession writingSession = new WritingSession();
        writingSession.save(content);

        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(0)).getContent().equals(content));

    }

    @Test
    void checkWritingHistory(){

        String content1 = "The culture and history of China.";
        String content2 = "The culture and history of Paris.";
        String content3 = "The culture and history of France.";
        String content4 = "The culture and history of Italy.";

        WritingSession writingSession = new WritingSession();
        writingSession.save(content1);
        writingSession.save(content2);
        writingSession.save(content3);
        writingSession.save(content4);

        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(0)).getContent().equals(content1));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(0)).getContent());
        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(1)).getContent().equals(content2));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(1)).getContent());
        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(2)).getContent().equals(content3));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(2)).getContent());
        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(3)).getContent().equals(content4));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(3)).getContent());

    }

    @Test
    void checkWritingHistoryZH(){

        String content1 = "中国历史文化";
        String content2 = "法国历史文化";
        String content3 = "蒙古历史文化";
        String content4 = "越南历史文化";

        WritingSession writingSession = new WritingSession();
        writingSession.save(content1);
        writingSession.save(content2);
        writingSession.save(content3);
        writingSession.save(content4);

        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(0)).getContent().equals(content1));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(0)).getContent());
        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(1)).getContent().equals(content2));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(1)).getContent());
        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(2)).getContent().equals(content3));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(2)).getContent());
        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(3)).getContent().equals(content4));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(3)).getContent());

    }
    @Test
    void checkWritingHistoryVI(){

        String content1 = "Trung Quốc có văn hoá và lịch sử.";
        String content2 = "Mông cổ có văn hoá và lịch sử.";
        String content3 = "Hà Lan có văn hoá và lịch sử.";
        String content4 = "Việt Nam có văn hoá và lịch sử.";

        WritingSession writingSession = new WritingSession();
        writingSession.save(content1);
        writingSession.save(content2);
        writingSession.save(content3);
        writingSession.save(content4);

        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(0)).getContent().equals(content1));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(0)).getContent());
        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(1)).getContent().equals(content2));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(1)).getContent());
        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(2)).getContent().equals(content3));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(2)).getContent());
        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(3)).getContent().equals(content4));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(3)).getContent());

    }

    @Test
    void checkSpecialCharsRU(){

        String content1 = "Сколько человек в нашей семье?";
        String content2 = "Какой урок мой самый любимый школе?";
        String content3 = "Что любит Аня на завтрак?";
        String content4 = "Кто такая Аня?";

        WritingSession writingSession = new WritingSession();
        writingSession.save(content1);
        writingSession.save(content2);
        writingSession.save(content3);
        writingSession.save(content4);

        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(0)).getContent().equals(content1));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(0)).getContent());
        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(1)).getContent().equals(content2));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(1)).getContent());
        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(2)).getContent().equals(content3));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(2)).getContent());
        assertTrue(writingSession.getSave(writingSession.getTimestamps().get(3)).getContent().equals(content4));
        System.out.println(writingSession.getSave(writingSession.getTimestamps().get(3)).getContent());

    }

    @Test
    void testAPI(){

        OpenAI.INSTANCE.setPrompt("Just respond with the word 'test'");

        Response response = OpenAI.INSTANCE.respond();

        assertEquals(response.status(), Optional.of(ResponseStatus.COMPLETED));
        assertEquals(response.output().get(1).message().get().content().get(0).outputText().get().text(), "test");

    }

    @Test
    void checkErrorHandling() throws InterruptedException {

        WritingSession writingSession = new WritingSession();
        writingSession.save("test");

        Thread.sleep(50);

        try {

            writingSession.getSave(LocalDateTime.now());
            fail("Exception not thrown.");

        } catch (Exception e){

            assertEquals(e.getMessage(), "Save not found.");

        }
    }







}
