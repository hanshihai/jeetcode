import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static String name(Element e) {
        return e.getName();
    }

    private List<Element> elements = new ArrayList<>();

    private class Element {
        int index;
        String name;
        String value;

        public Element(){}

        public Element(int index, String name, String value) {
            this.index = index;
            this.name = name;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return index;
        }

        @Override
        public boolean equals(Object o) {
            if(o == null) {
                return false;
            }
            if(o instanceof Element) {
                return index == ((Element)o).index;
            }
            return false;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private void init() {
        for(int i=0;i<10;i++) {
            Element e = new Element(i, String.valueOf(i), "value of "+String.valueOf(i));
            elements.add(e);
        }
    }
    public StreamTest() {
        init();
    }

    public void print() {
        elements.stream().forEach(e -> System.out.println(e.getIndex() + " | " + e.getName() + " | " + e.getValue()));
    }

    public void printElement(Element e) {
        if(e != null) {
            System.out.println(e.getIndex() + " | " + e.getName() + " | " + e.getValue());
        }
    }
    public void distict() {
        init();
        print();
        System.out.println(" --- the old size: "+ elements.size() +" ---");
        elements = elements.stream().distinct().collect(Collectors.toList());
        print();
    }

    public void filter() {
        print();
        System.out.println(" --- the old size: "+ elements.size() +" ---");
        elements = elements.stream().filter(e -> e.getIndex() > 5).collect(Collectors.toList());
        print();
    }

    public void findAny() {
        print();
        System.out.println(" --- the old size: "+ elements.size() +" ---");
        Optional<Element> oe = elements.stream().findAny();
        printElement(oe.get());
    }

    public void map() {
        print();
        System.out.println(" --- the old size: "+ elements.size() +" ---");
        List<String> maped = elements.stream().map(StreamTest::name).collect(Collectors.toList());
        maped.stream().forEach(s -> System.out.print(s + "  "));
    }

    public void sorted() {
        print();
        System.out.println(" --- the old size: "+ elements.size() +" ---");
        elements = elements.stream().sorted(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o2.getIndex() - o1.getIndex();
            }

            @Override
            public boolean equals(Object obj) {
                return this.equals(obj);
            }
        }).collect(Collectors.toList());
        print();
    }

    public void reduce() {
        print();
        System.out.println(" --- the old size: "+ elements.size() +" ---");
        /**
         * it would get the wrong result for sum when using stream().parallel()
         * **/
        int result = elements.stream().reduce(5, new BiFunction<Integer, Element, Integer>() {
            @Override
            public Integer apply(Integer integer, Element element) {
                return integer + Integer.valueOf(element.getIndex());
            }
        }, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });
        System.out.println("reduce result : " + result);
    }

    public void peek() {
        print();
        System.out.println(" --- the old size: "+ elements.size() +" ---");
        elements = elements.stream().parallel().peek(e -> System.out.println("onging "+e.getName())).collect(Collectors.toList());
        print();
    }

    public static void main(String[] args) {
        StreamTest t = new StreamTest();
        t.peek();
    }
}
