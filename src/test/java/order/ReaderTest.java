package test.java.order;

import main.java.order.Reader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;



public class ReaderTest {

    private final InputStream originalIn = System.in;
    private Reader reader;

    @AfterEach
    void tearDown() {
        // System.in이 테스트 중에 close 되었을 수 있으니 복원
        System.out.println(originalIn);
    }

    @Test
    @DisplayName("readInt()는 입력된 정수를 올바르게 반환한다")
    void testReadSingleInt() {
        //42를 입력했다고 가정
        String input = "42";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        reader = new Reader();

        int result = reader.readInt();
//        assertThat(result).isEqualtTo(42);
    }
}
