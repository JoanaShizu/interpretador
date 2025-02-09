# **Universidade Estadual do Norte do Paraná**  

## TRABALHO FINAL: JOME - INTERPRETADOR DE LINGUAGEM C

**Alunas**: Joana Shizu e Melissa Francielle  
**Disciplina**: Compiladores (3º ano - Ciência da Computação)  
**Professor**: Dr. Wellington Della Mura  

### 📖 DESCRIÇÃO
Este projeto consiste no **Trabalho Final da disciplina de Compiladores** do curso de Ciência da Computação, ministrado pelo **Prof. Dr. Wellington Della Mura**.  
**Objetivo Central**: Implementação de um **interpretador para uma sublinguagem de C**, capaz de analisar e executar programas.
A proposta desafia os alunos a integrarem conceitos teóricos de análise léxica, sintática e semântica em uma aplicação prática, simulando etapas críticas de um processo de interpretação.

---

## 📚 Introdução Teórica

### Compilador vs. Interpretador
- **Compilador**:  
  Transforma código-fonte em código de máquina (executável) de uma só vez.   

- **Interpretador**:  
  Executa o código linha por linha, sem gerar um executável prévio.  
 
---

## 🛠️ Configuração do Projeto

### Requisitos
1. .NET 9.0
2. ANTLR (ferramenta de parser)
3. IDE (ex: Visual Studio, VS Code)
4. Compilador C (ex: GCC para testes de referência)

---

## 📜 Gramática da Linguagem (LangGrammar.g4)

A gramática define a sintaxe da linguagem suportada:
```antlr4
programa: cabecalho corpo EOF;                 // Estrutura geral
cabecalho: includeDecl* (defineDecl | comentario)*;
corpo: (structDecl | functionDecl | mainFunction)*; 

// Exemplo de declaração de função:
functionDecl: tipo VAR '(' parametros? ')' functionblock;

// Controle de fluxo:
decisionFunc: IF '(' exprbloco ')' bloco (ELSE IF ...)* (ELSE bloco)?;
loopFunc: whileLoop | forLoop | doWhileLoop;
```

## Componentes presentes no projeto 
**Estruturas**: struct, union.
**Funções**: Declaração, parâmetros e blocos.
**Controle de Fluxo**: if-else, switch-case, while, for, do-while.
**Tipos de Dados**: int, float, char, array e ponteiros.
**Operadores**: Aritméticos, lógicos e relacionais.

---

### 🧠 Lógica do Interpretador (LangGrammarCustomListener.cs)
Classe que é responsável por boa parte da implementação lógica de execução via listeners do ANTLR. Responsável por:
#### Gerenciamento de Variáveis:
``` 
private Dictionary<string, ReturnValue> _variables = new Dictionary<string, ReturnValue>();
``` 
- **Funções**: Armazenamento de parâmetros e corpos.
- **Struct**: Criação de instâncias e acesso a membros.
- **Controle de Fluxo**: Avaliação de condições e loops.
- **Entrada/Saída**: Implementção de **printf**, **scanf**, **gets** e **puts**.

#### Exemplo de Avaliação de Expressões:
``` 
private ReturnValue EvaluateExpression(LangGrammarParser.ExpressionContext context) {
    // Lógica para resolver operações como 2 + 3 * (4 - 1)
}
``` 
---
## 📂 Arquivos Importântes do Projeto 

| Arquivo     | Descrição |
|-------------|-------------|
| LangGrammar.interp      | Metadados para debug do ANTLR.     |
| LangGrammar.tokens      | Mapeamento de tokens gerados pela gramática. |
| LangGrammarLexer.cs      | Analisador léxico (tokenização do código).      |
| LangGrammarParser.cs     | Analisador sintático (construção da árvore). |
| LangGrammarBaseListener | Classe base para implementação de listeners.|
--- 
## 🧪 Testes 
Existem códigos no projeto que podem ser usados para testes, como por exemplo:
* **arrays.c**: manipulação de arrays.
* **if_else.c**: Condicionais aninhados.
* **struct.c**: Declaração e acesso a structs.
* **for.c**: Loops com inicialização complexa.


Todos devem estar usando a extensão ".c".

### Execução dos códigos 
Para poder executar esses códigos com o interpretador basta executar o seguinte comando dentro do local que se armazena os códigos.
``` 
dotnet run nome_codigo_exemplo.c
``` 
Além disso, caso o código teste esteja em algum diretório diferente, basta apenas passar o diretório de destino do código na parte **nome_codigo_exemplo.c**

### Compilar ou Recompilar a gramática.
Caso haja necessidade de compilar ou recompilar a gramática, se houver modificações, basta apenas utilizar o seguinte comando:
``` 
java -jar antlr4-4.13.2-complete.jar -Dlanguage=CSharp LangGrammar.g4
``` 
---
#### 📋 LINCENÇA
MIT License
Copyright (c) 2024 Joana Shizu, Melissa Francielle

Permissão para uso acadêmico gratuito. 
Proibida a redistribuição comercial sem autorização.

---

