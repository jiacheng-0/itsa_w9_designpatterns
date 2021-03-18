package itsa.patterns;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.*;

public class BuildPizzaTest {
	@Test
	public void testBuildPizza() {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzabuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

        waiter.setPizzaBuilder( hawaiianPizzabuilder );
        waiter.constructPizza();
        String pizza = waiter.getPizza();
		System.out.println(pizza);
		assert pizza.equals("crossmildpineapple") : "Pizza is not right";
		
		waiter.setPizzaBuilder( spicyPizzaBuilder );
        waiter.constructPizza();
        pizza = waiter.getPizza();
		System.out.println(pizza);
		assert pizza.equals("bakedhotpepperoni") : "Pizza is not right";
	}
}
