function sum (x)
{
    let odd=0,even=0;
    for (let i = 0; i < x.length; i++) 
    {
        if ( x[i] %2 == 0)
        {
            even += x[i];
        } 
        else 
        {
            odd += x[i];
        }
    }
    obj = {
        even_sum : even,
        odd_sum : odd
    }
    return obj;
}

myArray = [1,21,2,44];

result = sum(myArray);

console.log(result);



