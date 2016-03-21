//#include<stdio.h>
//#include<stdlib.h>
//
//struct node
//{
//	int data;
//	struct node *left, *right;
//};
//
//struct node *newNode(int data)
//{
//	struct node *temp = (struct node*)malloc(sizeof(struct node));
//	temp->data = data;
//	temp->left = temp->right = NULL;
//	return temp;
//}
//
//struct node* Insert(struct node* node, int data)
//{
//	if (node == NULL)
//		return newNode(data);
//	if (data < node->data)
//		node->left = Insert(node->left, data);
//	else if (data>node->data)
//		node->right = Insert(node->right, data);
//
//	return node;
//}
//
//void Inorder(struct node* root)
//{
//	if (root != NULL)
//	{
//		Inorder(root->left);
//		printf("%d\n",root->data);
//		Inorder(root->right);
//	}
//}
//int main()
//{
//	struct node *root = NULL;
//	root = Insert(root, 50);
//	Insert(root, 12);
//	Insert(root, 34);
//	Insert(root, 23);
//	Insert(root,10);
//	Insert(root,67);
//
//	Inorder(root);
//
//	return 0;
//}