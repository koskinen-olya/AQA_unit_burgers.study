import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {


    @Test
    public void testGetName(){
        String nameBun = "grey bun";
        Bun bun = new Bun(nameBun,100 );
        Assert.assertEquals(nameBun, bun.getName());
    }

    @Test
    public void testGetPrice(){
        float priceBun = 100;
        Bun bun = new Bun("name",priceBun);
        Assert.assertEquals(priceBun, bun.getPrice(),0);
    }
}
