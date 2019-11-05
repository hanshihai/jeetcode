import java.util.LinkedList;

public class Question<E> {

    private final LinkedList<E> elements = new LinkedList<>();

    public boolean put(E e) throws InterruptedException {
        elements.add(e);
        notify();
        return true;
    }

    public E get() throws InterruptedException {
        while(true) {
            if (elements.isEmpty()) {
                wait();
            } else {
                return elements.getFirst();
            }
        }
    }
}
