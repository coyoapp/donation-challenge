FROM 667420079654.dkr.ecr.eu-central-1.amazonaws.com/jdk:13
ADD build/libs/application.jar /
CMD ["java","-jar", "/application.jar"]
