abstract class SandwichCooking {

    boolean afterFirstCondiment = false;
    final void makeSandwich(){
        cutBun();

        if(CheckMeat()){
            addMeat();
            afterFirstCondiment = true;
        }

        if(CheckCheese()){
            if(afterFirstCondiment) { System.out.print("\n"); }
            addCheese();
            afterFirstCondiment = true;
        }

        if(CheckVegetables()){
            if(afterFirstCondiment) { System.out.print("\n"); }
            addVegetables();
            afterFirstCondiment = true;
        }

        if(CheckCondiments()){
            if(afterFirstCondiment) { System.out.print("\n"); }
            addCondiments();
            afterFirstCondiment = true;
        }
        wrapTheSandwich();
    }

    abstract void addMeat();
    abstract void addCheese();
    abstract void addVegetables();
    abstract void addCondiments();

    public void cutBun(){
        System.out.println("The Bun is Cut");

    }

    boolean CheckMeat() { return true; }
    boolean CheckCheese() { return true; }
    boolean CheckVegetables() { return true; }
    boolean CheckCondiments() { return true; }

    public void wrapTheSandwich(){
        System.out.println("\nWrap the Sandwich");
    }

    public void afterFirstCondiment(){
        System.out.println("\n");
    }
}

class VeggieSandwichCooking extends SandwichCooking{

    String[] veggiesUsed = { "Lettuce", "Tomatoes", "Onions", "Sweet Peppers" };
    String[] condimentsUsed = { "Oil", "Vinegar" };

    boolean customerWantsMeat() { return false; }
    boolean customerWantsCheese() { return false; }

    @Override
    public void addVegetables(){
        System.out.print(" + Vegetables : ");
        for (String vegetable : veggiesUsed){
            System.out.print(vegetable + " ");
        }
    }
    @Override
    public void addCondiments(){
        System.out.print(" + Condiments : ");
        for (String condiment : condimentsUsed){
            System.out.print(condiment + " ");
        }
    }

    @Override
    boolean CheckMeat() {return false;}
    @Override
    void addMeat() {}
    @Override
    boolean CheckCheese() {return false;}
    @Override
    void addCheese() {}

}

class TurkishSandwichCooking extends SandwichCooking{

    String[] meatUsed = { "Dana Kusbasi" };
    String[] cheeseUsed = { "Sivas Koy Peyniri" };
    String[] veggiesUsed = { "Domates", "Sovan", "Yesillik" };
    String[] condimentsUsed = { "Zeytin yagi", "isot", "kirmizi pul biber" };

    @Override
    public void addMeat(){
        System.out.print(" + Meat : ");
        for (String meat : meatUsed){
            System.out.print(meat + " ");
        }
    }

    @Override
    public void addCheese(){
        System.out.print(" + Cheese : ");
        for (String cheese : cheeseUsed){
            System.out.print(cheese + " ");
        }
    }

    @Override
    public void addVegetables(){
        System.out.print(" + Vegetables : ");
        for (String vegetable : veggiesUsed){
            System.out.print(vegetable + " ");
        }
    }

    @Override
    public void addCondiments(){
        System.out.print(" + Condiments : ");
        for (String condiment : condimentsUsed){
            System.out.print(condiment + " ");
        }
    }
}

class ItalianSandwichCooking extends SandwichCooking{

    String[] meatUsed = { "Salami", "Pepperoni", "Capicola Ham" };
    String[] cheeseUsed = { "Provolone" };
    String[] veggiesUsed = { "Lettuce", "Tomatoes", "Onions", "Sweet Peppers" };
    String[] condimentsUsed = { "Oil", "Vinegar" };

    @Override
    public void addMeat(){
        System.out.print(" + Meat : ");
        for (String meat : meatUsed){
            System.out.print(meat + " ");
        }
    }

    @Override
    public void addCheese(){
        System.out.print(" + Cheese : ");
        for (String cheese : cheeseUsed){
            System.out.print(cheese + " ");
        }
    }

    @Override
    public void addVegetables(){
        System.out.print(" + Vegetables : ");
        for (String vegetable : veggiesUsed){
            System.out.print(vegetable + " ");
        }
    }

    @Override
    public void addCondiments(){
        System.out.print(" + Condiments : ");
        for (String condiment : condimentsUsed){
            System.out.print(condiment + " ");
        }
    }
}

public class Main {

    public static void main(String[] args){
        System.out.println("------ Customer A  order a Italian Sandwich ------");
        SandwichCooking customer_a = new ItalianSandwichCooking();
        customer_a.makeSandwich();

        System.out.println();

        System.out.println("------ Customer B  order a Veggie Sandwich ------");
        SandwichCooking customer_b = new VeggieSandwichCooking();
        customer_b.makeSandwich();
        System.out.println();

        System.out.println("------ Customer C  order a Turkish Sandwich ------");
        SandwichCooking customer_c = new TurkishSandwichCooking();
        customer_c.makeSandwich();

    }
}