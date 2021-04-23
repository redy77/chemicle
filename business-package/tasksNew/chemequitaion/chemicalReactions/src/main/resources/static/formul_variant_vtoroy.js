const formAtoma = document.getElementById('forma-atoma');

async function atom(event) {
    event.preventDefault(); //когда метод на сервер не нужно отправлять
    const atom = formAtoma.querySelector('[name="input-atoma"]');
    let vivodAtoma = document.getElementById('div-atom'); //поиск див куда вставлять ответ от сервака
    console.log('формула для отправки на сервер', atom.value);
    let response = await fetch('http://localhost:8080//formula/rest/atom', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: atom.value
    });
    let content = await response.text(); //ответ сервера в виде строки
    console.log('Ответка от сервака', content);
    // const elevent = document.getElementById('div-atom');
    // document.body.removeChild(elevent);
    vivodAtoma.innerHTML +=
        '<h5>' + content + '</h5>';
}
formAtoma.addEventListener('submit', atom);

//для получения молекулы из атомов
const formMolecula = document.getElementById('forma_molecule');

async function molecula(event) {
    event.preventDefault(); //когда метод на сервер не нужно отправлять
    const atom1 = formMolecula.querySelector('[name="input-atoma1"]');
    const atom2 = formMolecula.querySelector('[name="input-atoma2"]');
    let strOtpravki = [atom1.value, atom2.value].join(' ');
    let vivodmolecula = document.getElementById('div-molecula'); //поиск див куда вставлять ответ от сервака
    console.log('Вторая формула', strOtpravki);
    let response = await fetch('http://localhost:8080//formula/rest/molecula', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: strOtpravki
    });
    let content = await response.text(); //ответ сервера в виде строки
    console.log('Ответка от сервака на вторую формулу', content);
    vivodmolecula.innerHTML +=
        '<h5>' + content + '</h5>';
}
formMolecula.addEventListener('submit', molecula);
