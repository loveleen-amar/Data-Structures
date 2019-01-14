#include<stdio.h>
#include<stdlib.h>
#define SIZE 40

struct stack{
	int item[SIZE];
	int top;
};

struct stack* createStack(){
	struct stack* s = malloc(sizeof(struct stack));
	s -> top = -1;
	return s;
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

	struct stack* s = createStack();
	s->top++;
	s->item[s->top] = entry;
	visited[entry]=1;
	printf("The DFS order is as follows: \n");
	printf("%d\n",s->item[s->top]);

	while(s->top!=-1){
		int value = s->item[s->top];
		int flag=0;
		for(i=0;i<n;i++){
			if (matrix[value][i] ==1 && visited[i]==0){
				s->top++; 
				s->item[s->top] = i; //Add new element to the top of stack
				flag=1;
				visited[i]=1;
				printf("%d\n",s->item[s->top]);
				break;
			}
		}
		if(flag==0){
			s->top--;
		}
	}
}

/*
0 0 0 1
0 0 1 0
0 1 0 0
0 1 0 0
*/