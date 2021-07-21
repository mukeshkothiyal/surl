# bring down all containers
docker-compose down

# delete  old image
docker rmi surl-api:latest

# bring up db first
docker-compose up -d db

# build surl
mvn clean install

# bring up rest of the services
docker-compose up -d