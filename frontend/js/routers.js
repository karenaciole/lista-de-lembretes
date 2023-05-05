// fetch the localhost:7070/api/lembrete
// get the criar lembrete method

// Path: frontend\js\routers.js

const api = {}


api.criarLembrete = async (lembrete) => {
  url = `http://localhost:7070/api/lembrete`
  
    try {
    const response = await fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(lembrete),
    });

    await response.json();
    return window.alert("Lembrete criado com sucesso!");
    
  } catch (error) {
    return console.log(error);
  }
}


api.getListaDeLembretes = async () => {
  url = `http://localhost:7070/api/lembretes`

  try {
    const response = await fetch(url);
    const lembretes = await response.json();
    
    lembretes.forEach(lembrete => {
      adicionaLembreteNaLista(lembrete);

      console.log(lembrete)
    });

  } catch (error) {
    return console.log(error);
  }
}

const adicionaLembreteNaLista = (lembrete) => {
  const test = `<li>${lembrete.nomeDoLembrete} ${lembrete.dataDoLembrete} </li>`;
  document.getElementById('lembretesList').insertAdjacentHTML('beforeend', test);
}


