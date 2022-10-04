
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestRectangle {

   @Test
   public void testProps()
   {
     Rectangle r = new Rectangle(10, 20);

     int w = r.getWidth();
     assertEquals(w, 10);
     
     int h = r.getHeight();
     assertEquals(h, 20);
   }
}
