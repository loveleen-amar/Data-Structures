#include<stdio.h>

int k=0,r[50];

int DFS(int* a,int s[],int n,int i)
{
	//printf("%d ",i);
	int j;	
	s[i]=1;
	for(j=0;j<n;j++)
	{
		if(s[j]==0 && *((a+n*i)+j)==1)
		{
			
			DFS((int *)a,s,n,j);
		}
	}
	//printf("%d ",i);
	r[k]=i;
	//printf("k:%d ",k);
	k++;
}

int main()
{
	int i,j,n;
	
	printf("Enter number of vertices\n");
	scanf("%d",&n);
	
	int s[n],a[n][n];
	
	printf("Enter adjacency matrix\n");
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			scanf("%d",&a[i][j]);
		}
		s[i]=0;
	}
	
	for(i=0;i<n;i++)
	{
		if(s[i]==0)
		{
			DFS((int *)a,s,n,i);
		}
	}
	
	for(i=n-1;i>=0;i--)
	{
		printf("%d ",r[i]);
	}
	
}

/*
6

0 0 1 1 0 0
0 0 0 1 1 0
0 0 0 0 0 1
0 0 0 0 0 1
0 0 0 0 0 1
0 0 0 0 0 0

ans
1 4 0 3 2 5
*/
