import fetch from 'node-fetch';

describe('API testes', () => {

    test('GET /lembretes deve retornar uma lista de lembretes', async () => {
        const response = await fetch('http://localhost:7070/api/lembretes');
        expect(response.status).toBe(200);
        const lembretes = await response.json();
        expect(lembretes.length).toBeGreaterThan(0);
    });

    test('POST /lembrete deve criar um novo lembrete', async() => {
        const lembrete = {
            nomeDoLembrete: 'Aprender um novo idioma',
            dataDoLembrete: '19/07/2023',
        };

        const response = await fetch('http://localhost:7070/api/lembrete', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(lembrete),
        });
        expect(response.status).toBe(201);
        const novoLembrete = await response.json();
        expect(novoLembrete.id).toBeTruthy(); // id é um campo obrigatório
        expect(novoLembrete.nomeDoLembrete).toBe(lembrete.nomeDoLembrete); // nomeDoLembrete é um campo obrigatório
        expect(novoLembrete.dataDoLembrete).toBe(lembrete.dataDoLembrete); // dataDoLembrete é um campo obrigatório

    });
});
