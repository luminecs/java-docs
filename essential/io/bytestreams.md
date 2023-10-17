# Byte Streams

Programs use `byte streams` to perform input and output of 8-bit bytes. All byte stream classes are descended from [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html) and [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html).

There are many byte stream classes. To demonstrate how byte streams work, we'll focus on the file I/O byte streams, [FileInputStream](https://docs.oracle.com/javase/8/docs/api/java/io/FileInputStream.html) and [FileOutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/FileOutputStream.html). Other kinds of byte streams are used in much the same way; they differ mainly in the way they are constructed.

## Using Byte Streams

We'll explore `FileInputStream` and `FileOutputStream` by examining an example program named [CopyBytes](https://docs.oracle.com/javase/tutorial/essential/io/examples/CopyBytes.java), which uses byte streams to copy `xanadu.txt`, one byte at a time.

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String appRootPath = System.getProperty("user.dir");
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(appRootPath + "/essential/io/xanadu.txt");
            out = new FileOutputStream(appRootPath + "/essential/io/outagain.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
```

CopyBytes spends most of its time in a simple loop that reads the input stream and writes the output stream, one byte at a time, as shown in the following figure.

![Simple byte stream input and output](./images/byteStream.gif "Simple byte stream input and output")

## Always Close Streams

Closing a stream when it's no longer needed is very important — so important that CopyBytes uses a `finally` block to guarantee that both streams will be closed even if an error occurs. This practice helps avoid serious resource leaks.

One possible error is that CopyBytes was unable to open one or both files. When that happens, the stream variable corresponding to the file never changes from its initial `null` value. That's why CopyBytes makes sure that each stream variable contains an object reference before invoke `close`.

## When Not to Use Byte Streams

CopyBytes seems like a normal program, but it actually represents a kind of low-level I/O that you should avoid. Since xanadu.txt contains character data, the best approach is to use [character streams](), as discussed in the next section. There are also streams for more complicated data types. Byte streams should only be used for the most primitive I/O.

So why talk about byte streams? Because all other streams types are built on byte streams.