function plus (a, b){
    console.log(a + b);
}
function divide(a, b){
    console.log(a /b);
}


plus(2,3);
divide(10,5);



const player ={
    name:"lynn",
    sayHello:function(otherPersonName){
        console.log("Hello " +otherPersonName )
    },
};

console.log(player.name);
player.sayHello("Hi")
