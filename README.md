# *AREP - Laboratorio 5*
# TALLER DE DE MODULARIZACIÓN CON VIRTUALIZACIÓN E INTRODUCCIÓN A DOCKER Y A AWS

## Integrantes:

- James Alexander Torres

## Use Maven, Circle CI, AWS, Docker, GIT and GITHUB.
El taller consiste en crear una aplicación web pequeña usando el micro-framework de Spark java (http://sparkjava.com/). Una vez tengamos esta aplicación procederemos a construir un container para docker para la aplicación y los desplegaremos y configuraremos en nuestra máquina local. Luego, cerremos un repositorio en DockerHub y subiremos la imagen al repositorio. Finalmente, crearemos una máquina virtual de en AWS, instalaremos Docker , y desplegaremos el contenedor que acabamos de crear.

## Despliegue 
[![CircleCI](https://circleci.com/gh/JamesTorres99/laboratorio-AREP-5.svg?style=svg)](https://circleci.com/gh/JamesTorres99/laboratorio-AREP-5)

**Compilar el proyecto con maven**
```
mvn package
```

**Ejecutar el proyecto con maven**
```
java -cp target/classes;target/dependency/* edu.escuelaing.arep.App

```

**Ejecutar pruebas del proyecto con maven**
```
mvn test
```

**Obtener Documentacion del proyecto con maven**

El ejecutable de javadoc "index.html" se encuentra en target\site\apidocs al ejecutar el siguiente comando:
```
mvn javadoc:javadoc
```

**Ejecutando el programa **

debe usar el comando desde el directorio raíz usando Docker ToolBox
```
docker-compose up -d --scale web=3
```