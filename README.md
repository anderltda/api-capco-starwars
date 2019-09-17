Para executar a api siga os seguintes passos:
=======================

### Banco Oracle 12c ou MYSQL

1. Instale o banco oracle 12c ou Mysql. Devido a incompatibilidade do Flyway Community com a versão oracle 11g, utilizei 12c
2. Então efetue a configuração no application.properties

       spring.datasource.url= jdbc:oracle:thin:@//localhost:1521/orcl
       spring.datasource.username=SYS
       spring.datasource.password=root
       
       spring.datasource.url= jdbc:mysql://localhost:3306/docker
       spring.datasource.username=root
       spring.datasource.password=root       

### Aplicação

1. Abra um terminal window/command prompt
2. Clona o projeto.
3. `cd api-capco-starwars` 
4. `mvn clean install`

Todas as dependências devem ser baixadas 

### O que devo fazer?

- Após o build do projeto, já estará apto para roda a api.
- Mas antes, siga os seguintes passos:

1. Abra o diretorio target
2. Execute o seguinte comando

        java -jar api-capco-starwars-1.0.0.jar
        
3. Abra o browser
4. Abra o link do swagger

- `http://localhost:8080/swagger-ui.html`


