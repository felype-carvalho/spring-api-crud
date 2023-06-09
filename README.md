# CRUD Spring API
 
<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Summary</summary>
  <ol>
    <li>
      <a href="#about-the-project">About the Project</a>
      <ul>
        <li><a href="#build-with">Build With</a></li>
        <li><a href="#visual">Visual</a></li>
      </ul>
    </li>
    <li>
      <a href="#how-to-use">How to use</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation-via-terminal">Installation via Terminal</a></li>
        <li><a href="#installation-via-ide">Installation via IDE</a></li>
        <li><a href="#documentation">Documentation</a></li>
      </ul>
    </li>
    <li><a href="#license">License</a></li>
  </ol>
</details>
<br>

<!-- ABOUT THE PROJECT -->
## About the project

<p>The project is a REST API with CRUD functionality for the person and address objects. Where the relationship works like many addresses for one person.</p>
<div align="center">
 <img src="https://user-images.githubusercontent.com/43687521/238427771-82a00080-909f-487b-826e-e30a55e6a4a3.png">
</div>
<p>The API also has validation for duplicate email and CPF and use H2 Database was used for data persistence.</p>
<br>

<!-- BUILD WITH -->
### Build With
The technologies used in this project were:
* [Java](https://docs.oracle.com/en/java/)
* [Spring Framework](https://docs.spring.io/spring-framework/docs/current/javadoc-api/index.html)
* [Spring JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
* [Lombok](https://projectlombok.org/features/)
* [H2 Database](https://www.h2database.com/html/quickstart.html)
* [Swagger](https://swagger.io/docs/)
<br>

<!-- VISUAL -->
### Visual
<div align="center">
 <img src="https://github.com/felype-carvalho/spring-api-crud/assets/43687521/daa0ba0b-1aa2-4d79-aeff-c8c82825c46e">
</div>
<div align="center">
 <img src="https://github.com/felype-carvalho/spring-api-crud/assets/43687521/329f64ab-ef66-40b7-8ae6-b1e7465284da">
</div>
<br>

<!-- HOW TO USE -->
## How to Use

### Prerequisites
``` JDK 17, Maven and Git ```

<br>

### Installation via terminal

1- Clone this repository.
``` 
git clone https://github.com/felype-carvalho/spring-api-crud.git
```

2- Access the project folder in your terminal/cmd.
``` 
cd spring-api-crud/crud-spring-api
```

3- Run the application with Maven.
```
mvn spring-boot:run
```

4- Open ```http://localhost:8080/``` in the browser and watch the project run.

<br>

### Installation via IDE
This installation method works without installing Maven.

1- Clone this repository.
``` 
git clone https://github.com/felype-carvalho/spring-api-crud.git
```

2- Access the project folder in your Java IDE.

3- Run CrudSpringApiApplication.java file.

4- Open ```http://localhost:8080/``` in the browser and watch the project run.

<br>

### Documentation

This project was created using Swagger to generate the API documentation. With the project running, you can access the documentation at the links below:
```
http://localhost:8080/swagger-ui/index.html
```
```
http://localhost:8080/swagger-ui
```

 
<!-- LICENSE -->
## License

Distributed under the MIT license. See `LICENSE` for more information.
