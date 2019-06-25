FROM java:8

EXPOSE 8081

WORKDIR /app
ADD ./build/libs/Parcelsize-0.1.jar Parcelsize-0.1.jar
#CMD ["java", "-jar", "Parcelsize-0.1.jar"]
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","Parcelsize-0.1.jar"]
