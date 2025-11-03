# Workshop Fast

## O Projeto Projeto

O Workshop fast é uma api rest para auxiliar na gestão de eventos de workshops da empresa Fast.  
Funcionalidades:
- Cadastro de workshops
- Cadastro de colaboradores
- Cadastro de ata de presença para workshops
- Adicionar colaboradores a workshops através de ATAS de presença
- Remover colaboradores das atas de presença de workhops
- listagem de dados relacionados a workshop, colaboradores e atas

## Ferramentas (requisitos)


A aplicação foi desenvolvida usando Java 21 com o gerenciador de dependencias maven.

* Instale o OpenJDK 21 Caso ainda não tenha.
* Instale MySQL 8.x ou execute uma imagem docker caso deseje utilizar o MySQL como banco de dados
   * `docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=workshop_fast -e MYSQL_USER=db_user -e MYSQL_PASSWORD=123456 mysql`

# O projeto

O projeto foi implementado seguindo a arquitetura em camadas, foi feito o uso de DTOS para isolar o modelo de domínio do ambiente externo


Tecnologias utilizadas:
- Java 21
- MySQL 8.X
- Spring Boot (3.X)
   - web mvc
   - validation
   - jpa
- Swagger api


Executando a aplicação:  

Clone o repositório.

Existe um arquivo de seed chamado `data.sql` na pasta `src/resources` responsável por inserir colaboradores e workshops no banco de dados. 
Se desejar, pode comentar os inserts.  

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

# Segurança

Implementei a segurança da aplicação na branch:
* Feature/security
* existe uma PR para ela:
* https://github.com/EduardoNunes5/WorkshopFast-back/pull/15

Documentação Swagger acessível através da rota:

http://localhost:8080/api-docs/swagger-ui/index.html
