#include <stdio.h>
#include <string.h>
void reverse(char *,int,int);

void main(){
    char* n;
    printf("Enter text : ");
    scanf("%s",n);
    reverse(n,0,strlen(n)-1);
    printf("reverse is %s\n",n);
}

void reverse(char * a,int x,int y){
    if(x<y)    
    {
        char temp = a[x];
        a[x] = a[y];
        a[y] = temp;
        reverse(a,x+1,y-1);
    }
    else
        return;
}