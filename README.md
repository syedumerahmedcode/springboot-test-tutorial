# springboot-test-tutorial

## Table of content
- [Introduction](#introduction)
- [Out Of Scope](#out-of-scope)
- [Explanation Junit5](#explanation-junit5)
- [Explanation Junit Platform](#explanation-junit-platform)
- [Explanation Junit Jupiter](#explanation-junit-jupiter)
- [Explanation Junit Vintage](#explanation-junit-vintage)
- [Explanation AssertJ](#explanation-assertj)
- [Explanation DataJpaTest](#explanation-datajpatest)
- [Explanation parameterized tests](#explanation-parameterized-tests)
- [Explanation Mockito](#explanation-mockito)
- [Explanation Junit5](#explanation-junit5)
- [Explanation WebMvcTest](#explanation-webmvctest)
- [Explanation SpringBootTest](#explanation-springboottest)
- [Explanation JsonTest](#explanation-jsontest)
- [Explanation MockWebServer](#explanation-mockwebserver)
- [Technologies Used](#technologies-used)
- [Prerequisities](#prerequisities)
- [Commands](#commands)
- [Contribution](#contribution)
- [References](#references)
- [Contact Information](#contact-information)


## Introduction

The aim of this project is to show case the different ways in which a spring boot application can be tested. This project is supposed to be a cook book for writing tests and hence contains various types of unit tests as well as some integration tests. 

For this project, a simple student application is realized containing a Student _Entity_ which stores the following:

- id
- name
- email
- gender(An _enum_ containing values MALE, FEMALE and OTHER)

We have a _Service_ which is used **addStudent()**, **deleteStudent** and **getAllStudents()**. This service is exposed to the outside world via a _Controller_.

All of this is tested via unit tests as well as (some) integration tests. 

## Out Of Scope

Some integration tests such as _@SpringBootTest_ are not part of this project as they proved too complex to implement and I was constantly running into problems while implementing them. 

If someone can help me out, please feel free to contact me on my email/social network (see below) or feel free to create a Pull Request.

Even though, these types of integration tests are not implemented, it is worthwhile to explain them and hence, there are dedicated sections to its explanation in this readme.

## Explanation Junit5

- To be defined.

## Explanation Junit Platform

- To be defined.

## Explanation Junit Jupiter

- To be defined.

## Explanation Junit Vintage

- To be defined.

## Explanation AssertJ

- To be defined.

## Explanation DataJpaTest

- To be defined.

## Explanation parameterized tests

- To be defined.

## Explanation Mockito

- To be defined.

## Explanation WebMvcTest

- To be defined.

## Explanation SpringBootTest

- To be defined.

## Explanation JsonTest

- To be defined.

## Explanation MockWebServer

- To be defined.

## Technologies Used

- Java 11
- [SpringBoot](https://start.spring.io/): Used to create easy stand-alone, production-grade Spring based Applications.
- [Maven](https://maven.apache.org/): Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.
- [H2 Database Engine](https://www.h2database.com/html/main.html): Embedded relational database.
- [Junit5](https://junit.org/junit5/docs/current/user-guide/): Junit5 is the 5th version of Junit library which is used for writing tests.


## Prerequisities

For the project to run successfully, Java and Maven must be configured on the machine.

## Commands

To run the project, navigate to the project folder(where pom.xml is located) and execute the following command: 

```bash
mvn clean install
```

## Contribution

Feature requests, issues, pull requests and questions are welcome. Especially, if someone can create a Pull Request for Integration Tests, that would be splendid.

## References

- [1](https://www.youtube.com/watch?v=Geq60OVyBPg): Software Testing Tutorial - Learn Unit Testing and Integration Testing **(YouTube) (Primary Resource)**
- [2](https://junit.org/junit5/): JUnit 5 User Guide **(Official Website)**
- [3](https://www.arhohuttunen.com/spring-boot-webmvctest/): Testing Web Controllers With Spring Boot @WebMvcTest
- [4](https://www.arhohuttunen.com/spring-boot-datajpatest/): Testing the Persistence Layer With Spring Boot @DataJpaTest
- [5](https://github.com/arhohuttunen/spring-boot-test-examples): spring-boot-test-examples **(GitHub)**
- [6](https://stackoverflow.com/questions/25614593/asserting-array-of-arrays-with-jsonpath-and-spring-mvc): Asserting array of arrays with JSONPath and spring mvc **(Stack Overflow)**

## Contact Information

How to reach me? At [github specific gmail account](mailto:syedumerahmedcode@gmail.com?subject=%5BGitHub%5D%20Hello%20from%20Github). Additionally, you can reach me via [Linkedin](https://www.linkedin.com/in/syed-umer-ahmed-a346a746/) or at [Xing](https://www.xing.com/profile/SyedUmer_Ahmed/cv)

TODO:

- Write some notes on Junit5. 
- Define Junit Platform
- Define Junit Jupiter
- Define Junit Vintage
- Add a small note on AssertJ
- Write a small note on @DataJpaTest in your own words.

@DataJpaTest glues the H2 database (defined in application.properties of test package) with the StudentRepositoryTest class. Due to this association, we can test the repository interface.

- Add a note on parameterized tests.
- Add a note on Mockito in my own words which we are using in Service.

Why do we use Mock? Because we have already tested StudentRepository class. Hence. we know for a fact that the Repository works. Now, when testing Service class, we do not need to populate the repository with test data again(as we have already done it before). So, we use Mocking. 

- In order to avoid initialization and closing of `autoClosable`, one can also use `@ExtendWith(MockitoExtension.class)`.
- Write a small note on ArgumentCaptor. Describe how ArgumentCaptor is used to verify inputs.

