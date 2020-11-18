# DRAVSSOR REPUTATION MONITORING EagleEye

We've moved the properties settings to an external configuration server using the Spring Cloud Config package.
To run the project:
1. sh run0.sh to run the configuration server.
2. docker-compose up
3. sh run.sh to run the spring microservices.
4. python3 PythonServices/VisualizationService.py

The branch is using a docker engine on 127.0.0.1

