javac.exe gui/handler/*.java
javac.exe gui/*.java
javac gui2/*.java
javac travelData/*.java
javac weatherdata/*.java
jar cvfm program.jar manifest.txt gui/*.class gui2/*.class travelData/*.class weatherdata/*.class gui/handler/*.class assets lib
