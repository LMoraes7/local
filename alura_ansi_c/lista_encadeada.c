#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    struct Node *next;
    int value;
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
    node->value = value;
    node->next = NULL;

    if (is_empty(list)) {
        list->first = node;
        list->last = node;
    } else {
        node->next = list->first;
        list->first = node;
    }

    list->size = list->size + 1;
    return list;
}

List* add_at_the_end(int value, List *list) {
    if (is_empty(list))
        return add_at_the_beginning(value, list);
    
    Node *node = malloc(sizeof(Node));
    list->last->next = node;
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

    Node *aux = list->first;
    int index = 0;

    while (index < (position - 1)) {
        aux = aux->next;
        index += 1;        
    }

    Node *node = malloc(sizeof(Node));
    node->value = value;
    node->next = aux->next;

    aux->next = node;

    list->size = list->size + 1;
    return list;
}

List* remove_at_start(List *list) {
    if (is_empty(list))
        return list;

    Node *node = NULL;

    if (list->size == 1) {
        node = list->first;

        list->first = NULL;
        list->last = NULL;
    } else {
        node = list->first;
        list->first = node->next;
    }

    free(node);

    list->size = list->size - 1;
    return list;
}

List* remove_at_the_end(List *list) {
    if (is_empty(list))
        return list;
    
    Node *aux = list->first;
    int index = 0;

    while (index < (list->size - 2)) {
        aux = aux->next;
        index += 1;        
    }

    Node *last = aux->next;

    aux->next = NULL;
    list->last = aux;
    
    free(last);

    list->size = list->size - 1;
    return list;
}

List* remove_by_position(int position, List *list) {
    if (position >= list->size)
        return list;
    
    if (position == 0)
        return remove_at_start(list);
    
    if (position == list->size - 1)
        return remove_at_the_end(list);

    Node *aux = list->first;
    int index = 0;

    while (index < (position - 1)) {
        aux = aux->next;
        index += 1;
    }

    Node *be_removed = aux->next;
    aux->next = be_removed->next;

    free(be_removed);

    list->size = list->size - 1;
    return list;
}

void print_list(List *list) {
    Node *aux = list->first;

    if (list->size == 0) {
        printf("list is empty\n");
        return;
    }

    printf("\n");
    while (aux != NULL) {
        printf("%d ", aux->value);
        aux = aux->next;
    }
    printf("\n");
}

int main() {
    List *list = malloc(sizeof(List));

    for (int i = 10; i > 0; i--)
        add_at_the_beginning(i, list);

    print_list(list);

    remove_by_position(5, list);
    remove_by_position(4, list);

    print_list(list);

    free(list);
    return 0;
}