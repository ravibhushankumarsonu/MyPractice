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
//struct node* Insert(struct node* root, int data)
//{
//	if (root == NULL)
//		return newNode(data);
//	if (data < root->data)
//		root->left = Insert(root->left, data);
//	if (data > root->data)
//		root->right = Insert(root->right, data);
//	return root;
//}
//
//void Inorder(struct node* root)
//{
//	if (root != NULL)
//	{
//		Inorder(root->left);
//		printf("%d\n", root->data);
//		Inorder(root->right);
//	}
//}
//
//struct node* minValueNode(struct node* node)
//{
//	struct node* current = node;
//	while (current->left != NULL)
//	{
//		current = current->left;
//	}
//	return current;
//}
//struct node* deleteNode(struct node* root, int data)
//{
//	if (root == NULL) return root;
//
//	if (data < root->data)
//		root->left = deleteNode(root->left, data);
//
//	else if (data > root->data)
//		root->right = deleteNode(root->right, data);
//
//	else
//	{
//		if (root->left == NULL)
//		{
//			struct node *temp = root->right;
//			free(root);
//			return temp;
//		}
//		else if (root->right == NULL)
//		{
//			struct node *temp = root->left;
//			free(root);
//			return temp;
//		}
//
//		struct node* temp = minValueNode(root->right);
//
//		root->data = temp->data;
//
//		root->right = deleteNode(root->right, temp->data);
//	}
//	return root;
//}
//
//int main()
//{
//	struct node *root = NULL;
//	root = Insert(root, 50);
//	root = Insert(root, 30);
//	root = Insert(root, 20);
//	root = Insert(root, 40);
//	root = Insert(root, 70);
//	root = Insert(root, 60);
//	root = Insert(root, 80);
//
//	Inorder(root);
//
//	deleteNode(root,30);
//	printf("new data is\n");
//	Inorder(root);
//	return 0;
//}