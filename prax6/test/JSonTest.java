import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.json.simple.JSONArray;
import org.junit.Before;
import org.junit.Test;


public class JSonTest {
    private JSon jSon;

    @Before
    public void setUp() {
        jSon = new JSon();
    }

    @Test
    public void TestDataRetrieval() {
        JSONArray commentsArray = mock(JSONArray.class);
        JSONArray todosArray = mock(JSONArray.class);

        when(commentsArray.size()).thenReturn(500);
        when(todosArray.size()).thenReturn(200);

        assertEquals(300, jSon.getData(commentsArray, todosArray));

        verify(commentsArray, only()).size();
        verify(todosArray, only()).size();
    }
}