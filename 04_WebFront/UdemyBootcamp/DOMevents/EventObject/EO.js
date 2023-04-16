/* document.querySelector('button').addEventListener('click',function(){}); */

/* document.querySelector('button').addEventListener('click',function(){
    alert("heyy");
}); */

document.querySelector('button').addEventListener('click',function(e){
    console.log(e);
});
//키보드 이벤트 사용할 때 객체 필요함

const input = document.querySelector('input');
input.addEventListener('keydown', function (e) {
    console.log(e.key)
    console.log(e.code)
})
/* input.addEventListener('keyup', function () {
    console.log("KEYUP")
})
 */
/* window.addEventListener('keydown', function (e) {
   switch (e.code) {
       case 'ArrowUp':
           console.log("UP!");
           break;
       case 'ArrowDown':
           console.log("DOWN!");
           break;
       case 'ArrowLeft':
           console.log("LEFT!");
           break;
       case 'ArrowRight':
           console.log("RIGHT!");
           break
       default:
           console.log("IGNORED!")
   }
}) */