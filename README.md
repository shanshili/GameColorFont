# GameColorFont
<table><tr><td bgcolor=yellow>**One puzzle game**</td></tr></table>

**Select the color of the text or the Font color of the text**

**\<GameDEMO\>** Game demo complete version:
 1. Want to make option a class
 2. Game level B

**\< GameDame2\>** To fix the old CMD display issues:

The color display mode is changed, but there is a problem in the command line execution with .Class, which is suspected to be related to a third-party external package when typing the command
```
Exception in thread "main" java.lang.NoClassDefFoundError: com/diogonunes/jcolor/AnsiFormat
        at TestColor.main(TestColor.java:28)
Caused by: java.lang.ClassNotFoundException: com.diogonunes.jcolor.AnsiFormat
        at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
```
But also found that only the older version of CMD does not run correctly...
