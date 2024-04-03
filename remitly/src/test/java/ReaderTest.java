import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ReaderTest {

    @Test
    void readerTest(){
        String filePath = "../remitly/src/main/resources/json.json";

        boolean result = Reader.readJson(filePath);

        assertFalse(result);
    }
}





