# Character Streams

The Java platform stores character values using Unicode conventions. Character stream I/O automatically translates this internal format to and from the local character set. In Western locales, the local character set is usually an 8-bit superset of ASCII.

For most applications, I/O with character streams is no more complicated than I/O with byte streams. Input and output done with stream classes automatically translates to and from the local character set. A program that uses character streams in place of byte streams automatically adapts to the local character set and is ready for internationalization — all without extra effort by the programmer.

If internationalization isn't a priority, you can simply use the character stream classes without paying much attention to character set issues. Later, if internationalization becomes a priority, your program can be adapted without extensive recoding. See the [Internationalization]() trial for more information.

## Using Character Streams

All character stream classes are descended from [Reader](https://docs.oracle.com/javase/8/docs/api/java/io/Reader.html) and [Writer](https://docs.oracle.com/javase/8/docs/api/java/io/Writer.html). As with byte streams, there are character stream classes that specialize in file I/O: [FileReader](https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html) and [FileWriter](https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html). The [CopyCharacters](https://docs.oracle.com/javase/tutorial/essential/io/examples/CopyCharacters.java) example illustrates these classes.