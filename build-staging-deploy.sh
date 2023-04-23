
# build spring boot application base on staging yml
mvn clean package -DskipTests -Pstag

# go to target folder
cd target

# deploy to staging server
scp -rf target admin@13.215.150.32:~/happygear

