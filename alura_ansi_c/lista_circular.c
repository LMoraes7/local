#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    struct Node *next;
    int value;
} Node;

typedef struct List {
    struct Node *first;
    struct Node *last;
    int size;
} List;

List* add_at_the_begin(List *list, int value) {
    Node *node = malloc(sizeof(Node));
    
    node->next = list->first;
    node->value = value;

    list->last->next = node;
    list->first = node;

    return list;
}

List* add_at_the_end(List *list, int value) {
    if (is_empty(list))
        return add_at_the_begin(list, value);

    Node *aux = list->first;
        
}

void print_list(List *list) {
    if (is_empty(list)) {
        printf("The list is empty\n");
        return;
    }

    Node *aux = list->first;
    do {
        printf("%d ", aux->value);
        aux = aux->next;
    } while (list->first != aux);
}

int is_empty(List *list) {
    return list->size == 0;
}


int main() {
    return 0;
}