const all = document.querySelectorAll('ul li');

for (let i = 0; i < all.length; i++) 
{
    const element = all[i];
    element.innerHTML = "yo access "+i;    
}