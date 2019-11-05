import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;

public class NioChannel {

    public static void main(String[] args) throws Exception {

        Path filePath = FileSystems.getDefault().getPath("temp.txt");
        SeekableByteChannel channel = Files.newByteChannel(filePath, StandardOpenOption.READ);
        long size = channel.size();
        ByteBuffer buffer = ByteBuffer.allocate((int)size);
        int index = channel.read(buffer);
        char[] bytes = new char[index];
        for(int i=0;i<index-1;i++) {
            bytes[i] = (char)buffer.get(i);
        }
        String result = String.valueOf(bytes);

        System.out.println("the index is :" + index + "\n the content: " + result);
        channel.close();
    }
}
