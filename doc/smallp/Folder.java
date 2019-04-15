import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Folder {

    public enum SizeUnit {
        Unit_G, Unit_M, Unit_K
    }

    public static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

    public static Map<SizeUnit, Long> SIZES = new HashMap<SizeUnit, Long>();

    static{
        SIZES.put(SizeUnit.Unit_G, Long.valueOf(1000 * 1000 * 1000l));
        SIZES.put(SizeUnit.Unit_M, Long.valueOf(1000 * 1000l));
        SIZES.put(SizeUnit.Unit_K, Long.valueOf(1000l));
    }

    public static String readableTime(long time) {
        return format.format(new Date(time));
    }

    public static String readableSize(long size){
        if((size / SIZES.get(SizeUnit.Unit_G)) > 0){
            int s = (int)(size / SIZES.get(SizeUnit.Unit_M));
            double f = s/1000.00;
            StringBuffer buffer = new StringBuffer();
            buffer.append(f);
            buffer.append("G");
            return buffer.toString();
        }else if((size / SIZES.get(SizeUnit.Unit_M)) > 0){
            int s = (int)(size / SIZES.get(SizeUnit.Unit_K));
            double f = s/1000.00;
            StringBuffer buffer = new StringBuffer();
            buffer.append(f);
            buffer.append("M");
            return buffer.toString();
        }else if((size / SIZES.get(SizeUnit.Unit_K)) > 0){
            int s = (int)(size);
            double f = s/1000.00;
            StringBuffer buffer = new StringBuffer();
            buffer.append(f);
            buffer.append("K");
            return buffer.toString();
        }
        return String.valueOf(size);
    }

    public static Tree parse(String root) {
        File rootFile = new File(root);
        Tree tree = parseSub(rootFile);
        return tree;
    }

    public static Tree<File> parseSub(File file) {
        Tree<File> sub = new Tree<>(file);
        if(file.isDirectory() && file.canRead()) {
            File[] files = file.listFiles();
            for(File f: files) {
                sub.addSubTree(parseSub(f));
            }
        }
        return sub;
    }

    public static void main(String[] args) {
        List<File> files = Folder.parse(args[0]).wideList();
        files
                .stream().filter(f -> f.isFile()).collect(Collectors.toList())
                .stream().forEach(f -> {
            System.out.println("" + f.getAbsolutePath() + " | size : " + Folder.readableSize(f.length()) + " | modified : " + Folder.readableTime(f.lastModified()));
        });
    }
}
