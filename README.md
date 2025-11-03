A aplicação foi desenvolvida usando Java 21 com o gerenciador de dependencias maven.

* Instale o OpenJDK 21 Caso ainda não tenha.
* Instale MySQL 8.x ou execute uma imagem docker caso deseje utilizar o MySQL como banco de dados
  * `docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=workshop_fast -e MYSQL_USER=db_user -e MYSQL_PASSWORD=123456 mysql`



Executando a apliacação:  

Clone o repositório.

(MySQL):

1. No arquivo application-dev.properties em: src/main/resources 
   2. substitua os valores das variáveis referentes ao banco de dados (caso tenha instalado o mysql manualmente)
      - spring.datasource.url=jdbc:mysql://localhost:3306/workshop_fast
      - spring.datasource.username=workshop-db
      - spring.datasource.password=123456
3. Execute a aplicação


(H2):
1. No arquivo application.properties em: src/main/resources
   2. substitua o valor da variável `spring.profiles.active=dev` por `spring.profiles.active=test`
3. Execute a aplicação


Documentação Swagger acessível através da rota:

http://localhost:8080/api-docs/swagger-ui/index.html
