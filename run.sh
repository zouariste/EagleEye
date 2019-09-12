#! bin/bash



cd EagleEyeLogin
mvn spring-boot:run &
cd ..

cd EagleEyeRequest
mvn spring-boot:run &
cd ..

cd EagleEyeSignup
mvn spring-boot:run &
cd ..

cd EagleEyeBusiness
mvn spring-boot:run &
cd ..

