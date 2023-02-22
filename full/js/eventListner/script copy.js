// const counter = document.querySelector("#cnt");
// const increase = document.querySelector("#inc");
// const decrease = document.querySelector("#dec");

const counter = document.getElementById("cnt");
const increase = document.getElementById("inc");
const decrease = document.getElementById("dec");

let x;

function increase_counter()
{
    counter.innerHTML ++;
    console.log("increased : ", counter.innerHTML)
}
function decrease_counter()
{
    counter.innerHTML --;
    console.log("decreased : " , counter.innerHTML)
}

increase.addEventListener("click", increase_counter);
decrease.addEventListener("click", decrease_counter);
counter.addEventListener("click",increase_counter)