import java.io.*;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        CharArrayWriter writer = new CharArrayWriter();
        for (String word :
                words) {
            writer.write(word);
        }
        OutputStream stream = new FileOutputStream(new File("some.txt"));
        return writer.toCharArray();
    }
}