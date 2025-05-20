# 🛵 MotoTrack - Cloud (Java + VM + Docker)

## 📌 Sobre o Projeto

O **MotoTrack** é uma solução desenvolvida para otimizar o controle e a organização de motos nos pátios da empresa **Mottu**. O sistema permite o registro, acompanhamento de status, movimentações entre departamentos e exibição do histórico completo de cada moto.

A aplicação foi desenvolvida como parte do projeto interdisciplinar da FIAP, utilizando tecnologias modernas como Java 21, Spring Boot, Docker, Maven e deploy em nuvem com Azure CLI.

> 🔧 O backend da aplicação foi desenvolvido em um projeto Java separado. Para visualizar o código-fonte completo da API e conhecer sua estrutura, acesse o repositório:  
> 👉 [Repositório do Backend Java](https://github.com/mototrack-challenge/mototrack-backend-java)

## 👥 Integrantes

- **Felipe Ulson Sora** – RM555462 – [@felipesora](https://github.com/felipesora)
- **Augusto Lope Lyra** – RM558209 – [@lopeslyra10](https://github.com/lopeslyra10)
- **Vinicius Ribeiro Nery Costa** – RM559165 – [@ViniciusRibeiroNery](https://github.com/ViniciusRibeiroNery)


## ⚙️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- Maven
- Docker
- Azure CLI
- Git

## 📦 Como Executar o Projeto

### 1. Criar a Máquina Virtual na Azure via Azure CLI

Execute o script `criar-vm-mototrack.sh` no Azure CLI:

```bash
./criar-vm-mototrack.sh
```

### 2. Instalar Docker e Git na VM via SSH

Em seguida, execute o script `instalar-docker-git.sh`:

```bash
./instalar-docker-git.sh
```

### 3. Acessar a VM via SSH

Recupere o IP público da VM criada (mostrado na criação) e conecte via CMD ou PowerShell:

```bash
ssh admmototrack@<IP_PUBLICO_DA_VM>
```

### 4. Clonar este repositório dentro da VM

```bash
git clone https://github.com/mototrack-challenge/mototrack-cloud.git
cd mototrack-cloud
```

### 5. Construir a imagem Docker e rodar o container

```bash
docker build -t mototrack-api .
docker run -d -p 8080:8080 mototrack-api
```

### 6. Testar a API

```bash
http://<IP_PUBLICO_DA_VM>:8080/motos/listar/todos
```
> Para entender melhor os endpoints disponíveis e como utilizar a API, consulte a documentação completa no repositório Java: [Repositório do Backend Java](https://github.com/mototrack-challenge/mototrack-backend-java)

## 📌 Observações

- Certifique-se de que a porta 8080 está liberada no grupo de segurança da VM.

- Assegure que os scripts .sh tenham permissão de execução (chmod 744).

- O deploy completo é feito com apenas dois scripts e alguns comandos simples, garantindo portabilidade e agilidade.

## 🧹 Remover Recursos da Azure

Após finalizar os testes ou demonstrações, é recomendável remover os recursos da Azure para evitar cobranças adicionais.

### 1. Remover a Máquina Virtual e o Grupo de Recursos

Execute o seguinte comando no Azure CLI para deletar tudo de uma vez:

```bash
az group delete --name mototrack-rg --yes --no-wait
```
Esse comando exclui o grupo de recursos `mototrack-rg` e todos os recursos associados, como a VM, IP público e disco.