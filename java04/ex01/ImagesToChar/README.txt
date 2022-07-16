# remove old target directory
rm -rf target

# create new target directory
mkdir target

# move resources directory in target
cp -r src/resources target/

# compile and move class files in target directory
javac -d target src/java/edu/school21/printer/*/*.java

# build .jar file
jar -cfm target/images-to-chars-printer.jar src/manifest.txt -C target .

# run jar file
java -jar target/images-to-chars-printer.jar . 0