#include <stdio.h>
#include <math.h>

void main()
{
    float x,y,a,b,c,temp,check;

    printf("Enter value of a,b,c in aX^2 + bX +c :");
    scanf("%f%f%f",&a,&b,&c);
    check = (b*b) - (4*a*c);

    if( check < 0 )
    {
        printf("Imaginory:");
    }
    else
    {
        temp = sqrtf( check) / (2*a);
        printf("temp : %f",temp);

        printf("Root 1 : %f" , -b-temp);
        printf("Root 2 : %f" , -b+temp);
    }
}