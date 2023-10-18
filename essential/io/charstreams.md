# Character Streams

The Java platform stores character values using Unicode conventions. Character stream I/O automatically translates this internal format to and from the local character set. In Western locales, the local character set is usually an 8-bit superset of ASCII.

For most applications, I/O with character streams is no more complicated than I/O with byte streams. Input and output done with stream classes automatically translates to and from the local character set. A program that uses character streams in place of byte streams automatically adapts to the local character set and is ready for internationalization — all without extra effort by the programmer.

If internationalization isn't a priority, you can simply use the character stream classes without paying much attention to character set issues. Later, if internationalization becomes a priority, your program can be adapted without extensive recoding. See the [Internationalization]() trial for more information.

## Using Character Streams

All character stream classes are descended from [Reader](https://docs.oracle.com/javase/8/docs/api/java/io/Reader.html) and [Writer](https://docs.oracle.com/javase/8/docs/api/java/io/Writer.html). As with byte streams, there are character stream classes that specialize in file I/O: [FileReader](https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html) and [FileWriter](https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html). The [CopyCharacters](https://docs.oracle.com/javase/tutorial/essential/io/examples/CopyCharacters.java) example illustrates these classes.

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        String appRootPath = System.getProperty("user.dir");
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader(appRootPath + "/essential/io/xanadu.txt");
            outputStream = new FileWriter(appRootPath + "/essential/io/characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
```

CopyCharacters is very similar to CopyBytes. The most important difference is that CopyCharacters uses `FileReader` and `FileWriter` for input and output in place of `FileInputStream` and `FileOutputStream`. <u>Notice that both CopyBytes and CopyCharacters use an `int` variable to read to and write from. However, in CopyCharacters, the int variables holds a character value in its last 16 bits; in CopyBytes, the int variable holds a byte value in its last 8 bits.</u>

## Character Streams that Use Byte Streams

Character streams are often "wrappers" for byte streams. The character stream uses the byte stream to perform the physical I/O, while the character stream handles translation between characters and bytes. FileReader, for example, uses FileInputStream, while FileWriter uses FileOutputStream.

There are two general-purpose byte-to-character "bridge" streams: [InputStreamReader](https://docs.oracle.com/javase/8/docs/api/java/io/InputStreamReader.html) and [OutputStreamWriter](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStreamWriter.html). Use them to create character streams when there are no prepackaged character stream classes that meet your needs. The [sockets lesson]() in the [networking trail]() shows how to create character streams from the byte streams provided by socket classes.

## Line-Oriented I/O

Character I/O usually occurs in bigger units than single characters. One common unit is the line: a string of characters with a line terminator at the end. A line terminator can be a `carriage-return/line-feed sequence ("\r\n")`, a `single carriage-return ("\r")`, or a `single line-feed ("\n")`. Supporting all possible line terminators allows programs to read text files created on any of the widely used operating systems.