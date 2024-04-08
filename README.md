# Projeto Spring Boot

Este é um projeto Spring Boot que inclui operações CRUD, migrations e configuração de anotações.

## Progresso Atual

- [x] GET - Implementado
- [x] POST - Implementado
- [ ] PUT - Pendente
- [ ] DELETE - Pendente
- [x] Migrations - Implementado
- [ ] Exception Handler - Pendente

## Anotações do Spring

As anotações são essenciais para definir o comportamento do aplicativo Spring de forma declarativa. Aqui estão algumas das anotações utilizadas:

- `@RestController`: Define uma classe como controller no padrão MVC.
- `@RequestMapping`: Mapeia URLs para métodos do controlador.
- `@Autowired`: Injeta dependências automaticamente.
- `@Component`: Marca uma classe como componente do Spring.
- `@Service`: Indica que uma classe serve como serviço no Spring.
- `@RestControllerAdvice`: Trata exceções lançadas por controladores REST.

### Parâmetros dos Métodos do Controller

- `@PathVariable`: Captura variáveis da URL.
- `@RequestBody`: Captura o corpo da requisição.

## Configuração do Banco de Dados

Adicione as configurações do banco de dados no arquivo `application.properties`:

```properties
spring.datasource.url=URL_DO_SEU_DB
spring.datasource.username=USUARIO
spring.datasource.password=SENHA
```

## Entidades JPA
As entidades representam tabelas do banco de dados. Por exemplo, a entidade User pode ser definida como:
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Outros campos e métodos
}

## Repositórios
Os repositórios são interfaces que estendem JpaRepository, permitindo operações de persistência:
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
    List<User> findAllByActiveTrue();
}

## Migrations
Utilizamos migrations para gerenciar alterações na estrutura do banco de dados:
-- V2__create-table-users.sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(255) NOT NULL,
    active BOOLEAN
);
Para mais informações sobre como configurar e utilizar migrations, consulte a documentação do Flyway.
Este README oferece uma visão geral do projeto. Para mais detalhes, consulte a documentação do Spring Boot e do Spring Data JPA.
