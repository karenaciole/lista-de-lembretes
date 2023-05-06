const formEl = document.querySelector('.form');
formEl.addEventListener('submit', event => {
    
    event.preventDefault();

    const formData = new FormData(formEl); 
    const jsonObject = Object.fromEntries(formData);

    api.criarLembrete(jsonObject);
    formEl.reset();

});

// const ol = document.getElementById('lembretesList')

// api.getListaDeLembretes().then((lembretes = []) => {
//     ol.innerHTML += lembretes.map(convertListaDeLembretesToLi).join('');
// });

api.getListaDeLembretes();

// const deleteLembrete = document.querySelector('.delete-lembrete');

// deleteLembrete.addEventListener('click', event => {
//     const idLembrete = deleteLembrete.value; // get the id from the button
//     api.deleteLembrete(idLembrete);
//     // also delete the li element
//     event.target.parentNode.parentNode.remove(); // remove the li

//   });
