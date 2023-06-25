#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    struct Node *previous;
    int value;
    struct Node *next;
} Node;

typedef struct list {
    struct Node *first;
    struct Node *last;
    int size;
} List;

int is_empty(List *list) {
    return list->size == 0;
}

List* add_at_the_beginning(int value, List *list) {
    Node *node = malloc(sizeof(Node));
    node->previous = NULL;
    node->value = value;
    node->next = NULL;
    
    if (is_empty(list)) {
        list->first = node;
        list->last = node;
    } else {
        Node *first = list->first;
        node->next = first;
        first->previous = node;
        list->first = node;   
    }

    list->size = list->size + 1;
    return list;
}

List* add_at_the_end(int value, List *list) {
    if (is_empty(list))
        return add_at_the_beginning(value, list);
    
    Node *node = malloc(sizeof(Node));
    node->next = NULL;
    node->value = value;
    
    list->last->next = node;
    node->previous = list->last;
    list->last = node;

    list->size = list->size + 1;
    return list;
}

List* add_in_position(int value, int position, List *list) {
    if (position < 0)
        return list;
    
    if (position == 0)
        return add_at_the_beginning(value, list);

    if (position >= (list->size - 1))
        return add_at_the_end(value, list);

    Node *node = malloc(sizeof(Node));
    node->previous = NULL;
    node->value = value;
    node->next = NULL;

    Node *aux = NULL;

    if ((list->size / 2) <= position) {
        aux = list->last;
        for (int i = (list->size - 1); i > position; i--)
            aux = aux->previous;
    } else {
        aux = list->first;
        for (int i = 0; i < position; i++)
            aux = aux->next;        
    }

    node->next = aux;
    node->previous = aux->previous;
    node->previous->next = node;
    aux->previous = node;

    list->size = list->size + 1;
    return list;
}

void print_list_from_beginning_to_end(List *list) {
    if (is_empty(list)) {
        printf("List is empty!\n");
        return;
    }

    Node *aux = list->first;
    while (aux != NULL) {
        printf("%d ", aux->value);
        aux = aux->next;
    }

    printf("\n");
}

void print_list_from_end_to_beginning(List *list) {
    if (is_empty(list)) {
        printf("List is empty!\n");
        return;
    }

    Node *aux = list->last;
    while (aux != NULL) {
        printf("%d ", aux->value);
        aux = aux->previous;
    }

    printf("\n");
}

int main() {
    List *list = malloc(sizeof(List));

    for (int i = 10; i > 0; i--)
        add_at_the_beginning(i, list);

    print_list_from_beginning_to_end(list);

    return 0;
}