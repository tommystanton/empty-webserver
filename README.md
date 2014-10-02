# Web server

This is a collaborative project for Java training, conducted by [8th
Light](http://www.8thlight.com/).

The goal is to implement an HTTP web server from scratch, in Java.

The goal is reached when the server passes the tests provided by [Cob
Spec](https://github.com/8thlight/cob_spec).

## Building the JAR

    $ mvn assembly:assembly -DdescriptorId=jar-with-dependencies
    $ java -jar target/server-1.0-jar-with-dependencies.jar

(Got this idea from a [Stack Overflow
answer](http://stackoverflow.com/a/1729202/1265245).)
