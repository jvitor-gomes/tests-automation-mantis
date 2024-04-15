# Testes Mantis

## Automação de testes do Mantis utilizando Selenium Web Driver com Java.

Para executar o projeto, é necessário configurar o ChromeDriver.

Ele está localizado na pasta 'driver' deste projeto, no seguinte diretório: `driver\chromedriver.exe`. Certifique-se de que o navegador Google Chrome está na versão 123.

Indique o caminho para o ChromeDriver no método de conexão `initChromeDriver`, que está na classe BrowserFactory. O diretório da classe é: testes-automatizados-mantis\src\test\java\br\com\mantis\e2e\BrowserFactory.java


## Arquitetura do projeto:

- mantis-selenium-master [mantis]
    - .idea
    - src
        - driver
            - chromedriver.exe
    - test
        - java
            - br.com.mantis.e2e
                - pages
                    - CriarTarefaPage
                    - LoginPage
                    - MinhaVisaoPage
                    - VerTarefasPage
                - tests
                    - BaseTestsE2E
                    - CriarTarefaTestsE2E
                    - LoginTestsE2E
                    - VerTarefasTestE2E
        - Browser
        - BrowserFactory
    - .gitignore
    - pom.xml

### Uma descrição detalhada da arquitetura:

testes-automatizados-mantis: Este é o projeto principal.

src/driver/chromedriver.exe: Este é o driver do navegador Chrome usado para executar os testes.

test/java/br.com.mantis.e2e/pages: Esta pasta contém páginas da web que estão sendo testadas.

test/java/br.com.mantis.e2e/tests: Esta pasta contém os casos de teste.

BrowserFactory: Classe de instanciação e gerenciamento do navegador durante os testes.

pom.xml: Este arquivo indica que este é um projeto Maven com dependências e configurações especificadas.
