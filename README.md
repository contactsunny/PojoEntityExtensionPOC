# POJO Entity Extension POC

This is a simple project to demo how we can keep our POJO classes different from the entity classes. We can have the generic
POJO classes as the domain classes, and we can extend these domain classes in the entity classes. Only the entity classes
will have the database-specific annotation. This way, we can keep all the behaviour we need in the domain classes.

## Configuration

Change MongoDB connection configuration in the ```resources/application.properties``` file. The property is ```spring.data.mongodb.uri```. An example:

```
spring.data.mongodb.uri=mongodb://localhost:27017/test
``` 

## How to run

After cloning the repository, ```cd``` into the project directory and run the following command to build the project:

```shell script
mvn clean install
```

This command will create a new directory called ```target/``` and will place the ```.jar``` file inside this directory.
Then, to run the project, run the following command:

```shell script
java -jar target/PojoEntityExtensionPOC-1.0-SNAPSHOT.jar
```