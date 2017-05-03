# Demo for using jasper within a Spring Boot App

This depicts integration of jasper reports within a spring boot app .

Mostly uses concept of JasperReportsViewResolver as defined here http://stackoverflow.com/questions/27532446/how-to-use-jasperreports-with-spring-mvc


## Run App

```bash
mvn package && java -jar target/jasperreportswithboot-0.0.1-SNAPSHOT.jar
```

## Spring Boot with Docker

Example from https://spring.io/guides/gs/spring-boot-docker/
- Package MUST be run before docker:build. Otherwise, it will fail.

```bash
mvn package docker:build -DpushImage
docker run -p 8080:8080 -t springio/jasperreportswithboot

# Using Spring Profiles
docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 -t springio/jasperreportswithboot

# Debugging the application in a Docker container
docker run -e "JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" -p 8080:8080 -p 5005:5005 -t springio/jasperreportswithboot
```

## Data

Example data from http://sourceforge.net/p/jasperreports/code/ci/jr-6-3-1/tree/jasperreports/demo/samples/csvdatasource/

Restore data:
=======
## Data

Example data from http://sourceforge.net/p/jasperreports/code/ci/jr-6-3-1/tree/jasperreports/demo/samples/csvdatasource/

Restore data to a postgresql database:

```sql
CREATE TABLE example
(
  id serial NOT NULL,
  place text,
  age integer,
  name text,
  address text,
  status text,
  CONSTRAINT example_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

ALTER TABLE example  OWNER TO test;

copy example(place,age,name,address,status) FROM '/tmp/users.txt' with csv DELIMITER ','  quote '"' ;
```


## Execution

Running spring boot:

```bash
mvn clean spring-boot:run
```


Package and Run:

```bash
mvn clean package && java -jar target/jasperreportswithboot-0.0.1-SNAPSHOT.jar
```


The jasper endpoints shall be like http://localhost:8080/report/name={report_name}&format={format}&id={id}
Notes:
* id param are optional,you can add ur custom report params there
* allowed formats: pdf, xls, html, csv

Example:
```bash
## All records
curl "http://localhost:8080/report?name=rpt_all&format=pdf"

## Single records
curl "http://localhost:8080/report?name=rpt_detail&format=pdf&id=1"

```
>>>>>>> 7700fe938acf3d8648f9a38e92c977d540d4efa8
