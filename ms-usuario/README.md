# MS-USUARIO

Microservicio con la funcion de registrar usuarios y telefonos

## Uso

```python
Realizar llamada POST a /login con el siguiente request
{
    "name":"Gonzalo",
    "password": "Pass"
}

Recuperar el token y utilizarlo en el header de los siguientes endpoints:

	Authorization:Bearer {token}

Registro de usuario:
Realizar llamada POST a /usuario/crear con el siguiente request:
{
    "name":"Gonzalo2",
    "email": "gonzalo@correo.cl",
    "password":"Pass",
    "phones":[
        {
            "number": 1234567,
            "citycode": "12",
            "countrycode": "10"
        }
    ]
}

Caso de error email no válido:
{
    "name":"Gonzalo3",
    "email": "gon-zalo@co-rreo.cl",
    "password":"Pass",
    "phones":[
        {
            "number": 1234567,
            "citycode": "12",
            "countrycode": "10"
        }
    ]
}

Caso de error email existente:
{
    "name":"Gonzalo",
    "email": "gonzalo@correo.cl",
    "password":"Pass",
    "phones":[
        {
            "number": 1234567,
            "citycode": "12",
            "countrycode": "10"
        }
    ]
}

Caso de error password con formato no válido:
{
    "name":"Gonzalo4",
    "email": "gonzalo@correo.cl",
    "password":"Pass134",
    "phones":[
        {
            "number": 1234567,
            "citycode": "12",
            "countrycode": "10"
        }
    ]
}

Consulta de usuario:
Realizar llamada POST a /usuario/consulta con el siguiente request:
{
    "name":"Gonzalo"
}

```
