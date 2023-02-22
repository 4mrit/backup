const arr1 = [1,2,3,4,5,6];
const arr2 = [
    {
        name:"amrit",
        age: 77
    },
    {
        name:"sujeet",
        age: 22
    },
    {
        name:"anup",
        age: 10
    }
]

const map_arr1 = arr1.map( n => n*2 )
// const map_arr1 = arr1.map( function bruh(num){
//     return num *2;
// })


const fil_arr2 = arr2.filter( n => n.age>18 )
// const fil_arr2 = arr2.filter( function (n){
//     if(n.age > 18)
//     {
//         return true
//     }
//     return false
// } )

const find_5 = arr1.find( n => n==5 )
//first true encountered is returned
const find_amrit = arr2.find( friend => friend.name = "amrit")

console.log(find_amrit );

arr2.forEach(fn => {
    console.log(fn)
})