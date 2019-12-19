package callable;

public class Test1 {
    public static void main(String[] args) {
        TestCallable testCallable = new TestCallable();

        new Thread().start();
    }
}
