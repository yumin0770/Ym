const allLinks = document.querySelectorAll('a');

// for (let link of allLinks) {
//     link.innerText = 'I AM A LINK!!!!'
// }


for (let link of allLinks) {
    link.style.color = 'rgb(0, 108, 134)';
    link.style.textDecorationColor = 'magenta';
    link.style.textDecorationStyle = 'wavy'
    link.style.texta = 'wavy'
}

/* const imga = document.getElementsByTagName('img');
    imga.style.width= '150px';
    imga.style.color = '50%'; */

const input = document.createAttribute('input');
input.clasList.add('border');
input.setAttribute("type","password");