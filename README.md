# AUTHENTICATION-SYSTEM

Project in Spring Boot and MVC to sign in and sign up an user using the authentication first factor mechanism.


## Status CI Integration
 
[] TODO in CircleCI

## Getting started

### Prerequisites

* Java 1.8 or more
* IDE or text editor
* Maven 
* MariaDB database

### Installing

* Clone the project with _git-clone_ (or download directly it)
* Have fun!


## Running the tests

* Run _mvn test_

### Break down into to end to end tests


* Go to _http://localhost:8080/_;
* Appear the signin page: you can signin an existing user (alex/io);
* Click the _submit_ button. You will see the page of the correct signin;
* Go back
* Appear the signin page: click the link to _signup_ page;
* Fill in the fom and click the _signup_ button. You will see the page of the correct signin;
* Verify in database the sensitive encrypt data of the users
* Verify in console and file logs the sensitive encrypt data of the users


### Coding styles sheets

* Please read the file [CONTRIBUTING.md](http://github.com/alepuzio/authentication-system/CONTRIBUTING.md)

## Deployment
* Run the database script in _src/main/resources/_ in MariaDB in correct order. 
* You have the new database, 1 table and 1 recorded user
* Run the command _mvn spring-boot:run -X -e_ or _java -jar target/auth-sys.jar_ ;

### Built with:

* [Eclipse](http://www.eclipse.org) - most famous IDE for Java programming language
* [Maven](http://www.maven.org) - tool to create artifacts of the project
* [JUnit](http://www.junit.org) - most famous library about the unit testing
* [Spring Boot](https://spring.io/projects/spring-boot) - Spring library to run stand-alone application
* [Spring MVC](https://spring.io/projects/spring-mvc) - Spring library to run web application


## Contributing

* Please read the [Contributing.md](http://github.com/alepuzio/authentication-system/CONTRIBUTING.md) for the details about the code of conduct and the process for submitting pull requests.

## Versioning

* We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/alepuzio/authentication-system/tags). 

## Authors

* **Alessandro Puzielli** - *creator* - [Alepuzio](https://github.com/alepuzio)
* See also the list of [contributors](https://github.com/alepuzio/authentication-system/graphs/contributor) in this project.

## License

* This project is licensed under the BSD License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* **PurpleBooth** - to publish an [excellent template](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2) of README that I used in this project 
* **Yegor256** - to write the post [Elegant READMEs](https://www.yegor256.com/2019/04/23/elegant-readme.html) about the README file and the [An Open Code Base Is Not Yet an Open Source Project](https://www.yegor256.com/2018/05/08/open-source-attributes.html) for the Open Source projects

