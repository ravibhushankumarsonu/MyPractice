//#include<stdio.h>
//#include<stdlib.h>
//
//struct AdjListNode
//{
//	int dest;
//	struct AdjListNode* next;
//};
//
//struct AdjList
//{
//	struct AdjListNode* head;
//};
//
//struct Graph
//{
//	int v;
//	struct AdjList* arr;
//};
//
//struct AdjListNode* newAdjListNode(int dest)
//{
//	struct AdjListNode* newNode = (struct AdjListNode*)malloc(sizeof(struct AdjListNode));
//	newNode->dest = dest;
//	newNode->next = NULL;
//	return newNode;
//}
//
//struct Graph* createGraph(int v)
//{
//	struct Graph* graph = (struct Graph*)malloc(sizeof(struct Graph));
//	graph->v = v;
//	graph->arr = (struct AdjList*)malloc(v*sizeof(struct AdjList));
//	int i;
//	for (i = 0; i < v; i++)
//		graph->arr[i].head = NULL;
//
//	return graph;
//}
//
//void AddEdge(struct Graph* graph, int src, int dest)
//{
//	struct AdjListNode* newNode = newAdjListNode(dest);
//	newNode->next = graph->arr[src].head;
//	graph->arr[dest].head = newNode;
//}
//
//void printGraph(struct Graph* graph)
//{
//	int V;
//	for (V = 0; V < graph->v; ++V)
//	{
//		struct AdjListNode* pCrawl = graph->arr[V].head;
//		printf("\n Adjacency list of vertex %d\n head ", V);
//		while (pCrawl)
//		{
//			printf("-> %d", pCrawl->dest);
//			pCrawl = pCrawl->next;
//		}
//		printf("\n");
//	}
//}
//
//int main()
//{
//	// create the graph given in above figure
//	int V = 5;
//	struct Graph* graph = createGraph(V);
//	AddEdge(graph, 0, 1);
//	AddEdge(graph, 0, 4);
//	AddEdge(graph, 1, 2);
//	AddEdge(graph, 1, 3);
//	AddEdge(graph, 1, 4);
//	AddEdge(graph, 2, 3);
//	AddEdge(graph, 3, 4);
//
//	// print the adjacency list representation of the above graph
//	printGraph(graph);
//
//	return 0;
//}