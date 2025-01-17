Se trata de un proyecto multimódulo Maven.
Incluye un pom raíz con referencias a los 3 submódulos :application, domain y infrastructure,
estructurados de esta manera siguiendo con la arquitectura hexagonal.

Tecnologías:
- Java 17
- Maven
- Spring Boot 	<version>3.4.1</version>
- JPA
- Lombok
- Jakarta
- Mockito
- H2

Los datos se cargan automáticamente en H2 al iniciar el proyecto.

He incluido un archivo .puml en el directorio raíz que contiene el diagrama de clases del proyecto.
Para verlo, puedes pegar el código en el cuadro de texto en esta dirección: https://www.plantuml.com/plantuml/uml/
O usar directamente la extensión de VSCode PlantUML.



bcnc-prueba
│
├── application
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── bcnc
│                       └── prueba
│                           └── application
│                               ├── adapter
│                               │   └── PriceInteractionAdapter.java
│                               └── port
│                                   ├── PriceInteractionPort.java
│                                   └── PricePort.java
│
├── domain
│   └── model
│       └── Price.java
│
└── infrastructure
    └── src
        └── main
            └── java
                └── com
                    └── bcnc
                        └── prueba
                            └── infrastructure
                                ├── price
                                │   ├── persistence
                                │   │   ├── adapter
                                │   │   │   └── PriceAdapter.java
                                │   │   ├── mapper
                                │   │   │   └── PriceMapper.java
                                │   │   ├── model
                                │   │   │   └── PriceEntity.java
                                │   │   └── repository
                                │   │       └── PriceRepository.java
                                │   └── rest
                                │       ├── controller
                                │       │   └── PriceController.java
                                │       └── dto
                                │           ├── PriceRequest.java
                                │           └── PriceResponse.java
                                └── exception
                                    └── PriceNotFoundException.java