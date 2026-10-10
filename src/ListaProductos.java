public class ListaProductos {
    private Nodo cabeza;

    public ListaProductos() {
        cabeza = null;
    }

    public boolean agregar(Producto producto) {
        // Evitamos que haya dos productos con el mismo código.
        if (buscarPorCodigo(producto.getCodigo()) != null) {
            return false;
        }

        Nodo nuevo = new Nodo(producto);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;

            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevo);
        }

        return true;
    }

    public boolean eliminar(String codigo) {
        if (cabeza == null) {
            return false;
        }

        // Si el producto está en el primer nodo, movemos la cabeza.
        if (cabeza.getProducto().getCodigo().equalsIgnoreCase(codigo)) {
            cabeza = cabeza.getSiguiente();
            return true;
        }

        Nodo anterior = cabeza;
        Nodo actual = cabeza.getSiguiente();

        while (actual != null) {
            if (actual.getProducto().getCodigo().equalsIgnoreCase(codigo)) {
                anterior.setSiguiente(actual.getSiguiente());
                return true;
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false;
    }

    private Producto buscarPorCodigo(String codigo) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.getProducto().getCodigo().equalsIgnoreCase(codigo)) {
                return actual.getProducto();
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("El inventario está vacío.");
            return;
        }

        Nodo actual = cabeza;

        while (actual != null) {
            System.out.println(actual.getProducto());
            actual = actual.getSiguiente();
        }
    }

    public double calcularValorInventario() {
        double total = 0;
        Nodo actual = cabeza;

        while (actual != null) {
            total = total + actual.getProducto().getValorTotal();
            actual = actual.getSiguiente();
        }

        return total;
    }
}