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