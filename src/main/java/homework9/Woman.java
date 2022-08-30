package homework9;

public final class Woman extends Human {
    @Override
    public String greetPet() {
        return "Hello, " + getPet();
    }

    public static void makeup(){
        System.out.println("Woman makes up");;
    }
}