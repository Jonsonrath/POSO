public abstract class Mammal implements IAnimal {

    protected String name;

    protected Mammal(String name) {
        this.name = name;
    }



    public void move() {
        System.out.println("The mammal moves");
    }
    public void makeSound() {
        System.out.println("The mammal makes a sound");
    }

    abstract void feedYoung();

}
