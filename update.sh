#git pull
mvn clean package -DskipTests
docker build -t hoytnote .
docker-compose up
# docker-compose logs -f