git pull
mvn clean
mvn package -DskipTests
docker build -t hoytnote .
docker-compose up
# docker-compose logs -f