#include <stdio.h>
int factorial(int);

void main(){
    int n;
    printf("Enter a number : ");
    scanf("%d",&n);
    printf("Factorial is %d\n",factorial(n));
}

int factorial(int n){
    if (n < 2)
        return 1;
    else
        return n*factorial(n-1);    
}