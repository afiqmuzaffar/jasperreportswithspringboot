# jasperreportswithspringboot
A demo for using jasper within a Spring Boot App I made for a Jasper session.

This depicts integration of jasper reports within a spring boot app .

Mostly uses concept of JasperReportsViewResolver as defined here http://stackoverflow.com/questions/27532446/how-to-use-jasperreports-with-spring-mvc
[Check the answer with the tick there :)]

Also the report included using my custom db and data so try putting your own .jrxml report there before trying to run.

`The jasper endpoints shall be like http://localhost:8080/report/{reportname}?format={format}&id={id} (id param are optional,you can add ur custom report params there)`


Cheers!

_Gaurav_
Data:
Example data from http://sourceforge.net/p/jasperreports/code/ci/jr-6-3-1/tree/jasperreports/demo/samples/csvdatasource/

Restore data:
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

copy example(place,age,name,address,status) FROM '/tmp/users.txt' with csv DELIMITER ','  quote '"' ;
