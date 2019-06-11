import java.util.HashSet;
import java.util.Iterator;

public class ClassLoaderTest {


    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        System.out.println(loader);
        ClassLoader loaderP = loader.getParent();
        System.out.println(loaderP);
        ClassLoader loaderPP = loaderP.getParent();
        System.out.println(loaderPP);
    }
}
