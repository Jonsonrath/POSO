public class Dog extends Mammal{

    public Dog(String name){
        super(name);
    }

    @Override
    public void makeSound() {

        IO.println("WUFF WUFF!");

    }

    @Override
    void feedYoung() {
        IO.println("Säugt die Welpen");
    }

}
