# Appgate
[![Spring boot](https://img.shields.io/badge/Spring%20boot-2.5.5-green)](https://spring.io/)

## Desarollado por    

[Alexander Martinez](https://www.linkedin.com/in/ing-h-alexander-martinez-m/)


## Test Appgate

La prueba fue desarrollada usando tecnologías JAVA, Spring boot, Docker, en la prueba se creo un microservicio llamado SSE_TEST_API, el cual expone 3 servicios 2 POST y 1 GET.

Para dar solución al problema de comparar la similaridad de las palabras se investigo sobre el temas, y con ello se determino que existian librerias  para abordar el problema las cuales usan diferentes algoritmos para determinar una puntuación en el grado de similaridad.

* [java-string-similarity](https://github.com/rrice/java-string-similarity)

Para resolver el problema de los caracteres punycode se uso la libreria IDN
* [IDN](https://docs.oracle.com/javase/7/docs/api/java/net/IDN.html)

Se debe tener en cuenta que la API cuenta con una DB embebida [H2](https://www.h2database.com/) (Relacional), el proyecto puede aceptar cualquier DB relacional solo cambiando los parametros de conexión en el `application.yml`

## Prerequisitos

Para poder ejecutar la aplicación se debe teenr instalado lo siguiente:

* [Git](http://git-scm.com/)
* [Docker](https://www.docker.com/)
* [JAVA 11](https://www.oracle.com/java/technologies/downloads/) o superior
* [Gradle](https://gradle.org/)
 
## Instalación en local
* Clonar `https://github.com/alexhunter28/Appgate.git` este repositorio
* Ejecutar con su IDE preferido en el desarrollo de este proyecto se usó [IntelliJ](https://www.jetbrains.com/)
* Generar el JAR del proyecto usando el siguiente comando: `./gradlew build`
* Dentro del proyecto encontraremos el archivo `Dockerfile` que se encargará de crear la imagen del JAR previamente 
  generado usando el siguiente comando: `docker build --build-arg JAR_FILE=build/libs/\*.jar -t sse_test_api-1.0.0 .`
  
  Una ves finalizado el proceso podremos ver nuestra imagen en el dashboard de Docker
  
  <img width="1276" alt="Screen Shot 2021-10-05 at 2 46 45 PM" src="https://user-images.githubusercontent.com/36106982/136092733-ba29e570-532d-4417-a779-b13f4bb6b760.png">

* Para ejecutar nuestro proyecto podemos hacerlo directamete en el dashboard o ejecutando el siguiente comando:
  `docker run -p 8080:8080 sse_test_api-1.0.0`
  
  
<img width="1266" alt="Screen Shot 2021-10-05 at 2 53 17 PM" src="https://user-images.githubusercontent.com/36106982/136093376-b9297107-006d-4c6e-9d09-671358fb3232.png">



## Consumo de servicios

Para realizar el consumo de los servicios se adjunta un PostmanCollection con los respectivos ambientes locales

1. Servicio `Get  domain processed` : Obtiene la información almacenada de algún dominio previamente procesado

  * Servicio tipo `GET` URI: `/data/find/domain`
  * Parametros `domain`
  * Ejemplo: `http://localhost:8080/data/find/domain?domain=Bancolombia.com`

  * Estructura de Respuesta:

  ````
  [
      {
          "id": "String",
          "date": "String",
          "domainChecked": "String",
          "similarityDomainsFound": "String",
          "punycodeDomainsFound": "String",
          "validatedDomainList": "String"     
      }
  ]

  ````

2. Servicio `Check domain from static list` : Este servicio valida un dominio usando el archivo de texto `dominios.txt` y persiste la data procesada
  * Servicio tipo `POST` URI: `/data/check/static`
  * Parametros: `target`
  * Ejemplo: `http://localhost:8080/data/check/static?target=Bancolombia.com`

  * Estructura de Respuesta:
  ````
  {
      "dominio": String,
      "dominios_similares": [
          String,
          String
      ],
      "dominios_sim_punycode": [
          String,
          String
      ]

  }
  ````


3. Servicio `Check domain from dynamic list` : Este servicio valida un dominio usando una lista enviada en el body JSON de la petición ser y persiste la data procesada
  * Servicio tipo `POST` URI: `/data/check/dynamic`
  * Ejemplo Body: 
  ````
  {
    "target": "Bancolombia.com",
    "domainList" : [
        "olinmarcus.world.",
        "olympia.world.",
        "bancolombia1amano.com.co",
        "opendata.world.",
        "osrxj.world.",
        "ovazl.world."
    ]
  }
  ````
  * Ejemplo: `http://localhost:8080/data/check/dynamic`

  * Estructura de Respuesta:
  ````
  {
      "dominio": String,
      "dominios_similares": [
          String,
          String
      ],
      "dominios_sim_punycode": [
          String,
          String
      ]

  }
  ````

## Unit test

Los test unitario fueron desarrolados usando [JUNIT](https://junit.org/junit5/) y [Mockito](https://site.mockito.org/) Se adjuntan evidencias de los test unitarios, tambien se pueden ejecutar en el proyecto con el siguiente comando: `./gradlew test` y se genera el reporte con la ayuda de [Jacoco](https://www.jacoco.org/jacoco/trunk/index.html), los reportes se generan dentro de la siguiente ruta en el proyecto `build/reports/tests/test/index.html` y en `build/jacocoHtml/index.html`

![Screen Shot 2021-10-05 at 3 24 26 PM](https://user-images.githubusercontent.com/36106982/136097393-17350f68-80cc-4b7e-8f50-81fac58e9135.png)

![Screen Shot 2021-10-05 at 3 26 02 PM](https://user-images.githubusercontent.com/36106982/136097491-901a32c4-3f52-4a6c-b6b4-302621b18bee.png)





