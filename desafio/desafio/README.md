# Desafio Java Attornatus

# Como executar o projeto

Para executar o projeto, basta rodar o comando abaixo no terminal

```shell
mvn spring-boot:run
```

# APIs

## Cadastrar pessoa

```curl
curl --request POST \
  --url http://localhost:8080/api/pessoas \
  --header 'Content-Type: application/json' \
  --data '{
	"nome": "Rodrigo Ferreira",
	"dataNascimento": "1990-01-01",
	"enderecos": [
		{
			"logradouro": "rua 1",
			"cep": "12345678",
			"cidade": "Brasilia",
			"numero": "1",
			"principal": true
		},
		{
			"logradouro": "rua 1",
			"cep": "12345678",
			"cidade": "Brasilia",
			"numero": "1",
			"principal": false
		}
	]
}'
```

## Listar pessoa por id

```curl
curl --request GET \
  --url http://localhost:8080/api/pessoas/1
```

## Listar todas as pessoas

```curl
curl --request GET \
  --url http://localhost:8080/api/pessoas
```

## Listar enderecos pelo id da pessoa

```curl
curl --request GET \
  --url http://localhost:8080/api/enderecos/pessoa/2
```