# Lesson: Basic I/O

This lesson covers the Java platform classes used for basic I/O. It first focuses on I/O Streams, a powerful concept that greatly simplifies I/O operations. The lesson also looks at serialization, which lets a program write whole objects out to streams and read them back again. Then the lesson looks at file I/O and file system operations, including random access files.

Most of the classes covered in the `I/O Streams` section are in the `java.io` package. Most of the classes covered in the `File I/O` section are in the `java.nio.file` package.

## [I/O Streams]()

* [Byte Streams]() handle I/O of raw binary data.
* [Character Streams]() handle I/O of character data, automatically handling translation to and from the local character set.
* [Buffered Streams]() optimize input and output by <u>reducing the number of calls to the native API</u>.
* [Scanning and Formatting]() allows a program to read to write formatted text.
* [I/O from the Command Line]() describes the Standard Streams and the Console object.
* [Data Streams]() handle binary I/O of primitive data type and String values.
* [Object Streams]() handle binary I/O of objects.

## [File I/O (Featuring NIO.2)]()

* [What is a Path?]() examines the concept of a path on a file system.
* [The Path Class]() introduces the cornerstone class of the `java.nio.file` package.
* [Path Operations]() looks at methods in the `Path` class that deal with syntactic operations.
* [File Operations]() introduces concepts common to many of the file I/O methods.
* [Checking a File or Directory]() shows how to check a file's existence and its level of accessibility.
* [Deleting a File or Directory]().
* [Copying a File or Directory]().
* [Moving a File or Directory]().
* [Managing Metadata]() explains how to read and set file attributes.
* [Reading, Writing and Creating Files]() shows the stream and channel methods for reading and writing files.
* [Random Access Files]() shows how to read or write files in a non-sequentially manner.
* [Creating and Reading Directories]() covers API specific to directories, such as how to list a directory's contents.
* [Links, Symbolic or Otherwise]() covers issues specific to symbolic and hard links.
* [Walking the File Tree]() demonstrates how to recursively visit each file and directory in a file tree.
* [Finding Files]() shows how to search for files using <u>pattern matching</u>.
* [Watching a Directory for Changes]() shows how to use the watch service to detect files that are added, removed or updated in one on more directories.
* [Other Useful Methods]() covers important API that didn't fit elsewhere in the lesson.
* [Legacy File I/O Code]() shows how to leverage `Path` functionality if you have order code using the `java.io.File` class. <u>A table mapping `java.io.File` to `java.nio.file` API is provided</u>.

## [Summary]()

A summary of the key points covered in this trail.

## [Questions and Exercises]()

Test what you've learned in this trail by trying these questions and exercises.

## The I/O Classes in Action

Many of the examples in the next trail, [Custom Networking]() use the I/O streams described in this lesson to read from and write to network connections.

> **Security consideration**: Some I/O operations are subject to approval by the current security manager. The example programs contained in these lessons standalone applications, which by default have no security manager. To work in an applet, most of these examples would have to be modified. See [What Applets Can and Cannot Do]() for information about the security restrictions placed on applets.





































