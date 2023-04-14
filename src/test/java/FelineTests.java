import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {

    @Spy
    Feline feline;


    @Test
    public void felineEatMeatReturnsListOfMeat() throws Exception{
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.eatMeat();
        assertTrue(actualResult.containsAll(expectedResult));
    }

    @Test
    public void felineGetFamilyReturnsFeline(){
        Feline feline = new Feline();
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void felineGetKittensWithNoArgumentReturnsOne(){
        int expectedResult = 1;
        int actualResult = feline.getKittens();
        assertEquals(expectedResult,actualResult);
    }


    @Test
    public void felineGetKittensWithArgumentReturnsSameQuantity(){
        Feline feline = new Feline();
        int expectedResult = 0;
        int actualResult = feline.getKittens(0);
        assertEquals(expectedResult,actualResult);
    }
}
