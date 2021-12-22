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

- To be defined.

## Out Of Scope

- To be defined.

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

- To be defined.

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

- To be defined.

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


References:

- https://junit.org/junit5/
- https://www.youtube.com/watch?v=Geq60OVyBPg&t=635s **(YouTube)**
- https://www.arhohuttunen.com/spring-boot-webmvctest/ (Description of @WebMvcTest)
- https://www.arhohuttunen.com/spring-boot-datajpatest/ (Testing the Persistence Layer With Spring Boot @DataJpaTest)
- https://github.com/arhohuttunen/spring-boot-test-examples (A very good resource for quick reference for annotations about testing)
- https://stackoverflow.com/questions/25614593/asserting-array-of-arrays-with-jsonpath-and-spring-mvc

Timestamp: 59:43