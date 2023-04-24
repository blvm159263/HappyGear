
# build spring boot application base on staging yml
echo "Build spring boot application base on staging yml"
mvn clean package -DskipTests -Pstag

# deploy to staging server
echo "Deploy to staging server"
scp -r target admin@13.215.150.32:~/happygear