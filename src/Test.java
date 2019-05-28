public interface Test {

    public void methodA();

    public default void methodB() {
        System.out.println("I am default method in interface.");
    }
}
