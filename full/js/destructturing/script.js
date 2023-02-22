const obj1 = { name:"amrit" };
const obj2 = { name:"amrit2" ,age:12};
const arr1 = [1,2,3,4];
const arr2 = [5,6,7];
const height = 6.9

const obj3 = {
    ...obj1,    // name: "amrit"
    ...obj2,    // name: "amrit2" , age:12
    height      // height = height
}

const arr3 = [ ...arr1 , ...arr2 ]


console.log(obj3);
console.log(arr3);