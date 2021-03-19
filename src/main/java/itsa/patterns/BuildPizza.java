package itsa.patterns;

/* "Product" */
class Pizza {
    private String dough = "";
    private String sauce = "";
    private String topping = "";

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getDough() {
        return dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getSauce() {
        return sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getTopping() {
        return topping;
    }
}

/* "Abstract Builder" */
abstract class PizzaBuilder {
    protected Pizza pizza;

    public void createNewPizzaProduct() {
        pizza = new Pizza();
    }

    public String getPizza() {
        return pizza.getDough() + pizza.getSauce() + pizza.getTopping();
    }

    // you need to add the abstract methods for the steps of building a pizza - buildDough, buildSauce and buildTopping.
    public abstract void buildDough();

    public abstract void buildSauce();

    public abstract void buildTopping();

}

/* "ConcreteBuilder" */
class HawaiianPizzaBuilder extends PizzaBuilder {

    // you need to implement the abstract methods of the PizzaBuilder
    // the dough is "cross", sauce is "mild", topping is "pineapple"
    @Override
    public void buildDough() {
        pizza.setDough("cross");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("mild");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("pineapple");
    }
}

/* "ConcreteBuilder" */
class SpicyPizzaBuilder extends PizzaBuilder {
    // you need to implement the abstract methods of the PizzaBuilder
    // the dough is "baked", sauce is "hot", topping is "pepperoni"
    @Override
    public void buildDough() {
        pizza.setDough("baked");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("hot");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("pepperoni");
    }
}

/* "Director" */
class Waiter {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb) {
        pizzaBuilder = pb;
    }

    public String getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        // you need to put the generic construction of the pizza here.
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}

/* A customer ordering a pizza. */
public class BuildPizza {
    public static void main(String[] args) {

        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzabuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

        waiter.setPizzaBuilder(hawaiianPizzabuilder);
        waiter.constructPizza();
        String pizza = waiter.getPizza();
        System.out.println(pizza);
        assert pizza.equals("crossmildpineapple") : "Pizza is not right";

        waiter.setPizzaBuilder(spicyPizzaBuilder);
        waiter.constructPizza();
        pizza = waiter.getPizza();
        System.out.println(pizza);
        assert pizza.equals("bakedhotpepperoni") : "Pizza is not right";

    }
}