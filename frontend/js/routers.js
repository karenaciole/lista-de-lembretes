// fetch the localhost:7070/api/lembrete
// get the criar lembrete method

// Path: frontend\js\routers.js


const formEl = document.querySelector('.form');

formEl.addEventListener('submit', event => {
    
    event.preventDefault();

    const formData = new FormData(formEl); 
    const jsonObject = Object.fromEntries(formData);
    //const jsonData = JSON.stringify(jsonObject);

    fetch('http://localhost:7070/api/lembrete', {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(jsonObject), // body data type must match "Content-Type" header
    })
    .then(response => response.json())
    .then(data => window.alert("Lembrete criado com sucesso!"))
    .catch(error => console.log(error));
});
