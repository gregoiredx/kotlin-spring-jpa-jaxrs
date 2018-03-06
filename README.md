# kotlin-spring-jpa-jaxrs

./mvnw spring-boot:run

firefox http://localhost:8080/hello?name=Joe

curl -i -u"user:53a23e9f-afc0-44cc-9309-dd06e83cf101" http://localhost:8080/users

curl -i -u"user:53a23e9f-afc0-44cc-9309-dd06e83cf101" http://localhost:8080/users -d "email=joe@exemple.com"

curl -i -u"user:53a23e9f-afc0-44cc-9309-dd06e83cf101" http://localhost:8080/users/ecb2db50-a43a-4ba9-abd7-bc20a893c768
