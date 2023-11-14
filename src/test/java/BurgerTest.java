import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static praktikum.IngredientType.FILLING;

public class BurgerTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientFirst;

    @Mock
    Ingredient ingredientSecond;

    @Test(expected = NullPointerException.class)
    public void testSetBuns() {
        Burger burger = new Burger();
        burger.getReceipt();
    }

    @Test
    public void testAddIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirst);
        Assert.assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void testRemoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirst);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(0,1);
        Assert.assertTrue(burger.ingredients.get(0).equals(ingredientSecond));
    }

    @Test
    public void testGetPrice(){
        Mockito.when(bun.getPrice()).thenReturn(2F);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(1F);
        //Для проверки метода getPrice необходимо добавить в бургер булочки и ингредиенты
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        Assert.assertEquals(5F,burger.getPrice() ,0);
    }
    @Test
    public void testGetReceipt(){
        Mockito.when(bun.getName()).thenReturn("name");
        Mockito.when(ingredientFirst.getType()).thenReturn(FILLING);
        Mockito.when(ingredientFirst.getName()).thenReturn("name");
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        String expected = "(==== name ====)\r\n" +
                "= filling name =\r\n" +
                "(==== name ====)\r\n" +
                "\r\n" +
                "Price: 0,000000\r\n";
        Assert.assertEquals(expected,burger.getReceipt());
    }
}
