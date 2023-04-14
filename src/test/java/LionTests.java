import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LionTests {

    String sex;
    boolean hasManeResult;
    public LionTests(String sex, boolean hasManeResult){
        this.sex=sex;
        this.hasManeResult = hasManeResult;
    }

    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void lionHasManeReturnsCorrect() throws Exception{
        Feline feline = new Feline();
        Lion lion = new Lion(feline,sex);
        boolean actualResult = lion.doesHaveMane();
        Assert.assertEquals(hasManeResult,actualResult);

    }

    @Test
    public void lionGetFoodReturnsListOfMeat() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(feline, sex);
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = lion.getFood();
        assertTrue(actualResult.containsAll(expectedResult));
    }

    @Test
    public void lionGetKittensShouldReturnOne() throws Exception{
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, sex);
        int expectedResult = 1;
        int actualResult = lion.getKittens();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void lionSendIncorrectSexThrowsException() throws Exception {
        Feline feline = new Feline();
        String expectedResult = "Используйте допустимые значения пола животного - самей или самка";
        try {
            Lion lion = new Lion(feline, "Тест");
        } catch (Exception exception){
            String actualResult = exception.getMessage();
            assertEquals(expectedResult, actualResult);
        }
    }

}
