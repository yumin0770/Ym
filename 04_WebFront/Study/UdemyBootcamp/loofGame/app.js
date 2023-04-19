let maximum = parseInt(prompt ("Enter the maximum number"));
while(!maximum){
        maximum = parseInt(prompt ("Enter a valid number"));
}

const targetNum = Math.floor(Math.random()* maximum)+1;

let guess = parseInt(prompt("Enter your first guess"));
let attemps = 1;

while(parseInt(guess) !== targetNum){
    if(guess === 'q') break;
    attemps++;
    if(guess>targetNum){
        guess = (prompt("too high"));
    }else{
        guess = (prompt("too low"));
    }
}
if('q' === guess){
    console.log("ok done")
}
console.log(`you got it ${attemps} guesses`)