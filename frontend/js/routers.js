
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

    if(response.ok) {
      window.alert("Lembrete criado com sucesso!");
    }
    window.location.reload();
    
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


api.deletaLembrete = async (id) => {
  url = `http://localhost:7070/api/lembrete/${id}`

  try {
    const response = await fetch(url, {
      method: 'DELETE',
    });

    if (response.ok) {
      window.alert("Lembrete deletado com sucesso!");
    }
    
  } catch (error) {
    return console.log(error);
  }
}