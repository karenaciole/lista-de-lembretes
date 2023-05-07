
const validation = {};

validation.isDataEhPosteriorADataAtual = (dataInput) => {
    const dateString = dataInput.split("/")

    const data = new Date(+dateString[2], dateString[1] - 1, +dateString[0])
    const dataAtual = new Date();

    return data.getTime() > dataAtual.getTime();
}

validation.isFormatoDaDataValido = (data) => {
    const regex = /^\d{2}\/\d{2}\/\d{4}$/;
    return regex.test(data);
}