## 💻 Sobre o projeto

Magnum FIPE

---

## ⚙️ Funcionalidades

1. Criar um serviço REST na API-1 para acionar a ”carga inicial” dos dados de
veículos.

2. Implementar a lógica na API-1 para buscar as "marcas" no serviço da FIPE
(https://deividfortuna.github.io/fipe/).

3. Configurar uma “Fila” para receber as "marcas" da API-1 e enviar uma por vez
para a API-2 para processamento assíncrono.

4. Implementar a lógica na API-2 para buscar os "códigos" e "modelos" dos
veículos no serviço da FIPE com base nas "marcas" recebidas da fila.

5. Implementar a lógica na API-2 para salvar no banco de dados “SQL” as
informações de "código", "marca" e "modelo" dos veículos encontrados no
serviço da FIPE.

6. Criar um serviço REST na API-1 para buscar as "marcas" armazenadas no
banco de dados.

7. Criar um serviço REST na API-1 para buscar os "códigos", "modelos" e
“observações” dos veículos por "marca" no banco de dados.

8. Criar um serviço REST na API-1 para salvar os dados alterados do veículo,
como: "modelo" e “observações” no banco de dados.




Para executar o projeto, é necessário ter instalado na máquina:
1) Mysql server;
2) RabbitMQ com uma fila de nome 'marcas.recebidas' configurada.
