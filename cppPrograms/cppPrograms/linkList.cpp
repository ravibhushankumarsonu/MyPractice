//#include<stdio.h>
//#include<stdlib.h>
//
//using namespace std;
//struct node
//{
//	int data;
//	struct node *next;
//};
//
////To print the entire list-stored values
//void printList(struct node* n)
//{
//	while (n != NULL)
//	{
//		printf("%d\n", n->data);
//		n = n->next;
//	}
//}
//
////To insert at the front of the list
//void Insertfront(struct node** head, int data)
//{
//	struct node* newNode = (struct node*)malloc(sizeof(struct node));
//
//	newNode->data = data;
//	newNode->next = (*head);
//
//	(*head) = newNode;
//}
//
////To insert after the given node
//void InsertAfterNode(struct node** prev_node, int data)
//{
//	struct node* new_node = (struct node*)malloc(sizeof(struct node));
//
//	new_node->data = data;
//
//	new_node->next = (*prev_node)->next;
//	(*prev_node)->next = new_node;
//}
//
////To insert at the Last
//void InsertAtLast(struct node** head, int data)
//{
//	struct node* new_node = (struct node*)malloc(sizeof(struct node));
//	struct node *last_node = *head;
//	new_node->data = data;
//	new_node->next = NULL;
//	if (*head == NULL)
//	{
//		*head = new_node;
//	}
//
//	while (last_node->next != NULL)
//		last_node = (last_node)->next;
//
//		last_node->next = new_node;	
//}
//
////delete when head_reference and key of the node is given to me
//void deleteNode(struct node** head_ref, int key)
//{
//	struct node* temp = *head_ref, *prev;
//	prev = (struct node*)malloc(sizeof(struct node));
//	if (temp != NULL&&temp->data == key)
//	{
//		*head_ref = temp->next;
//		free(temp);
//		return;
//	}
//
//	while (temp != NULL&&temp->data != key)
//	{
//		prev = temp;
//		temp = temp->next;
//	}
//	if (temp == NULL) { return; }
//	prev->next = temp->next;
//	free(temp);
//}
//
////to swap the two nodes in the link list
//void swapNodes(struct node** head_ref, int x, int y)
//{
//	if (x == y)
//		return;
//	struct node *prevX=NULL, *currX = *head_ref;
//	//it line means currX!=NULL and currX->data!=x
//	while (currX &&currX->data != x)
//	{
//		prevX = currX;
//		currX = currX->next;
//	}
//
//	struct node *prevY = NULL, *currY = *head_ref;
//	while (currY&& currY->data != y)
//	{
//		prevY = currY;
//		currY = currY->next;
//	}
//	if (currX == NULL || currY == NULL)
//		return;
//	if (prevX != NULL)
//		prevX->next = currY;
//	else
//		*head_ref = currY;
//
//	if (prevY != NULL)
//		prevY->next = currX;
//	else
//	{
//		*head_ref = currX;
//	}
//
//	struct node *temp = currY->next;
//	currY->next = currX->next;
//	currX->next = temp;
//}
////To reverse the entire link list
//
//void reverse(struct node *head)
//{
//	struct node *prev = NULL;
//	struct node *curr = head;
//	struct node *next = curr->next;
//	while (curr != NULL)
//	{
//		next = curr->next;
//		curr->next = prev;
//		prev = curr;
//		curr = next;
//	}
//	head = prev;
//}
//
//
//int main()
//{
//	struct node* first = NULL;
//	struct node* second = NULL;
//	struct node* third = NULL;
//
//	first = (struct node*)malloc(sizeof(struct node));
//	second = (struct node*)malloc(sizeof(struct node));
//	third = (struct node*)malloc(sizeof(struct node));
//
//	first->data = 12;
//	first->next = second;
//
//	second->data = 13;
//	second->next = third;
//
//	third->data = 14;
//	third->next = NULL;
//
//	printList(first);
//
//	Insertfront(&first, 11);
//
//	printList(first);
//
//	InsertAfterNode(&second, 31);
//
////	printList(first);
//
//	InsertAtLast(&first, 45);
//	//printList(first);
//
//	deleteNode(&first,31);
//	printList(first);
//
//	//swapNodes(&first, 11, 45);
//	//printList(first);
//
//	//reverse(first);
//	//printList(first);
//	return 0;
//}