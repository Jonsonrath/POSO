//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {


    IO.println("Tier Simulation");

    List<IAnimal> animals = new ArrayList<>();

    animals.add(new Dog("Gorlock"));
    animals.add(new Bat("https://www.youtube.com/watch?v=xNX9H_ZkfNE"));
    animals.add(new Bird("Tweety", "Canary"));

    printFeedingBehavior(animals);


}

void printFeedingBehavior(List<IAnimal> list) {
    for (IAnimal animal : list) {
        if (animal instanceof Mammal mammal) {
            IO.print("Feeding method for " + mammal.name + ": ");
            mammal.feedYoung();
        }else{
            IO.println("No specific feeding method");
        }
    }
}

void printFlyingAnimals(List<IAnimal> list) {
    for (IAnimal animal : list) {
        if (animal instanceof IFlyable flyable) {
            IO.print("Flying behavior: ");
            flyable.fly();
        }
    }
}
