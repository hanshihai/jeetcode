import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

    private T root;
    private List<Tree<T>> subTree;

    public Tree(T root) {
        this.root = root;
    }

    public Tree(T root, List<Tree<T>> subTree) {
        this.root = root;
        this.subTree = subTree;
    }

    public void addSubTree(Tree sub) {
        if(subTree == null) {
            subTree = new ArrayList<Tree<T>>(1);
        }
        subTree.add(sub);
    }

    public T getRoot() {
        return root;
    }

    public List<Tree<T>> getSubTrees() {
        return this.subTree;
    }

    public boolean isLeaf() {
        if(subTree != null && subTree.size() > 0) {
            return false;
        }
        return true;
    }

    public int count() {
        int i = 1;
        for(Tree sub: subTree) {
            i=i+sub.count();
        }
        return i;
    }

    public List<T> deepList() {
        List<T> result = new ArrayList<>();
        result.add(root);
        if(!isLeaf()){
            for(Tree sub: subTree) {
                result.addAll(sub.deepList());
            }
        }
        return result;
    }


    private List<T> listSubTree(Tree t) {
        List<T> result = new ArrayList<>();
        List<Tree> buffer = new ArrayList<>();
        if(!t.isLeaf()) {
            t.subTree.stream().forEach(sub -> {
                result.add(((Tree<T>) sub).getRoot());
                buffer.add((Tree<T>)sub);
            });
            buffer.stream().forEach(b -> result.addAll(listSubTree(b)));
        }
        return result;
    }

    public List<T> wideList() {
        List<T> result = new ArrayList<>();
        result.add(root);
        result.addAll(listSubTree(this));
        return result;
    }

    public static void main(String[] args) {
        Tree a = new Tree("a");
        Tree b = new Tree("b");
        Tree c = new Tree("c");
        Tree d = new Tree("d");
        Tree e = new Tree("e");
        Tree f = new Tree("f");
        Tree g = new Tree("g");

        f.addSubTree(g);
        c.addSubTree(d);
        b.addSubTree(c);
        b.addSubTree(e);
        b.addSubTree(f);
        a.addSubTree(b);

        System.out.println(" -----------  deep listSubTree -----------");
        List<String> deepList = a.deepList();
        deepList.stream().forEach(t -> System.out.println(t));
        System.out.println(" -----------  wide listSubTree -----------");
        List<String> wideList = a.wideList();
        wideList.stream().forEach(t -> System.out.println(t));
    }
}
