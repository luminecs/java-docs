# Buffered Streams

Most of the examples we've seen so far use unbuffered I/O. <u>This means each read or write request is handled directly by the underlying OS.</u> This can make a program much less efficient, <u>since each such request often triggers disk access, network activity, or some other operation that is relatively expensive.</u>

To reduce this kind of overhead, the Java platform implements buffered I/O streams. <u>Buffered input streams read data from a memory area known as a `buffer`; the native input API (内层的流) is called only when the buffer is empty.</u> Similarly, <u>buffered output streams write data to a buffer, and the native output API (内层的流) is called only when the buffer is full.</u>

> 注: 输入流缓冲区和输出流缓冲区不是同一个。

A program can convert an unbuffered stream into a buffered stream using the wrapping idiom we've used several times now, where <u>the unbuffered stream object is passed to the constructor for a buffered stream class</u>. Here's how you might modify the constructor invocations in the CopyCharacters example to use buffered I/O:

```
inputStream = new BufferedReader(new FileReader("xanadu.txt"));
outputStream = new BufferedWriter(new FileWriter("characteroutput.txt"));
```

There are four buffered stream classes used to wrap unbuffered streams: [BufferedInputStream](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedInputStream.html) and [BufferedOutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedOutputStream.html) create buffered byte streams, while [BufferedReader](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html) and [BufferedWriter](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html) create buffered character streams.

## Flushing Buffered Streams

It often makes sense to write out a buffer at critical points, without waiting for it to fill. This is known as `flushing` the buffer.

Some buffered output classes support autoflush, specified by an optional constructor argument. When autoflush is enabled, certain key events cause the buffer to be flushed. For example, an autoflush `PrintWriter` object flushes the buffer on every invocation of `println` or `format`. See [Formatting]() for more on these methods.

<u>To flush a stream manually, invokes its `flush` method.</u> The `flush` method is valid on any output stream, but has no effort unless the stream is buffered.