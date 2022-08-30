package homework8;

public final class Man extends Human {

    @Override
    public String greetPet() {
        return "Hello, " + getPet();
    }

    public static void repairCar(){
        System.out.println("Man repairs the car");
    }
}