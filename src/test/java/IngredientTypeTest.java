import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String ingredient;

    public IngredientTypeTest(String ingredient) {
        this.ingredient = ingredient;
    }

    @Parameterized.Parameters()
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void testIngredientTypeSauce() {
        Assert.assertNotNull(IngredientType.valueOf(ingredient));
    }
}

