# ArticleStore
RESTful web services exposing CRUD endpoints for article(books) resources.
## Web Service
Offers the following endpoints for Article Resource access:
    GET single article at `http://127.0.0.1:8080/user/article/{id}`
    GET all articles at `http://127.0.0.1:8080/user/articles`
    POST an article at `http://127.0.0.1:8080/users/article`
    PUT an article at `http://127.0.0.1:8080/users/article`

!Screenshot 2025-09-02 at 15.26.18.png
## Setup
It uses springboot with maven for packaging, build and running.
(Recommended) git clone <repo_url> to your local branch or pull with IDE supporting Git plugins.
Create a `mvn test`, `mvn package`, `mvn spring-boot:run` on Run Configurations such that they can be just a button click on your IDE.

### Running
From the run configurations created you can easily run your project.
