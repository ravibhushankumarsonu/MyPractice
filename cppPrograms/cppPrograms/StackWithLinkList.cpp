//#include<stdio.h>
//#include<stdlib.h>
//#include<limits.h>
//
//struct StackNode
//{
//	int data;
//	struct StackNode* next;
//};
//
//struct StackNode* newNode(int data)
//{
//	struct StackNode* stackNode = (struct StackNode*)malloc(sizeof(struct StackNode));
//	stackNode->data = data;
//	stackNode->next = NULL;
//	return stackNode;
//}
//
//int IsEmpty(struct StackNode *root)
//{
//	return !root;
//}
//
//void push(struct StackNode** root, int data)
//{
//	struct StackNode* stacknode = newNode(data);
//	stacknode->next = *root;
//	*root = stacknode;
//}
//
//int pop(struct StackNode** root)
//{
//	if (IsEmpty(*root))
//		return INT_MIN;
//	struct StackNode* temp = *root;
//	*root = (*root)->next;
//	int poped = temp->data;
//	free(temp);
//	return poped;
//}
//
//int peek(struct StackNode* root)
//{
//	if (IsEmpty(root))
//		return INT_MIN;
//	return root->data;
//}
//
//int main()
//{
//	struct StackNode* root = NULL;
//	push(&root, 12);
//	push(&root, 423);
//	push(&root, 52);
//
//	return 0;
//}