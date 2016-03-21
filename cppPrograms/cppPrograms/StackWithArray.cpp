//#include<stdio.h>
//#include<stdlib.h>
//
//struct Stack
//{
//	int top;
//	unsigned capacity;
//	int* arr;
//};
//
//struct Stack* CreateStack(unsigned capacity)
//{
//	struct Stack* stack = (struct Stack*)malloc(sizeof(struct Stack));
//	stack->capacity = capacity;
//	stack->top = -1;
//	stack->arr = (int*)malloc(stack->capacity*sizeof(int));
//	return stack;
//}
//
//int IsFull(struct Stack* stack)
//{
//	return stack->top == stack->capacity - 1;
//}
//
//int IsEmpty(struct Stack* stack)
//{
//	return stack->top == -1;
//}
//
//void push(struct Stack* stack, int item)
//{
//	if (IsFull(stack))
//		return;
//	stack->arr[++stack->top] = item;
//	printf("%d is pushed to the Stack.\n", item);
//}
//
//int pop(struct Stack* stack)
//{
//	if (IsEmpty(stack))
//		return INT_MIN;
//	return stack->arr[stack->top--];
//}
//
//int peek(struct Stack* stack)
//{
//	if (IsEmpty(stack))
//		return INT_MIN;
//	return stack->arr[stack->top];
//}
//int main()
//{
//	struct Stack* stack = CreateStack(10);
//
//	push(stack, 12);
//	push(stack, 13);
//	/*printf("%d is poped\n", pop(stack));
//	printf("%d is poped\n", pop(stack));
//	printf("%d is poped\n", pop(stack));*/
//	push(stack, 14);
//	push(stack, 15);
//	push(stack, 16);
//	push(stack, 17);
//	push(stack, 18);
//	push(stack, 19);
//	push(stack, 20);
//	push(stack, 21);
//	//push(stack, 22);//No error will show
//
//	return 0;
//}