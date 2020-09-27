# pcasystem
API REST Protótipo de sistema com o objetivo de gerenciar os recursos hospitalares em meio a pandemia para hospitais com alta carga de ocupação. 

## Stack Ultilizada

- Spring Boot, Java , hibernate, JPA

### Descriçes dos serviços dos Hospitais
- GET / HOSPITAL /
    - Retorna uma Lista de Hospitais cadastrados no banco de dados
    
- POST  / HOSPITAL / 
    - Cria um novo hospital passando as informaçoes via JSON no endpoint / hospital.
    
- GET / HOSPITAL / {id}
    - Retorna uma hospital pelo ID
    
- PUT / HOSPITAL / {id}
    - Atualiza as porcentagens da ocupação dos hospitais, retorna tudo Mas so atualiza a Ocupação
    
- DELETE / HOSPITAL /
   - Não Implementado



### Descriçes dos serviços de gerenciamentos dos recursos hospitalares.
- GET / RECURSOS /
    - Retorna uma lista de recursos
    
- GET  / RECURSOS / {id}
    - Retorna recursos pelo ID.
    
- GET / RECURSOS / SOLICITAR /
    - Retorna uma lista com as informaçoes dos hospitais para uma analise de solicitação.
    
- GET / RECURSOS / SOLICITAR / {id}
    - Retorna informaçoes do hospital para uma analise de envio. ao Mudar pra Post, enviar parametros para a troca de Recursos!
    
- POST / RECURSOS / SOLICITAR / {id}
   - Solicita Recursos passando um MAP como parametro. obs: 'parahospital' é obrigatorio. Verificarar pontos conforme Tabela.
      - parametros passados pelo Map, onde os parametros sem o 'enviar' e com o 'enviar' sera feita uma troca de recursos por determinados pontos.
      - medico=2&enfermeiro=2&respirador=2&ambulancia=2&tomografo=2&parahospital=2&enviar_medico=2&enviar_enfermeiro=2&enviar_respirador=2&enviar_tomografo=2&enviar_ambulancia=2'



### Descriçes dos serviços de relatorios, recursos e dados sobre ocupações.
- GET / RELATORIO /
    - Retorna uma Lista de Hospitais cadastrados no banco de dados
    
- GET  / RELATORIO / {id}
    - Cria um novo hospital passando as informaçoes via JSON no endpoint / hospital.
    
- GET / RELATORIO / MAIOROCUPACAO
    - Retornar uma lista de hospitais com o numero de ocupação maior que 90%.
    
- GET / RELATORIO / MENOROCUPACAO
    - Retornar uma lista de hospitais com o numero de ocupação menor que 90%.
    
- GET / RELATORIO / MEDIARECURSOS
   - Retornar a Media dos recursos dos Hospitais.

- GET / RELATORIO / SUPERLOTACAOMAIOR
   - Retornar uma lista de hospitais com o numero de ocupação maior que 90% a mais tempo.
   
 - GET / RELATORIO / SUPERLOTACAOMENOR
   - Retornar uma lista de hospitais com o numero de ocupação maior que 90% a menos tempo.



## Erros ao Executar.

### Precisa ficar atento as modificaçoes nos arquivos de configuração do SpringBoot.
- Verificar application.properties
    - Uso linux, puder o caminho do banco de dados. Usei o H2 . mais informações acessa https://www.h2database.com/html/main.html
- Porta de Execução do TomCat
   - atualmente uso a 8080, caso der erro ou algum conflito na execução, verifica a porta de conexão.
- Teste requisição no postman.
   - A maioria dos teste de requisições HTTP fora feitas usando o postman. Erros nos caminhos dos serviçoes podem ocorrer.
- Versões Spring Boot + dependencias usadas.
   - Verificar POM.XML
   
## Documentação

- http://localhost:8080/swagger-ui.html
    - Uma visualização mais intuitiva
    
- http://localhost:8080/v2/api-docs 
    - visualização em formato JSON, recomendo usar o POSTMAN para a melhor visualização


## Os "porquês"

Linguagem utiliza, JAVA!!! 

“JAVA ONTEM, JAVA HOJE, JAVA SEMPRE!!” 
“James Gosling ,  1995”

A stack utilizada foi o Spring boot e seu ecossistema, ele além de ser rápida a implementação de dependências com o mavem que precisamos no projeto , ele já vem com várias ferramentas e notações pré prontas para serem usada e uma gigantesca produtividade nas questões de persistências de dados. 

Utilizei o H2 Database que teve uma sinergia épica com o spring boot,ele é simples e fácil para o uso, para prototipagem é uma excelente opção.
Cogitei em usar Postgres, um Banco de dados que já tenho um apego emocional pelo Elefantinho, mas para o que foi proposto acredito que o h2 resolva. na verdade, ele resolve tudo. :3

Todo o gerenciamento de Erros e Exceções foi tirada de um antigo estudo sobre exceções JAVA, onde até ontem era meu maior pesadelo nas aplicações Rest API, Hoje eu só faço rir, HA! HA! HA!, dos erros que acontecem nas aplicações, pois sei tratar a MAIORIA eles. 

Para a Documentação utilizei o maravilhoso SWAGGER como uma das dependências do Spring Boot, ele serve para da uma documentada mais elegantes nas suas aplicações REST API.
Como Utilizei a versão mais recente de tudo que usei, o SWAGGER deu uns conflitos de versões, então para aqueles que querem usar com o spring boot, dá uma olhadinha no POM.XML e ver as versões. 

Por fim o aprendizagem foi grande, Hoje sou alguém mais inteligente do que fui ontem.
Como dizia meu antigo e grandíssimo ex gestor Ronaldo Mousinho;

#### “Quem tem medo de ‘PAPA FIGO’ é menino!!!”

As metas foram cumpridas.
Problemas nos sistemas sempre irão surgir e surgirão nos sistemas sempre problemas.

### “UM BUG DE CADA VEZ”

##### “Cassio David, 2021”

### Deus abençoe nós tods. 

#### :bowtie: Amo Vcs seus lindos :revolving_hearts:
