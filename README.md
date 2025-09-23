# 🏍️ MotoTrack - Cloud

## 👥 Integrantes

- **Felipe Ulson Sora** – RM555462 – [@felipesora](https://github.com/felipesora)
- **Augusto Lope Lyra** – RM558209 – [@lopeslyra10](https://github.com/lopeslyra10)
- **Vinicius Ribeiro Nery Costa** – RM559165 – [@ViniciusRibeiroNery](https://github.com/ViniciusRibeiroNery)

## 📌 Sumário

- [📝 Descrição da Solução](#-descrição-da-solução)  
- [🗄️ Modelagem do Banco de Dados](#️-modelagem-do-banco-de-dados)  
- [🚀 Como Rodar o Projeto MotoTrack Completo](#-como-rodar-o-projeto-mototrack-completo)  
- [☁️ Detalhes do Projeto em Cloud](#️-detalhes-do-projeto-em-cloud)  
- [🚀 Como Fazer o Deploy em Cloud (Azure)](#️-como-fazer-o-deploy-em-cloud-azure)  
- [📹 Demonstração em Vídeo](#-demonstração-em-vídeo)  

## 📝 Descrição da Solução

O **MotoTrack** é um sistema completo desenvolvido para auxiliar empresas de aluguel de motos, como a Mottu, no **controle e monitoramento de sua frota**. 
A aplicação foi criada para resolver problemas comuns de gestão, como a desorganização nos pátios, dificuldade em localizar motos disponíveis ou em manutenção, 
e a falta de histórico rastreável de movimentações e serviços.

O sistema também oferece funcionalidades para **gerenciamento de serviços e manutenções**, vinculando cada atividade a um **colaborador responsável**
, além de permitir o **controle de estoque de peças**, garantindo reposição eficiente e visibilidade dos recursos da empresa.

### O sistema permite:
- 📝 **Cadastro e gestão de motos**;
- 🏢 **Organização por departamentos**, facilitando a localização de veículos;
- 🔄 **Controle de movimentações**, com histórico detalhado;
- 🛠️ **Gestão de serviços e manutenções**, vinculando responsáveis por cada atividade;
- 👨‍🔧 **Registro de colaboradores** envolvidos nos serviços;
- 📦 **Controle de estoque de peças**;
- 🚨 **Disparo de alertas** para acompanhamento do status das motos.

### Estrutura da Solução
O projeto foi dividido em múltiplos módulos para facilitar **escalabilidade e integração**, cada um com responsabilidades específicas:  

- ⚙️ **Backend REST em Java (Spring Boot)** – gerencia as entidades de **usuário, moto, movimentações e alertas**, utilizando **Spring Security com JWT** para autenticação e autorização.  
- 🖥️ **Backend MVC em Java (Spring MVC)** – oferece as mesmas entidades do backend REST Java, com um **frontend web bonito e funcional**, permitindo cadastro, edição, listagem e exclusão de dados diretamente pelo navegador. Possui **Spring Security** com validação de tipo de usuário (**Administrador** e **Comum**) para controlar o acesso às funcionalidades.
- 🧩 **Backend REST em .NET (ASP.NET Core)** – gerencia as entidades de **moto (somente leitura das tabelas criadas pelo Java), colaboradores, serviços e peças**, integrando funcionalidades complementares ao sistema.  
- 📱 **Frontend Mobile (React Native/Expo)** – consome ambas as APIs (Java e .NET) e disponibiliza **telas de cadastro, edição, exclusão e visualização** das funcionalidades, incluindo serviços, colaboradores e estoque de peças.  
- 🗄️ **Banco de Dados Oracle** – utilizado por todos os backends, com **criação automática de tabelas** ao iniciar os projetos.  

---

## 🗄️ Modelagem do Banco de Dados
Abaixo está a modelagem das tabelas utilizadas pelo sistema:  

![Modelagem Banco de Dados](docs/modelagem-moto-track.png)

---

## 🚀 Como Rodar o Projeto MotoTrack Completo

Para utilizar o **MotoTrack** de forma completa, é necessário rodar simultaneamente três módulos:

1. **⚙️ Backend API REST em Java (Spring Boot)** – fornece os endpoints REST para o sistema.
2. **🧩 Backend API REST em .NET (ASP.NET Core)** – fornece funcionalidades complementares via API.
3. **📱 Frontend Mobile (React Native/Expo)** – aplicação mobile que consome ambas as APIs e exibe todas as funcionalidades, incluindo serviços, colaboradores e estoque de peças.
>O **Backend MVC em Java (Spring MVC)** pode ser executado separadamente. Ele permite:
> - **📝 Login e cadastro de usuários;**
> - **🏍️ Cadastro, listagem, edição e exclusão de motos;**
> - **🔄 Cadastro, listagem e exclusão de movimentações e alertas.**

### 🛠️ Passo a Passo

1. Clone todos os repositórios:  
   - [API Rest Java](https://github.com/mototrack-challenge/mototrack-backend-rest-java)  
   - [API Rest .NET](https://github.com/mototrack-challenge/mototrack-backend-rest-dotnet)  
   - [Mobile](https://github.com/mototrack-challenge/mototrack-frontend-mobile)  
   - [MVC Java](https://github.com/mototrack-challenge/mototrack-backend-mvc-java)

2. 🔌 Configure as credenciais de conexão com o banco Oracle nos arquivos de configuração dos backends, se necessário.
    - ✅ O banco de dados e as tabelas serão **criados automaticamente** ao iniciar os backends (Java REST, Java MVC e .NET)

3. 🚀 Rode os backends
    - Java REST: `mvn spring-boot:run` ou rode pelo IDE favorito 
    - .NET REST: `dotnet run` ou abra no Visual Studio

4. 📱 Rode o frontend mobile:
    - Navegue até a pasta do projeto e execute `npm install` para instalar dependências  
    - Execute `npx expo start` para abrir o app no emulador ou dispositivo físico

> ⚠️ Dica: primeiro inicie os backends para que o mobile consiga se conectar às APIs corretamente

5. 🖥️ Para testar o **MVC Java**, basta executar o projeto normalmente; ele funciona isoladamente, sem depender dos outros módulos

---

## ☁️ Detalhes do Projeto em Cloud

O **MotoTrack Cloud** é a versão do projeto **MVC Java** implantada na nuvem utilizando os serviços da **Microsoft Azure**.  
O objetivo foi tornar a aplicação acessível de forma **remota e escalável**, garantindo alta disponibilidade e integração com um banco de dados em nuvem.

### 🛠️ Tecnologias e Serviços Utilizados
O deploy em cloud utilizou os seguintes recursos principais:  
- **Azure App Service** – hospedagem do projeto **Spring MVC Java**, permitindo escalabilidade automática e gerenciamento simplificado.  
- **Azure Database for PostgreSQL** – banco de dados relacional totalmente gerenciado na nuvem.  
- **Java 17** – versão utilizada na aplicação.  
- **Maven** – build e gerenciamento de dependências.  

### ⚙️ Estrutura do Deploy
- O **banco de dados local (Oracle)** foi substituído por um **PostgreSQL na Azure**, configurado com usuário, senha e acesso remoto.  
- O projeto **Spring MVC** foi empacotado como `.jar` e publicado no **Azure App Service**.  
- As **variáveis de ambiente** (URL do banco, usuário e senha) foram configuradas diretamente no **App Service**, garantindo segurança e portabilidade.  

### 📝 Funcionalidades Disponíveis na Nuvem
Na versão em cloud, o sistema mantém todas as funcionalidades do **MVC Java**:  
- ✅ Login e cadastro de usuários  
- 🏍️ Cadastro, edição, listagem e exclusão de motos  
- 🔄 Cadastro, listagem e exclusão de movimentações  
- 🚨 Cadastro, listagem e exclusão de alertas  
- 📊 Visualização de histórico e status das motos  

### 🌐 Acesso ao Sistema
Após o deploy, a aplicação ficou acessível por meio de uma **URL pública gerada pelo App Service**, permitindo que qualquer usuário autenticado consiga utilizar o sistema remotamente.  

### 📊 Benefícios da Arquitetura em Cloud
- 🌍 **Acesso remoto** de qualquer lugar  
- 📈 **Escalabilidade automática** via App Service  
- 🔒 **Segurança e gerenciamento** simplificados pela Azure  
- ⚡ **Alto desempenho** com banco de dados gerenciado (PostgreSQL)  

> ⚠️ O uso da **Azure** possibilitou experimentar na prática como funciona o deploy de uma aplicação corporativa em um ambiente real de **Cloud Computing**.
--- 

## ☁️ Como Fazer o Deploy em Cloud (Azure)

Para executar o **MotoTrack MVC Java em Cloud**, siga os passos abaixo:

### 1️⃣ Clonar o Repositório
Clone o projeto disponível no GitHub:
```bash
git clone https://github.com/mototrack-challenge/mototrack-cloud.git
cd mototrack-cloud
```

### 2️⃣ Preparar o Ambiente
- Instale o **Azure CLI**, caso ainda não tenha.
- Faça login na sua conta Azure:
```bash
az login
```

- Confirme se o login foi realizado corretamente:
```bash
az account show
```

### 3️⃣ Criar o Banco de Dados na Azure
1. Criar um **Resource Group**:
```bash
az group create --name MotoTrackRG --location brazilsouth
```

2. Criar um **servidor PostgreSQL**:
```bash
az postgres flexible-server create --resource-group MotoTrackRG --name mototrackdbserver --location brazilsouth --admin-user adminuser --admin-password "MotoTrack123!" --tier Burstable --sku-name standard_b1ms --storage-size 32 --version 15 --public-access All
```

3. Criar um **banco de dados** dentro do servidor:
```bash
az postgres flexible-server db create --resource-group MotoTrackRG --server-name mototrackdbserver --database-name mototrack
```

4. Obter a **URL do servidor**:
```bash
az postgres flexible-server show --resource-group MotoTrackRG --name mototrackdbserver --query "fullyQualifiedDomainName"
```

5. Conectar no banco via **pgAdmin4** (ou psql), usando a URL, usuário e senha.
      - Abra o banco `mototrack`
      - Execute o script SQL disponível no repositório: `script_bd.sql`

### 4️⃣ Criar o App Service
1. Gerar o `.jar` do projeto:
```bash
mvn clean package
```

2. Criar um **App Service Plan**:
```bash
az appservice plan create --name MotoTrackPlan --resource-group MotoTrackRG --sku B1 --is-linux
```

3. Criar o **App Service com JDK 17**:
```bash
az webapp create --resource-group MotoTrackRG --plan MotoTrackPlan --name mototrack-app --runtime "JAVA:17-java17"
```

4. Configurar as **variáveis de ambiente**:
```bash
az webapp config appsettings set --resource-group MotoTrackRG --name mototrack-app --settings DB_URL="jdbc:postgresql://mototrackdbserver.postgres.database.azure.com:5432/mototrack" DB_USER="adminuser" DB_PASSWORD="MotoTrack123!"
```

5. Fazer o **deploy da aplicação**:
```bash
az webapp deploy --resource-group MotoTrackRG --name mototrack-app --src-path target/mototrack-backend-java-0.0.1-SNAPSHOT.jar --type jar
```

### 🌐 Acessar a Aplicação

Após o deploy, a aplicação estará disponível publicamente em uma URL gerada pelo **App Service**, no formato:
```bash
https://mototrack-app123.azurewebsites.net
```

> ⚠️ Lembre-se: o banco de dados **PostgreSQL** precisa estar ativo e com as tabelas criadas (via script SQL) antes de rodar a aplicação em cloud.

--- 

## 📹 Demonstração em Vídeo

Para ver o **MotoTrack MVC Java** em funcionamento na **Azure**, assista ao vídeo abaixo, que mostra o **passo a passo completo de criação, configuração e teste do projeto na nuvem**:  

🎥 [Assista à demonstração completa](https://www.youtube.com/watch?v=h_PNwJsyep4)  

No vídeo, você verá:  
- Como **criar o banco de dados PostgreSQL** na Azure  
- Configuração do **App Service** e variáveis de ambiente  
- Deploy do projeto Java para o App Service  
- Testes das principais funcionalidades:
  - Login e cadastro de usuários (admin e comum)  
  - Cadastro, edição, listagem e exclusão de motos  
  - Cadastro, listagem e exclusão de movimentações e alertas  
- Navegação pelas telas do sistema diretamente pelo navegador, mostrando que o projeto está rodando na nuvem  

> ⚠️ Lembre-se: para acompanhar o vídeo e testar o projeto, o banco PostgreSQL e o App Service precisam estar ativos e configurados corretamente conforme o passo a passo.
