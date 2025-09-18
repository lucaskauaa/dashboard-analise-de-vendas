![Java](https://img.shields.io/badge/Java-21-red)
![Eclipse](https://img.shields.io/badge/IDE-Eclipse-purple)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)
![License](https://img.shields.io/badge/License-MIT-blue)


# 📊 Dashboard Análise de Vendas

Dashboard de análise de vendas desenvolvido em Java, com o objetivo de ler uma lista de vendas de um arquivo `.csv` e gerar um relatório completo.

## ✅ Funcionalidades

### Lê uma lista de vendas de um arquivo .csv e exibe:
1. Total de vendas por categoria
2. Total de vendas por região  
3. Top 5 produtos mais vendidos 
4. Valor médio por vendedor
5. Valor total por vendedor
6. Porcentagem de vendas por categoria
7. Vendas por mês e ano
8. Gera arquivo de texto com relatório completo

> **Obs:** Suporta apenas arquivos `.csv` no formato:  
> `id,produto,categoria,valor,quantidade,data,vendedor,região`

## ▶️ Como Executar

### Pré requisitos:

1. **JDK (Java Development Kit)** versão 21 → [Download](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)  
2. **Eclipse IDE** → [Download](https://www.eclipse.org/downloads/)
   
### Rodando o programa:

1. Baixe o arquivo `.zip` do repositório ou faça o clone utilizando o Git Bash através do link:  
   [https://github.com/lucaskauaa/dashboard-analise-de-vendas.git](https://github.com/lucaskauaa/dashboard-analise-de-vendas.git)

2. Após extrair o arquivo `.zip` ou clonar o repositório, abra o Eclipse e siga o caminho:
```
File → Switch Workspace → Other... → Browse → selecionar a pasta dashboard-analise-de-vendas → Launch
```

3. Importe o projeto no Eclipse:  
   ```
   File → Import → General → Existing Projects into Workspace → Next → Browse → selecionar a pasta dashboard-analise-de-vendas → Finish
   ```

4. Acesse o arquivo `src/application/Program.java` e pressione **F11** para executar.  

## 🧪 Exemplos de Uso

### Leitura de arquivo .csv com lista vendas

```
Insira o caminho do arquivo .csv com a lista de vendas: C:\Documents\products.txt

```

### Menu inicial

```
====================================
Selecione uma opção:

[1] Total de vendas por categoria
[2] Total de vendas por região
[3] Top 5 produtos mais vendidos
[4] Valor médio por vendedor
[5] Valor total por vendedor
[6] Porcentagem de vendas por categoria
[7] Vendas por mês e ano
[8] Gerar arquivo de texto com relatório completo
[0] Sair.

Resposta: 
```

### Total de vendas por categoria

```
Total de vendas por categoria:

Eletrônicos: 35
Acessórios: 23
Eletrodomésticos: 10
Livros: 9
Esportes: 7
Móveis: 6
Música: 5
Casa e Jardim: 4
Hobbies: 1
```

### Total de vendas por região

```
Total de vendas por região:

Sudeste: 30
Sul: 22
Norte: 17
Nordeste: 16
Centro-Oeste: 15
```

### Top 5 produtos mais vendidos

```
Top 5 produtos mais vendidos:

Cabo de rede 10m: 15
Carregador Portátil: 13
Mouse sem fio: 6
Livro de Culinária: 6
Caixa de som: 6
```

### Valor médio por vendedor

```
Valor médio por vendedor:

Maria Oliveira: R$ 1511,64
João Silva: R$ 997,36
Pedro Costa: R$ 827,62
Ana Souza: R$ 825,30
```

### Valor total por vendedor

```
Valor total por vendedor:

Maria Oliveira: R$ 37791,00
João Silva: R$ 25931,25
Pedro Costa: R$ 20690,50
Ana Souza: R$ 19807,25
```

### Porcentagem de vendas por categoria

```
Porcentagem de vendas por categoria:

Eletrônicos: 35%
Acessórios: 23%
Eletrodomésticos: 10%
Livros: 9%
Esportes: 7%
Móveis: 6%
Música: 5%
Casa e Jardim: 4%
Hobbies: 1%
```

### Vendas por mês e ano

```
Meses onde ocorreram vendas:

1/2023
2/2023
3/2023
4/2023
5/2023
6/2023
7/2023
8/2023
9/2023
10/2023
11/2023
12/2023
1/2024
2/2024
3/2024
4/2024
5/2024
6/2024
7/2024
8/2024
9/2024
10/2024
11/2024
12/2024

Digite o ano que você deseja consultar: 2024
Digite o mês que você deseja consultar: 12

Vendas em 12/2024:

Venda:
id: 69
Produto : Violão Acústico
Categoria : Música
Valor unitário: R$ 600,00
Quantidade : 1
Valor total: R$ 600,00
Data: 01/12/2024
Vendedor: João Silva
Região : Sudeste
```

### Gerar arquivo de texto com relatório completo

```
Insira o endereço do arquivo .txt onde o relatório deverá ser gerado: C:\Users\Lucas Kauã\Documents\ti\curso-java\text\relatorio.txt

Arquivo gerado em: C:\Users\Lucas Kauã\Documents\ti\curso-java\text\relatorio.txt
```

## 🧠 Tecnologias Utilizadas

- **Linguagem:** Java 21 
- **Recursos:** Collections, Lambda, Stream API, Generics, DateTime
- **Manipulação de Arquivos:** BufferedReader, BufferedWriter, try-with-resources
- **IDE:** Eclipse


## 📁 Estrutura do Projeto

```
src/
└── application/
| └── Program.java
└── controller/
| └── FileGenerationController.java
| └── MenuController.java
| └── SalesAnalysisControler.java
└── model/
│ └── Sale.java
└── service/
| └── SalesAnalysisService.java
| └── SalesListService.java
└── util/
| └── InputReader.java
| └── ReadFile.java
| └── WriteFile.java
text/
└── products.txt

```

### 🔍 Descrição das principais classes

- `Program.java`: Classe principal que inicia o programa.
- `FileGenerationController.java`: Controla a interação com o usuário após ele selecionar a opção de gerar arquivo de texto.
- `MenuController.java`: Controla a interação com o usuário via console durante toda a execução do programa.
- `SalesAnalysisControler.java`: Controla a saída dos dados no console.
- `Sale.java`: Classe responsável por representar uma venda, contendo atributo como id, produto, data, vendedor, etc.
- `SalesAnalysisService.java`: Responsável pelo processamento dos dados e geração dos relatórios.
- `SalesListService.java`: Responsável pela lógica de gerar objetos do tipo venda.
- `InputReader.java`: Lida com a entrada de dados do usuário no console.
- `ReadFile.java`: Reponsável por ler os dados do arquivo .csv e retornar uma lista de objetos do tipo venda.
- `WriteFile.java`: Contém a lógica de escrita de relatório em arquivo .txt.
- `text/products.txt`: Contém o arquivo .csv utilizado nos exemplos.

## 🧑‍💻 Autor

Desenvolvido por **Lucas Kauã**.
