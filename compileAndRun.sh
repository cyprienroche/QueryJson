# cd into the directory containing this script
cd "$(dirname "$0")"

./gradlew build
java -cp build/classes/java/main/ Main
