() => { }  //valid arrow fn without name(Anonomus)


normalFunction();

function normalFunction(){
    console.log("inside a normal fn");
}


////////////////////////////////////////////////////

// arrowFunction();  //cant call arrow function before 
                    //decleration
const arrowFunction = () => { 
    console.log("inside a arrow fn");
}
arrowFunction();


/////////////////////////////////////////////////////
    //  () is not required when we have one attribut   
const double = a => a*2;
         // auto return a*2 when it dowsnt have body

console.log( double(2) );