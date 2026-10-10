# Proyecto Segundo Parcial: Inventario de Productos

Programa de consola en Java para administrar productos. Utiliza una lista ligada implementada con clases propias.

## Descripción

El proyecto permite registrar productos y administrar un inventario desde un menú de consola. Cada producto tiene un código, nombre, precio y cantidad. La lista ligada permite agregar, mostrar y eliminar productos.

## Tecnologías Utilizadas

- Java
- Visual Studio Code

## Requisitos Previos

- Java JDK 8 o superior
- Visual Studio Code con Extension Pack for Java

## Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tu-usuario/proyectoSegundoParcial.git
   ```

2. Entra a la carpeta:

   ```bash
   cd proyectoSegundoParcial
   ```

3. Compila el programa desde la carpeta del proyecto:

   ```powershell
   New-Item -ItemType Directory out -Force
   javac -encoding UTF-8 -d out src\Main.java src\Producto.java src\Nodo.java src\ListaProductos.java
   ```

4. Ejecuta el programa:

   ```powershell
   java -cp out Main
   ```

## Uso

Al iniciar, aparece un menú en la consola. Escribe el número de la opción que quieras realizar:

1. Agregar un producto.
2. Eliminar un producto por código.
3. Mostrar los productos del inventario.
4. Calcular el valor total del inventario.
0. Salir.

## Características

- Lista ligada implementada con las clases `Nodo` y `ListaProductos`.
- Registro de productos con código, nombre, precio y cantidad.
- Eliminación de productos por código.
- Cálculo del valor total del inventario.

## Autores

- **Nombre:** Santiago Ley Rodriguez
- **Correo:** santiagoley.my@gmail.com