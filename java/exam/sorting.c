#include <stdio.h>
void bubbleSort(int* a,int n);
void insertionSort(int* a,int n);
void selectionSort(int* a,int n);
void quickSort(int*,int,int);
void exchangeSort(int* a,int n);
void mergeSort(int*,int,int);
void radixSort(int* a,int n);
void shellSort(int* a,int n);
void binarySort(int* a,int n);
void heapSort(int* a,int n);
void swap(int * a, int *b);
void displayArray(int *,int);


void main()
{
    int array[] = {21,32,1,-1,0,6};
    // displayArray(array,6);
    // bubbleSort(array,6);
    // insertionSort(array,6);
    // selectionSort(array,6);
    // quickSort(array,0,5);
    // mergeSort(array,0,5);
    
    displayArray(array,6);
    heapSort(array,6);
}
void bubbleSort(int* a,int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n-i; j++)
        {
            if (a[j]>a[j+1])
            {
                swap(&a[j],&a[j+1]);
            }            
        }
        
    }
}
void insertionSort(int* a,int n)
{
    for (int i = 1; i < n; i++)
    {
        for (int j = i; j > 0; j--)
        {
            if(a[j] < a[j-1])
            {
                swap(&a[j],&a[j-1]);
            }
            else
            {
                break;
            }
        }
        
    }
    
}

void selectionSort(int* a,int n)
{
    for (int i = 0; i < n-1; i++)
    {
        for (int j = i; j < n; j++)
        {
            if(a[i] > a[j])
            {
                swap(&a[i],&a[j]);
            }
        }
        
    }
    
}

void quickSort(int* a,int lb, int ub)
{
    int pivot = a[lb];
    int start = lb, end = ub;

    if (lb>=ub)
        return;
    
    while (start < end)
    {
        while(a[start] <= pivot)
            start ++ ;

        while (a[end] > pivot)
            end --;

        if(start < end)  
            swap(&a[start], &a[end]);
    }
    swap(&a[lb], &a[end]);
    quickSort(a,lb,end-1);
    quickSort(a,end+1,ub);
}
void mergeSort(int* a,int lb, int ub)
{
    int mid = (lb+ub)/2;
    int i = lb,k=0;
    int j = mid+1;
    int temp[ub-lb+1];

    if (lb >= ub)
        return;

    mergeSort(a,lb,mid);
    mergeSort(a,mid+1,ub);

    while (i <= mid && j <= ub)
    {
        if (a[i]<a[j])
        {
            temp[k] = a[i];
            printf("\n  a[i] = %d",a[i]);
            i++;
        }
        else
        {
            temp[k] = a[j];
            printf("\n  a[j] = %d",a[j]);
            j++;
        }
        k++;
    }
    int l=0;
    for (k = lb; k < ub; k++)
        a[k] = temp[l];l++;
}

void heapSort(int *a, int n)
{
    int heap[n+1],parent,child;
    for (int i = 1; i < n+1; i++)
    {
        child = i;
        parent = child/2;
        heap[child] = a[i];
        while (child != 0 && a[parent] <a[child])
        {
            // parent = (int)(child/2);
            swap(&a[parent], &a[child]);
            child = parent;
            parent = child/2;
            displayArray(heap,6);
            printf("  child = %d , parent = %d\n",child,parent);
        } 
    }
}


void swap(int *a,int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}
void displayArray(int *a,int n)
{
    printf("\n |");
    for (int i = 0; i < n; i++)
    {
        printf(" %d |",a[i]);
    }
    
}
