# 📚 IronLibrary - Sistema de Gestión de Biblioteca

## Descripción

**IronLibrary** es una aplicación en Java que te permite gestionar una biblioteca: agregar libros, buscar libros, registrar préstamos a estudiantes y más, todo desde la consola.

Este proyecto tiene como objetivo practicar programación orientada a objetos y uso de bases de datos.

---

## Tecnologías utilizadas

- Java 
- JPA
- MySQL (tendrás que tener tu propia base de datos configurada)
- JUnit 5
- Spring Boot

---

## Estructura del Proyecto

- **models/** → contiene las clases principales:
  - `Author.java`
  - `Book.java`
  - `Student.java`
  - `Issue.java`
  - `LibraryHandler.java` → maneja todo el flujo de la aplicación (agregar, buscar, prestar libros, etc.)

- **repositories/** → contiene las clases para acceder a la base de datos:
  - `AuthorRepository.java`
  - `BookRepository.java`
  - `StudentRepository.java`
  - `IssueRepository.java`

---

## ¿Cómo funciona?

Cuando ejecutas el programa, te aparecerá un menú donde podrás elegir qué hacer.

Opciones disponibles:

1. Agregar un libro
2. Buscar libro por título
3. Buscar libro por categoría
4. Buscar libro por autor
5. Listar todos los libros y sus autores
6. Prestar un libro a un estudiante
7. Buscar qué libro tiene un estudiante
8. Salir del programa

Solo debes escribir el número de la opción que quieras y la propia aplicación te guiará en los siguientes pasos. 

## Tests

Hemos implementado tests unitarios utilizando **JUnit 5** para verificar el buen funcionamiento de todas las funciones del sistema.