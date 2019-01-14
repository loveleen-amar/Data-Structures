#include<stdio.h>
#include<stdlib.h>
#define SIZE 40

struct queue{
	int item[SIZE];
	int front;
	int rear;
};

struct queue* createQueue(){
	struct queue* q = malloc(sizeof(struct queue));
	q->front=-1;
	q->rear=-1;
}

int main(){
	int n;
	printf("Enter number of vertices: ");
	scanf("%d",&n);
	int matrix[n][n];
	int visited[n];
	int i,j,k;

	for(i=0;i<n;i++){
		visited[i]=0;
	}

	printf("Enter Adj. Matrix: \n");
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			scanf("%d",&matrix[i][j]);
		}
	}

	int entry;
	printf("Enter starting point: ");
	scanf("%d",&entry);

	struct queue* q = createQueue();
	q->front=0;
	q->rear=0;
	q->item[q->front] = entry;
	visited[entry]=1;

	printf("The BFS order is as follows: \n");
	printf("%d\n",entry);

	while(q->rear-q->front!=1){
		int value = q->item[q->rear];
		// printf("Value is %d\n",value);
		for(i=0;i<n;i++){
			if(matrix[value][i]==1 && visited[i]==0){
				q->front++;
				q->item[q->front] = i;
				visited[i]=1;
				printf("%d\n",q->item[q->front]);
			}
		}
		q->rear++;
	}
	/*for(i=0;i<n;i++){
		printf("%d\n",visited[i]);
	}*/
}

/*0 0 1 1
0 0 1 0
1 1 0 0
1 0 0 0*/