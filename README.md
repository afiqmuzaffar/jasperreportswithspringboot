# jasperreportswithspringboot
A demo for using jasper within a Spring Boot App I made for a Jasper session.

This depicts integration of jasper reports within a spring boot app .

Mostly uses concept of JasperReportsViewResolver as defined here http://stackoverflow.com/questions/27532446/how-to-use-jasperreports-with-spring-mvc
[Check the answer with the tick there :)]

Also the report included using my custom db and data so try putting your own .jrxml report there before trying to run.

Run

```bash
mvn clean spring-boot:run
```

Package and Run

```bash
mvn clean package && java -jar target/jasperreportswithboot-0.0.1-SNAPSHOT.jar
```
`The jasper endpoints shall be like http://localhost:8080/report/{reportname}?format={format}&id={id} (id param are optional,you can add ur custom report params there)`

Example:
```bash
curl "http://localhost:8080/report?name=rpt_all&format=pdf&id=1"
```

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
