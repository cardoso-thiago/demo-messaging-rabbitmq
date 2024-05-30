# Demo Spring Boot RabbitMQ

## Executando a aplicação

- Na raiz do projeto subir o compose com `docker-compose up`
- Subir a aplicação
- Executar o curl para envio da mensagem `curl -H "Content-Type: application/json" -d '{"key":"test","message":"Message Test"}' http://localhost:8080/sendMessage`
- Com isso, basta verificar o log para visualizar o envio e recebimento da mensagem.