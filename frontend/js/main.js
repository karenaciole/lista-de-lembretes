const isDataValida = (data) => {
    return validation.isDataEhPosteriorADataAtual(data) && validation.isFormatoDaDataValido(data)
}

const formEl = document.querySelector('.form');
formEl.addEventListener('submit', event => {
    
    event.preventDefault();

    const formData = new FormData(formEl); 
    const jsonObject = Object.fromEntries(formData);

    if (isDataValida(jsonObject.dataDoLembrete)) {
        api.criarLembrete(jsonObject);
        
    } else {
        window.alert("Data inválida! Insira uma data posterior à data atual e/ou no formato dd/mm/yyyy.");
    }

    formEl.reset();
});


api.getListaDeLembretes();
