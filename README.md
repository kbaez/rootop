# API ROOFTOP
![technology Java](https://img.shields.io/badge/technology-java-blue.svg)

API ROOFTOP Resolución de acertijo y endpoints de integración

## Pre-requisitos:

    Maven
    Java JDK 11

## Configure su proyecto
Clonar el repositorio desde Github `git clone https://github.com/kbaez/rootop.git`, sitúese en el directorio root del proyecto y ejecute el siguiente comando 
desde la consola `mvn clean install` para poder buildear el proyecto y descargar todas sus dependencias.
A continuación, puede ejecutar la aplicación con el comando `mvn spring-boot:run`

La aplicación ejecutará en el puerto `8080` de `localhost`.

## Api TEST

Todos los endpoints y ejemplos de request estan en esta coleccion postman:

### Local

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/15ce7eb025604c93d2e1)

## Uso de la API

### Obtener los blockes ordenados.

`POST` http://<i></i>localhost:8080/check/e9371ae9-fde2-4c85-ab40-6cef5391586d

##### `BODY`
```json
{
    "blocks": [
        "F0gUU2TQPe9fg023U1vPFcwna7IQQyr362RNenYOa2ReTty1aoIh1mYHXB2jGkW825VBEQl2Xkr06AGiQguJbMysx2pWDcVtSdE8",
        "KokzhmizqlWCXocJO1eXAuMW9JYx0Ba0HSW4TKnKtzI1chHoYQVXAKrF8go87g2c1CU1jjiRLiAi2hQs7IBn7huLokLKqFpZvFS4",
        "SjkZvFcLV77eOWiuL4zkyJsdjgRGAu6dyyrVBkcmISKv0YJXWmQiJNnEzKzIcWnkW5yaKiCJ0SenSrYPuRQY2TE7Y6p5KpNugIBk",
        "yJUg341qdmeEFuZqQCEFjfaM0zSVCt5mEliIdpjY0mBaiqqbojjy8J9BKiG9cPBFNfe8fRfttBemXnCmj4wXbj8Of04dGNwd5xER",
        "Wzsb03mUqttlQaywXiAL5v7ouRH963Ctq42AxExB7TN4DCQb1z8VzZBHOJJPR82RB3Hu04fMu12gYIrQ6jCLjQAhK2QsrOl4ONsD",
        "Zc8CzGBAFX1Gi24tCXipDRIFR0HtDc9KwxV2Pezwz2dHiZmqNbwNCPHDoY8CUUUhsG7JBOGru1UvkYNJATOs4JozuSi6BzVT0MdN",
        "UMd39X88TsokdFbHymURR2wm8nnkMqHVT17N7PrnLE2zo9ofRXYzF5xtiruD1cTVdRZsIYSw7QKoH8iq5PncoROjUbS9TFgQqZKC",
        "Nc3FGEQNHoEBYakpuw91DiWdnIhUvC3OiokkU2eoprarpoLnkp4aEGaz6jCBUl2ql4DrYTqJ2H8HSoU8bMTFJtMxovJIl5t95CIQ",
        "xJzqcjGFNR8sUspOzw7KMOgmidaZ1oqgBDKl6HwbzukCKHj1cJmxcCuDexTZQhozGJiR7W1ZM1tE6tbFXzSKzabYjpv2BFz0vm1q"
    ]
}
```

##### Response
**Status**: `200 OK`

##### `RESPONSE`
```json
{
    "encoded": "F0gUU2TQPe9fg023U1vPFcwna7IQQyr362RNenYOa2ReTty1aoIh1mYHXB2jGkW825VBEQl2Xkr06AGiQguJbMysx2pWDcVtSdE8xJzqcjGFNR8sUspOzw7KMOgmidaZ1oqgBDKl6HwbzukCKHj1cJmxcCuDexTZQhozGJiR7W1ZM1tE6tbFXzSKzabYjpv2BFz0vm1qSjkZvFcLV77eOWiuL4zkyJsdjgRGAu6dyyrVBkcmISKv0YJXWmQiJNnEzKzIcWnkW5yaKiCJ0SenSrYPuRQY2TE7Y6p5KpNugIBkUMd39X88TsokdFbHymURR2wm8nnkMqHVT17N7PrnLE2zo9ofRXYzF5xtiruD1cTVdRZsIYSw7QKoH8iq5PncoROjUbS9TFgQqZKCWzsb03mUqttlQaywXiAL5v7ouRH963Ctq42AxExB7TN4DCQb1z8VzZBHOJJPR82RB3Hu04fMu12gYIrQ6jCLjQAhK2QsrOl4ONsDyJUg341qdmeEFuZqQCEFjfaM0zSVCt5mEliIdpjY0mBaiqqbojjy8J9BKiG9cPBFNfe8fRfttBemXnCmj4wXbj8Of04dGNwd5xERKokzhmizqlWCXocJO1eXAuMW9JYx0Ba0HSW4TKnKtzI1chHoYQVXAKrF8go87g2c1CU1jjiRLiAi2hQs7IBn7huLokLKqFpZvFS4Nc3FGEQNHoEBYakpuw91DiWdnIhUvC3OiokkU2eoprarpoLnkp4aEGaz6jCBUl2ql4DrYTqJ2H8HSoU8bMTFJtMxovJIl5t95CIQZc8CzGBAFX1Gi24tCXipDRIFR0HtDc9KwxV2Pezwz2dHiZmqNbwNCPHDoY8CUUUhsG7JBOGru1UvkYNJATOs4JozuSi6BzVT0MdN"
}
```

### Obtiene el token

`GET` http://<i></i>localhost:8080/token/mail@gmail.com

#### Success Response
**Status**: `200 OK`

##### `RESPONSE`
```json
{
    "token": "e9371ae9-fde2-4c85-ab40-6cef5391586d"
}
```

### Obtiene el array de blocks

`GET` http://<i></i>localhost:8080/blocks/e9371ae9-fde2-4c85-ab40-6cef5391586d

#### Success Response
**Status**: `200 OK`

##### `RESPONSE`
```json
{
    "token": "e9371ae9-fde2-4c85-ab40-6cef5391586d"
}
```
