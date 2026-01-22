public class Bird implements IAnimal, IFlyable {

    private String name;
    private String species;

    public Bird(String name, String species) {
        this.name = name;
        this.species = species;
    }

    @Override
    public void makeSound() {
        IO.println("Chirp Chirp!");
    }

    @Override
    public void move() {
        IO.println("The bird flies");
    }
    public void fly(){
        IO.println("The bird is flying");
    }
}
