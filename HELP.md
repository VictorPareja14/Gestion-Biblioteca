# Gestión de Biblioteca

## Descripción

La aplicación **Gestión de Biblioteca** es un sistema básico para la gestión de libros en una biblioteca. Permite agregar, editar, listar, buscar y eliminar libros. Además, incluye una funcionalidad para marcar libros como leídos o pendientes.

## Características

- **Agregar Libro:** Permite agregar un nuevo libro con título, autor y género.
- **Listar Libros:** Muestra todos los libros en la base de datos.
- **Buscar Libro por ID:** Busca un libro por su identificador único.
- **Editar Libro:** Actualiza la información de un libro existente.
- **Eliminar Libro:** Elimina un libro de la base de datos.
- **Marcar Libro:** Cambia el estado de lectura de un libro (leído/pendiente).

## Tecnologías Utilizadas

- **Java 22:** Lenguaje principal de desarrollo.
- **Spring Boot 3.3.2:** Framework utilizado para la creación de aplicaciones Java con características de configuración automática.
- **Spring Data JPA:** Abstracción de persistencia para trabajar con bases de datos.
- **H2 Database:** Base de datos en memoria utilizada para desarrollo y pruebas.
- **Maven:** Herramienta de gestión de dependencias y construcción del proyecto.

## Requisitos Previos

- **Java 22:** [Descargar Java 22](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html)
- **Maven 3.8+:** [Descargar Maven](https://maven.apache.org/download.cgi)
- **Git:** [Descargar Git](https://git-scm.com/)

## Configuración del Proyecto

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu-usuario/gestion-biblioteca.git
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd gestion-biblioteca
    ```
3. Compila y empaqueta la aplicación con Maven:
    ```bash
    mvn clean package
    ```
4. Ejecuta la aplicación:
    ```bash
    mvn spring-boot:run
    ```

## Uso

Una vez que la aplicación esté en funcionamiento, puedes interactuar con ella desde la línea de comandos o mediante una herramienta que consuma el endpoint de tu aplicación, ya que está configurada para ejecutarse en el puerto `8090`.

### Ejemplos de Uso

- **Agregar Libro:** Al seleccionar la opción "1" en el menú principal, se te pedirá que ingreses los detalles del libro.
- **Listar Libros:** Selecciona la opción "2" para ver todos los libros.
- **Editar Libro:** Selecciona la opción "4" y sigue las instrucciones para actualizar los campos deseados.

## Contribuir

Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama para tu característica (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -m 'Añadir nueva característica'`).
4. Sube tus cambios (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

## Contacto

Si tienes alguna pregunta o sugerencia, no dudes en abrir un issue o contactar a [Víctor Pareja Navarro](mailto:vpareja@teknei.com).
