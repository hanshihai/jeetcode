import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

public class ClassLoaderTest implements Serializable {

    private String text = "text";
    private transient int id = 1;

    private int sequence = 10;

    private void print() {
        System.out.println(" --- " +id + "  " + sequence + "   " + text);
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public static void main(String[] args) throws Exception {
        /*ClassLoaderTest test1 = new ClassLoaderTest();
        test1.setId(2);
        test1.setSequence(20);
        test1.print();

        ObjectOutputStream stream = null;
        ObjectInputStream in = null;
        try {
            stream = new ObjectOutputStream(new FileOutputStream(new File("temp.txt")));
            stream.writeObject(test1);

            in = new ObjectInputStream(new FileInputStream(new File("temp.txt")));
            ClassLoaderTest newTest = (ClassLoaderTest) in.readObject();

            newTest.print();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(stream != null) {
                stream.close();
            }
            if(in != null) {
                in.close();
            }
        }*/

        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        System.out.println(loader);
        ClassLoader loaderP = loader.getParent();
        System.out.println(loaderP);
        ClassLoader loaderPP = loaderP.getParent();
        System.out.println(loaderPP);
    }
}
