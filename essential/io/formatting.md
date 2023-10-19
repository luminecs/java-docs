# Formatting

Stream objects that implement formatting are instances of either [PrintWriter](https://docs.oracle.com/javase/8/docs/api/java/io/PrintWriter.html), a character stream class, or [PrintStream](https://docs.oracle.com/javase/8/docs/api/java/io/PrintStream.html), a byte stream class.

> **Note:** The only `PrintStream` objects you are likely to need are [System.out](https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#out) and [System.err](https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#err). (See [I/O from the Command Line](cl.md) for more on these objects.) When you need to create a formatted output stream, instantiate `PrintWriter`, not `PrintStream`.

Like all byte and character stream objects, instances of `PrintStream` and `PrintWriter` implements a standard set of `write` methods for simple byte and character output. In addition, both `PrintStream` and `PrintWriter` implement the same set of methods for converting internal data into formatted output. Two levels of formatting are provided:

* `print` and `println` format individual values in a standard way.
* `format` formats almost any number of values based on a format string, with many options for precise formatting.