 //скрипт для отправки данных из формы с возможной формулой
const form = document.getElementById('forma_formuli');

async function retrieveFormValue(event) {
    event.preventDefault(); //когда метод на сервер не нужно отправлять
    const formula = form.querySelector('[name="formula"]');
    let vivodFormuli = document.querySelector('.card-body'); //поиск див куда вставлять ответ от сервака
    console.log('формула для отправки на сервер', formula.value);
    let response = await fetch('http://localhost:8080//formula/rest/string', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: formula.value
    });
    let content = await response.text(); //ответ сервера в виде строки
    console.log('Ответка от сервака', content);
    // listq.parentNode.getElementById('vivodFormuli'); //удаление
    vivodFormuli.innerHTML += '<h3>' + content + '</h3>'

}
form.addEventListener('submit', retrieveFormValue);

 const formMolecule = document.getElementById('forma_molecule');

  async function formMolecule1(button) {
     // button.preventDefault(); //когда метод на сервер не нужно отправлять
     const molecula = formMolecule.querySelector('[name="input_molecule1"]');
     let vivod = document.getElementById('div-molecules1'); //поиск див куда вставлять ответ от сервака
     console.log('формула для отправки на сервер', molecula.value);
     // let response = await fetch('http://localhost:8080//formula/rest/molecula', {
     //     method: 'POST',
     //     headers: {
     //         'Content-Type': 'application/json;charset=utf-8'
     //     },
     //     body: molecula.value
     // });
     // let content = await response.text(); //ответ сервера в виде строки
     // console.log('Ответка от сервака', content);
     // listq.parentNode.getElementById('vivod'); //удаление
      vivod.innerHTML += '<h3>' + molecula.value + '</h3>'

 }
 // formMolecule.addEventListener('molecul1', formMolecule1);