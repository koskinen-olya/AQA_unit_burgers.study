import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;

public class IngredientTest {

    @Test
    public void testGetPrice(){
        float priceIngredient = 100;
        Ingredient ingredient = new Ingredient(FILLING,"nameIngredient",priceIngredient);
        Assert.assertEquals(priceIngredient, ingredient.getPrice(),0);
    }

    @Test
    public void testGetName(){
        String nameIngredient = "meat";
        Ingredient ingredient = new Ingredient(FILLING,nameIngredient,100);
        Assert.assertEquals(nameIngredient, ingredient.getName());
    }

    @Test
    public void testGetType(){
        IngredientType ingredientType = FILLING;
        Ingredient ingredient = new Ingredient(ingredientType,"meat",100);
        Assert.assertEquals(ingredientType, ingredient.getType());
    }

}
