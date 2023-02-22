const promiseByFetch = fetch("data.json");

promiseByFetch.then( response => {

    console.log(response);
    const promiseByresponse = response.json();
    promiseByresponse.then( data => {
        console.log(data);
    });

});


//

const hah = fetch("data.json").then(response =>{
    return response.json();
}).then(data => {
    console.log(data);   //data
    return data;        // promise
})

console.log(hah);   // promuse
hah.then(data =>{
    console.log(data);  // data
})