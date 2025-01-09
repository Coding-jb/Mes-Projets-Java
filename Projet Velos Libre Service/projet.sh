export CLASSPATH="src:classes:test:junit-console.jar"

# Generation de la documentation
javadoc -sourcepath src -subpackages vlille -d docs

# compilation du projet
javac src/vlille/VlilleMain.java -d classes

# compilation des tests
javac test/vlille_test/**/*.java 

# execution des tests
java -jar junit-console.jar -classpath test:classes -scan-classpath

# creation d'un jar executable
jar cvfe vlille.jar vlille.VlilleMain -C classes .

# execution du jar
java -jar vlille.jar