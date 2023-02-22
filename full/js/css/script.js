// const counter = document.querySelector("#cnt");
// const increase = document.querySelector("#inc");
// const decrease = document.querySelector("#dec");

const counter = document.getElementById("cnt");
const increase = document.getElementById("inc");
const decrease = document.getElementById("dec");

let x;
function togglecolor()
{
    console.log(counter.style.color)
    if( counter.style.color === "red")
    {
        counter.style.color = "blue";
    }
    else
    {
        counter.style.color = "red";
    }
}

function increase_counter()
{
    counter.innerHTML ++;
    console.log("increased : ", counter.innerHTML)
    togglecolor();
}
function decrease_counter()
{
    counter.style.color = "blue";
    togglecolor();
    counter.innerHTML --;
    console.log("decreased : " , counter.innerHTML)
}

increase.addEventListener("click", increase_counter);
decrease.addEventListener("click", decrease_counter);
counter.addEventListener("click",increase_counter)