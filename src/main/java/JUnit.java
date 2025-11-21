import com.openai.models.responses.ResponseStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class JUnit {


    @Test
    void checkWritingSession(){

        String content = "The culture and history of China.";

        WritingSession writingSession = new WritingSession("China", content);
        writingSession.save();

        assertTrue(writingSession.getSave(writingSession.saves.get(0)).content.equals(content));

    }

    @Test
    void checkWritingSessionSpecialCharsZH(){

        String content = "中国的文化历史。";

        WritingSession writingSession = new WritingSession("China", content);
        writingSession.save();
        assertTrue(writingSession.getSave(writingSession.saves.get(0)).content.equals(content));

    }
    @Test
    void checkWritingSessionSpecialCharsVI(){

        String content = "Lịch sử và Văn hoá của Trung Quốc.";

        WritingSession writingSession = new WritingSession("China", content);
        writingSession.save();
        assertTrue(writingSession.getSave(writingSession.saves.get(0)).content.equals(content));

    }

    @Test
    void checkWritingHistoryRU(){

        String content = "Сколько человек в нашей семье?";

        WritingSession writingSession = new WritingSession("China", content);

        assertTrue(writingSession.getSave(writingSession.saves.get(0)).content.equals(content));

    }

    @Test
    void checkWritingHistory(){

        String content1 = "The culture and history of China.";
        String content2 = "The culture and history of Paris.";
        String content3 = "The culture and history of France.";
        String content4 = "The culture and history of Italy.";

        WritingSession writingSession = new WritingSession("China", content1);
        writingSession.content = content2;
        writingSession.save();
        writingSession.content = content3;
        writingSession.save();
        writingSession.content = content4;
        writingSession.save();

        assertTrue(writingSession.getSave(writingSession.saves.get(0)).content.equals(content1));
        System.out.println(writingSession.getSave(writingSession.saves.get(0)).content);
        assertTrue(writingSession.getSave(writingSession.saves.get(1)).content.equals(content2));
        System.out.println(writingSession.getSave(writingSession.saves.get(1)).content);
        assertTrue(writingSession.getSave(writingSession.saves.get(2)).content.equals(content3));
        System.out.println(writingSession.getSave(writingSession.saves.get(2)).content);
        assertTrue(writingSession.getSave(writingSession.saves.get(3)).content.equals(content4));
        System.out.println(writingSession.getSave(writingSession.saves.get(3)).content);

    }

    @Test
    void checkWritingHistoryZH(){

        String content1 = "中国历史文化";
        String content2 = "法国历史文化";
        String content3 = "蒙古历史文化";
        String content4 = "越南历史文化";

        WritingSession writingSession = new WritingSession("China", content1);
        writingSession.content = content2;
        writingSession.save();
        writingSession.content = content3;
        writingSession.save();
        writingSession.content = content4;
        writingSession.save();

        assertTrue(writingSession.getSave(writingSession.saves.get(0)).content.equals(content1));
        System.out.println(writingSession.getSave(writingSession.saves.get(0)).content);
        assertTrue(writingSession.getSave(writingSession.saves.get(1)).content.equals(content2));
        System.out.println(writingSession.getSave(writingSession.saves.get(1)).content);
        assertTrue(writingSession.getSave(writingSession.saves.get(2)).content.equals(content3));
        System.out.println(writingSession.getSave(writingSession.saves.get(2)).content);
        assertTrue(writingSession.getSave(writingSession.saves.get(3)).content.equals(content4));
        System.out.println(writingSession.getSave(writingSession.saves.get(3)).content);

    }
    @Test
    void checkWritingHistoryVI(){

        String content1 = "Trung Quốc có văn hoá và lịch sử.";
        String content2 = "Mông cổ có văn hoá và lịch sử.";
        String content3 = "Hà Lan có văn hoá và lịch sử.";
        String content4 = "Việt Nam có văn hoá và lịch sử.";

        WritingSession writingSession = new WritingSession("China", content1);
        writingSession.content = content2;
        writingSession.save();
        writingSession.content = content3;
        writingSession.save();
        writingSession.content = content4;
        writingSession.save();

        //assertTrue(writingSession.getSave(writingSession.saves.get(0)).content.equals(content1));
        System.out.println(writingSession.getSave(writingSession.saves.get(0)).content);
        assertTrue(writingSession.getSave(writingSession.saves.get(1)).content.equals(content2));
        System.out.println(writingSession.getSave(writingSession.saves.get(1)).content);
        assertTrue(writingSession.getSave(writingSession.saves.get(2)).content.equals(content3));
        System.out.println(writingSession.getSave(writingSession.saves.get(2)).content);
        assertTrue(writingSession.getSave(writingSession.saves.get(3)).content.equals(content4));
        System.out.println(writingSession.getSave(writingSession.saves.get(3)).content);

    }

    @Test
    void checkSpecialCharsRU(){

        String content1 = "Сколько человек в нашей семье?";
        String content2 = "Какой урок мой самый любимый школе?";
        String content3 = "Что любит Аня на завтрак?";
        String content4 = "Кто такая Аня?";

        WritingSession writingSession = new WritingSession("China", content1);
        writingSession.content = content2;
        writingSession.save();
        writingSession.content = content3;
        writingSession.save();
        writingSession.content = content4;
        writingSession.save();

        assertTrue(writingSession.getSave(writingSession.saves.get(0)).content.equals(content1));
        System.out.println(writingSession.getSave(writingSession.saves.get(0)).content);
        assertTrue(writingSession.getSave(writingSession.saves.get(1)).content.equals(content2));
        System.out.println(writingSession.getSave(writingSession.saves.get(1)).content);
        assertTrue(writingSession.getSave(writingSession.saves.get(2)).content.equals(content3));
        System.out.println(writingSession.getSave(writingSession.saves.get(2)).content);
        assertTrue(writingSession.getSave(writingSession.saves.get(3)).content.equals(content4));
        System.out.println(writingSession.getSave(writingSession.saves.get(3)).content);

    }

    @Test
    void testAPI(){

        OpenAI.INSTANCE.prompt = "test";
        assertTrue(OpenAI.INSTANCE.respond().status().equals(Optional.of(ResponseStatus.COMPLETED)));

    }

    @Test
    void checkErrorHandling() throws InterruptedException {

        WritingSession writingSession = new WritingSession("China", "test");

        Thread.sleep(50);
        assertTrue(writingSession.getSave(LocalDateTime.now()).content.equals("Save not found."));

    }







}
