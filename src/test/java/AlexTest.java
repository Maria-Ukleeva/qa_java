import com.example.Alex;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlexTest {
    @Test
    public void alexHasManeReturnsTrue() throws Exception{
        Feline feline = new Feline();
        Alex alex = new Alex(feline);
        boolean actualResult = alex.doesHaveMane();
        Assert.assertEquals(true,actualResult);

    }

    @Test
    public void alexGetFoodReturnsListOfMeat() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Alex alex = new Alex(feline);
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = alex.getFood();
        assertTrue(actualResult.containsAll(expectedResult));
    }

    @Test
    public void alexGetKittensShouldReturnZero() throws Exception{
        Feline feline = new Feline();
        Alex alex = new Alex(feline);
        int actualResult = alex.getKittens();
        assertEquals(0, actualResult);
    }

    @Test
    public void alexGetFriendsReturnsListOfFriends() throws Exception {
        Feline feline = new Feline();
        Alex alex = new Alex(feline);
        List<String> expectedResult = List.of("Марти", "Глория", "Мелман");
        List<String> actualResult = alex.getFriends();
        assertTrue(actualResult.containsAll(expectedResult));
    }

    @Test
    public void alexGetPlaceOfLivingReturnsNewYorkZoo() throws Exception {
        Feline feline = new Feline();
        Alex alex = new Alex(feline);
        String actualResult = alex.getPlaceOfLiving();
        assertEquals("Нью-Йоркский зоопарк", actualResult);
    }


}
