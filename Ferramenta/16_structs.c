#include <stdio.h>
#include <string.h>

// Definição da estrutura Aluno
struct Aluno {
    char nome[50];
    int idade;
    float nota;
};

int main() {
    // Declaração e inicialização correta de aluno1
    struct Aluno aluno1 = {"Joana Camargo", 22, 9.5};
    // Exibir informações do aluno
    printf("Dados do Aluno:\n");
    printf("Nome: %s\n", aluno1.nome);
    printf("Idade: %d\n", aluno1.idade);
    printf("Nota: %f\n", aluno1.nota);

    return 0;
}
