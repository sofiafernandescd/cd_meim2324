set JAVA_HOME=C:\Program Files\Java\jdk-11.0.10
set PATH="D:\maven\apache-maven-3.8.1\bin";%PATH%
mvn install:install-file -Dfile=spread-5.0.1.jar -DgroupId=org.spread -DartifactId=spread -Dversion=5.0.1 -Dpackaging=jar
