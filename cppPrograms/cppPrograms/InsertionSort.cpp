//#include<stdio.h>
//#include<stdlib.h>
//
//void swap(int *x, int *y)
//{
//	int temp = *x;
//	*x = *y;
//	*y = temp;
//}
//
//void Sort(int arr[], int n)
//{
//	int i, key, j;
//	for (i = 1; i < n; i++)
//	{
//		key = arr[i];
//		j = i - 1;
//
//		/* Move elements of arr[0..i-1], that are
//		greater than key, to one position ahead
//		of their current position */
//		while (j >= 0 && arr[j] > key)
//		{
//			arr[j + 1] = arr[j];
//			j = j - 1;
//		}
//		arr[j + 1] = key;
//	}
//}
//
////int Sort(int arr[], int n)
////{
////	int i, j, key;
////
////}
//
//void printArray(int arr[], int n)
//{
//	int i;
//	for (i = 0; i < n; i++)
//		printf("%d\t", arr[i]);
//	printf("\n");
//}
//int main()
//{
//	int arr[] = { 10,2,1,4,5,3,6,9,8,7 };
//	printArray(arr, 10);
//	Sort(arr, 10);
//	printArray(arr, 10);
//	return 0;
//}