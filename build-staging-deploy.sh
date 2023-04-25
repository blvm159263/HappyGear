echo "pull all changes from git"
git pull origin main

echo "Build spring boot application base on staging yml"
mvn clean package -DskipTests -Pstag

echo "Deploy to staging server"
scp -r target happygear@20.2.64.67:~/happygear

echo "go to staging server"
ssh happygear@20.2.64.67

echo "go to happygear folder"
cd happygear

echo "build api-server and mysql"
docker-compose up -d --build api-server mysql

echo "reload nginx"
docker exec -it happygear_nginx_1 nginx -s reload