#include <stdio.h>
#include <stdlib.h>

typedef struct Nodo {
    int valor;
    struct Nodo *proximo;
} Nodo;

typedef struct Lista {
    int tamanho;
    struct Nodo *inicio;
} Lista;

Lista* iniciar_lista() {
    Lista* lista = (Lista*) malloc(sizeof(Lista));
    lista->tamanho = 0;
    lista->inicio = NULL;

    return lista;
}

Lista* inserir_no_inicio(Lista *lista, int *valor) {
    Nodo *node = (Nodo*) malloc(sizeof(Nodo));
    node->valor = *valor;
    node->proximo = lista->inicio;

    lista->inicio = node;

    return lista;
}

Lista* inserir_no_final(Lista *lista, int *valor) {
    if (lista->tamanho == 0)
        return inserir_no_inicio(lista, valor);

    Nodo *aux = lista->inicio;
    while (aux->proximo != NULL)
        aux = aux->proximo;

    Nodo *node = (Nodo*) malloc(sizeof(Nodo));
    node->valor = *valor;
    node->proximo = NULL;
    
    aux->proximo = node;

    return lista;
}

void imprimir_lista(Lista *lista) {
    if (lista->tamanho == 0) {
        printf("Lista vazia\n");
        return;
    }
    
    printf("Lista: ");
    Nodo *aux = lista->inicio;
    while (aux != NULL) {
        printf("%d ", aux->valor);
        aux = aux->proximo;
    }
    printf("\n");
}

int main() {
    Lista* lista = iniciar_lista();
    imprimir_lista(lista);

    int *numero = malloc(sizeof(int));   
    for (int i = 0; i < 5; i++) {
        printf("Informe um numero: ");
        scanf("%d", numero);

        lista = inserir_no_final(lista, numero);
    }
    
    imprimir_lista(lista);
    return 0;
}