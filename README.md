# Proyecto BCNC-Prueba

## Ejecución

Para ejecutar el proyecto, sigue estos pasos:

1. Ejecuta el siguiente comando para limpiar e instalar el proyecto:
   ```bash
   mvn clean install
   ```

2. Navega al directorio `infrastructure` y ejecuta el proyecto con Spring Boot:
   ```bash
   cd infrastructure
   mvn spring-boot:run
   ```

Este es un proyecto multimódulo Maven que sigue la arquitectura hexagonal. Incluye un `pom` raíz con referencias a los tres submódulos: `application`, `domain` e `infrastructure`.

## Tecnologías

El proyecto utiliza las siguientes tecnologías:

- **Java 17**
- **Maven**
- **Spring Boot**: versión `3.4.1`
- **JPA**
- **Lombok**
- **Jakarta**
- **Mockito**
- **H2**

Los datos se cargan automáticamente en H2 al iniciar el proyecto.

## Diagrama de Clases

He incluido un archivo `.puml` en el directorio raíz que contiene el diagrama de clases del proyecto. Para visualizarlo, puedes:

- Pegar el código en el cuadro de texto en [PlantUML](https://www.plantuml.com/plantuml/uml/)
- Usar directamente la extensión de VSCode PlantUML.