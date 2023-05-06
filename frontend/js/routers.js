// fetch the localhost:7070/api/lembrete
// get the criar lembrete method

// Path: frontend\js\routers.js

const api = {};

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
    window.alert("Lembrete criado com sucesso!");
    
  } catch (error) {
    return console.log(error);
  }
}


api.getListaDeLembretes = async () => {
  url = `http://localhost:7070/api/lembretes`

  try {
    const response = await fetch(url);
    const lembretes = await response.json();

    const lembretesPorData = new Map();
    
    lembretes.forEach(lembrete => {
      const data = new Date(lembrete.dataDoLembrete);
      const dataFormatada = `${data.getDate()}/${data.getMonth() + 1}/${data.getFullYear()}`
      
      if (!lembretesPorData.has(dataFormatada)) {
        lembretesPorData.set(dataFormatada, []);
      }
      lembretesPorData.get(dataFormatada).push(lembrete);

    });

    let html = '';
    lembretesPorData.forEach((lembretes, data) => {
      html += `<span class="data">${data}</span>`;

      lembretes.forEach(lembrete => {
        html += `
        <li>
          <p>
            <span id="nomeDoLembrete">${lembrete.nomeDoLembrete}</span>
            <button class="delete-lembrete" onclick="api.deletaLembrete('${lembrete.id}')">x</button>
          </p>
        </li>`;
      });
      
    });

    document.getElementById('lembretesList').innerHTML = html;
  } catch (error) {
    console.log(error);
  }
}

// const adicionaLembreteNaLista = (lembrete) => {
//   const test = `<li>${lembrete.nomeDoLembrete} ${lembrete.dataDoLembrete} </li>`;
//   document.getElementById('lembretesList').insertAdjacentHTML('beforeend', test);
// }

api.deletaLembrete = async (id) => {
  url = `http://localhost:7070/api/lembrete/${id}`

  try {
    const response = await fetch(url, {
      method: 'DELETE',
    });

    await response.json();
    window.alert("Lembrete deletado com sucesso!");
    
  } catch (error) {
    return console.log(error);
  }
}