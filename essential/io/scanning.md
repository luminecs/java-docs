# Scanning

Objects of type [Scanner](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html) are useful for breaking down formatted input into tokens and translating individual tokens according to their data type.

## Breaking Input into Tokens

<u>By default, a scanner uses white space to separate tokens.</u> (White space characters include blanks, tabs, and line terminators. For the full list, refer to the documentation for [Character.isWhitespace](https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isWhitespace-char-).) To see how scanning works, let's look at [ScanXan](https://docs.oracle.com/javase/tutorial/essential/io/examples/ScanXan.java), a program that reads the individual words in xanadu.txt and prints them out, one per line.

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScanXan {
    public static void main(String[] args) throws IOException {
        String appRootPath = System.getProperty("user.dir");
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader(appRootPath + "/essential/io/xanadu.txt")));
            // s.useDelimiter(",\\s*");
            while (s.hasNext()) {
                System.out.println(s.next());
                // System.out.println(s.nextLine());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
```

Notice that ScanXan invokes Scanner's `close` method when it is done with the scanner object. <u>Even though a scanner is not a stream, you need to close it to indicate that you're done with its underlying stream.</u>

The output of ScanXan looks like this:

```
In
Xanadu
did
Kubla
Khan
A
stately
pleasure-dome
...
```

To use a different token separator, invoke `useDelimiter()`, specifying a regular expression. For example, suppose you wanted the token separator to be a comma, optionally followed by white space. You would invoke, `s.useDelimiter(",\\s*");`.

## Translating Individual Tokens

The ScanXan example treats all input tokens as simple String values. Scanner also supports tokens for all of the Java language's primitive types (except for char), as well as `BigInteger` and `BigDecimal`. Also, numeric values can use thousands separators. Thus, in a US locale, Scanner correctly reads the string "32,767" as representing an integer value.

We have to mention the locale, because thousands separators and decimal symbols are locale specific. So, the following example would not work correctly in all locales if we didn't specify that the scanner should use the US locale. That's not something you usually have to worry about, because your input data usually comes from sources that use the same locale as you do. But this example is part of the Java Tutorial and gets distributed all over the world.

The [ScanSum](https://docs.oracle.com/javase/tutorial/essential/io/examples/ScanSum.java) example reads a list of double values and adds them up. Here's the source:

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScanSum {
    public static void main(String[] args) throws IOException {
        String appRootPath = System.getProperty("user.dir");
        Scanner s = null;
        double sum = 0;
        try {
            s = new Scanner(new BufferedReader(new FileReader(appRootPath + "/essential/io/usnumbers.txt")));
            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    s.next();
                }
            }
        } finally {
            s.close();
        }
        System.out.println(sum);
    }
}
```

And here's the sample input file, [usnumbers.txt](https://docs.oracle.com/javase/tutorial/essential/io/examples/usnumbers.txt)

```
8.5
32,767
3.14159
1,000,000.1
```

The output string is "1032778.74159". The period will be a different character in some locales, because `System.out` is a `PrintStream` object, and that class doesn't provide a way to override the default locale. We could override the locale for the whole program — or we could just use formatting, as described in the next topic, [Formatting](formatting.md).