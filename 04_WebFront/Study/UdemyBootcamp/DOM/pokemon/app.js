// https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png

const container = document.querySelector('#container');
const baseURL = 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/'


for (let i = 1; i <= 151; i++) {
    const pokemon = document.createElement('div');  //div생성
    pokemon.classList.add('pokemon'); //div clasname은 pokemon
    const label = document.createElement('span'); //span 태그 추가
    label.innerText = `#${i}`; //span태그에 숫자 넣음
    const newImg = document.createElement('img'); //img추가
    newImg.src = `${baseURL}${i}.png` //img.src가져오기 baseURL에서! 
                               // ---> 추가하는 모든 과정을 151번 반복해서 그림1,그림2 가져오고
                               //숫자1,숫자2 추가한다.


    pokemon.appendChild(newImg);
    pokemon.appendChild(label);
    container.appendChild(pokemon)

    //생성된 모든 div,span,img를 컨테이너 및 div(pokemon)에 추가한다
}
