
# build spring boot application base on staging yml
# mvn clean package -DskipTests -Pdev

# # go to target folder
# cd target

# # run spring boot application
# java -jar happygear-0.0.1-SNAPSHOT.jar

mvn spring-boot:run -Dspring-boot.run.profiles=dev
