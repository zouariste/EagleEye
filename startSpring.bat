cd "EagleEyeLogin"
start /b mvn spring-boot:run

cd ..
cd EagleEyeRequest
start /b mvn spring-boot:run

cd ..
cd EagleEyeBusiness
start /b mvn spring-boot:run

cd ..
cd EagleEyeSignup
start /b mvn spring-boot:run

pause


