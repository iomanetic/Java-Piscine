# remove old target directory
rm -rf target

# create new target directory
mkdir target

# compile and move class files in target directory
javac -d target ImagesToChar/src/java/edu/school21/printer/*/*.java

# run program
java -cp target edu/school21/printer/app/Program . 0 it.bmp
