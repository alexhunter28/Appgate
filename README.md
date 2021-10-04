# Appgate
[![Spring boot](https://img.shields.io/badge/Spring%20boot-2.5.5-green)](https://spring.io/)


## Test Appgate

La prueba fue desarrollada usando tecnologías JAVA, Spring boot, Docker, en la prueba se creo un microservicio llamado SSE_TEST_API, el cual expone 3 servicios 2 POST y 1 GET.

Para dar solución al problema de comparar la similaridad de las palabras se investigo sobre el temas, y con ello se determino que existian librerias  para abordar el problema las cuales usan diferentes algoritmos para determinar una puntuación en el grado de similaridad.

* [java-string-similarity](https://github.com/rrice/java-string-similarity)

Para resolver el problema de los caracteres punycode se uso la libreria IDN
* [IDN](https://docs.oracle.com/javase/7/docs/api/java/net/IDN.html)
