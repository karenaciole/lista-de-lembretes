# Lista de Lembretes 
## Desafio técnico - DTI 


<table> <tr><th>Tecnologias usadas </th><th>Tecnologias usadas</th></tr>
<tr><td>

|Front-end|Back-end|
| --- | --- |
|Vanilla JS| Java |
|HTML5| Spring Boot|
|CSS | - |
</td><td>


|Testes Front-end| Testes Back-end|
| --- | --- |
| Jest | JUnit| 
|      | Mockito|

</td></tr></table>

### Features
✅ Criar um lembrete em uma data posterior ao dia atual 

✅ Listar todos os lembretes separados por data 

✅ Apagar um lembrete da lista por meio de um botão

### Decisões de projeto
<strong>Backend:</strong>
  Foi utilizado o esquema por camadas dividido por: Modelo, Repositório (sem banco de dados), Serviço e Controlador. Seguindo o padrão de REST API. 
 
 <strong>Frontend:</strong> A estrutura de pastas seguidas foi na pasta 'src': pasta 'api' para requisições ao backend; pasta 'styles' todo a estilização feita em css, e no root da pasta o arquivo index.html para renderizar a página. 
 
 ### Instruções para executar o projeto
 1. Clone o projeto
 2. No root do projeto, rode o backend com o comando: `cd backend && ./mvnw install && ./mvnw spring-boot:run`
 3. Em outro terminal, também no root do projeto, rode o frontend com o comando: `cd frontend && npm install && http-server ./`
 4. No navegador, o server estará disponível em `http://127.0.0.1:8080` ou `http://172.19.191.115:8080`
