public class Bat extends Mammal {

    public Bat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        IO.println("Screech!");
    }

    @Override
    void feedYoung() {
        IO.println("Feeds the young with milk");
    }

    @Override
    public void move() {
        IO.println("The bat flies");
    }

    public void fly() {
        IO.println("The bat is flying");
    }

}
