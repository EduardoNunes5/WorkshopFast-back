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

# SEGURANÇA

Ao iniciar a aplicação, é criado um usuario de nível administrador com os campos:  
username: admin  
password: 123  

As chaves pública e privadas estão submetidas no github a criterio de desenvolvimento, em um repositório real, tais dados não devem ficar expostos.  

endpoints de autenticação e cadastro:  
`POST /api/auth/login`
```json
{
   "username": "admin",
   "password": "123"
}
```

Response:
```json
{
   "accessToken": "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJGYXN0LXNvbHVjb2VzIiwic3ViIjoiMSIsImV4cCI6MTc2MjE4NDQ2MSwiaWF0IjoxNzYyMTgzODYxLCJzY29wZSI6IkFETUlOSVNUUkFUT1IifQ.WHp-frBiYqOV1M86UPVOFnDHL3-TLBktU4nG-f2qikK9VDqNvrkT204pXIXOSrZAHBkvAtgjPjN4I8Ozt6bIdY449zCRt2qpp7H1mZMdsUhKThHJzjo_V4dN40Tbv84NA5TGCj2Gw_-TVT98p0PQFdgNKEs_UzJBuDEOr1Xa25AIwKDy54XreG5vtJV82iNbRlwFDLWbzi7b74kVfRUyYaiD3rF6BiQ2vAbvLT9QUGq-iIEEfk8bkIogrf_Q7uW42JWGiTcJbV3B7AGZ2SbBXD5DGp9T6Fxnv1NMkr1dWr3kcu9L4UAq4dObqALYGeOyy7q4mbGP96n22CDYtRY8cQ",
   "expiresInSeconds": 600
}

```
tokens são válidos por 10 minutos


`POST /api/usuarios`
```json
{
   "username": "admin",
   "password": "123"
}
```

Essas são as ÚNICAS rotas que o usuário pode acessar sem estar autenticado.  

Foi implementada a autorização: apenas ADMINISTRADORES podem criar ATAS e WORKSHOPS.