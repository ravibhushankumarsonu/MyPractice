//#include<stdio.h>
//#include<stdlib.h>
//int search(int arr[], int n, int x)
//{
//	int i;
//	for (i = 0; i < n; i++)
//		if (arr[i] == x)
//			return i;
//	return -1;
//}
//
//int BinarySearch(int arr[], int l, int u, int x)
//{
//	if (u >= l)
//	{
//		int mid = l + (u - l) / 2;
//		if (arr[mid] == x)
//			return mid;
//		if (arr[mid] > x)
//			return BinarySearch(arr,l,mid-1,x);
//		return BinarySearch(arr, mid+1, u, x);
//	}
//	return -1;
//}
//
//int BinarySearch1(int arr[], int l, int u, int x)
//{
//	while (u >= l)
//	{
//		int mid = l + (u - l) / 2;
//		if (arr[mid] == x)
//			return mid;
//		if (arr[mid] > x)
//			u = mid - 1;
//		else
//		    l = mid + 1;
//	}
//	return -1;
//}
//
//int main()
//{
//	int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//	printf("%d\n", search(arr, 10, 10));
//	printf("%d\n", BinarySearch(arr, 0,9, 5));
//	printf("%d\n", BinarySearch1(arr, 0, 9, 8));
//	return 0;
//}