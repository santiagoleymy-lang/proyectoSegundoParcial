import java.util.Scanner;

public class Main {
    private static Scanner entrada = new Scanner(System.in);
    private static ListaProductos inventario = new ListaProductos();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;

                case 2:
                    eliminarProducto();
                    break;

                case 3:
                    inventario.mostrar();
                    break;

                case 4:
                    System.out.printf(
                            "Valor total del inventario: $%.2f%n",
                            inventario.calcularValorInventario()
                    );
                    break;

                case 0:
                    System.out.println("Programa terminado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.println();

        } while (opcion != 0);

        entrada.close();
    }

    public static void mostrarMenu() {
        System.out.println("=== INVENTARIO DE PRODUCTOS ===");
        System.out.println("1. Agregar producto");
        System.out.println("2. Eliminar producto");
        System.out.println("3. Mostrar inventario");
        System.out.println("4. Calcular valor total del inventario");
        System.out.println("0. Salir");
    }

    public static void agregarProducto() {
        System.out.print("Código: ");
        String codigo = entrada.nextLine().trim();

        System.out.print("Nombre: ");
        String nombre = entrada.nextLine().trim();

        double precio = leerDecimal("Precio: $");
        int cantidad = leerEntero("Cantidad: ");

        if (codigo.isEmpty() || nombre.isEmpty()) {
            System.out.println("El código y el nombre no pueden quedar vacíos.");
            return;
        }

        if (precio < 0 || cantidad < 0) {
            System.out.println("El precio y la cantidad no pueden ser negativos.");
            return;
        }

        Producto producto = new Producto(codigo, nombre, precio, cantidad);

        if (inventario.agregar(producto)) {
            System.out.println("Producto agregado.");
        } else {
            System.out.println("Ya existe un producto con ese código.");
        }
    }

    public static void eliminarProducto() {
        System.out.print("Escribe el código del producto que quieres eliminar: ");
        String codigo = entrada.nextLine().trim();

        if (inventario.eliminar(codigo)) {
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("No se encontró ese producto.");
        }
    }

    public static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = entrada.nextLine();

            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException error) {
                System.out.println("Escribe un número entero.");
            }
        }
    }

    public static double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = entrada.nextLine().replace(',', '.');

            try {
                return Double.parseDouble(texto);
            } catch (NumberFormatException error) {
                System.out.println("Escribe un número válido.");
            }
        }
    }
}