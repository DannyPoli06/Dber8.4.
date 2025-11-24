import java.util.ArrayList;
import java.util.Random;

public class Biblioteca {

    private ArrayList<MaterialBiblioteca> catalogo;
    private String nombre;

    // Constructor
    public Biblioteca(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la biblioteca no puede estar vacío.");
        }
        this.nombre = nombre;
        this.catalogo = new ArrayList<>();
    }

    // Método estático: validar código
    public static void validarCodigo(String codigo) throws CodigoInvalidoException {
        if (!(codigo.startsWith("LIB-") || codigo.startsWith("REV-") || codigo.startsWith("DVD-"))) {
            throw new CodigoInvalidoException("Código inválido: " + codigo);
        }
    }

    // Método estático: generar código aleatorio
    public static String generarCodigoAleatorio(String tipo) {
        Random rand = new Random();
        int numero = rand.nextInt(900) + 100; // Genera un número entre 100 y 999
        switch (tipo.toUpperCase()) {
            case "LIBRO":
                return "LIB-" + numero;
            case "REVISTA":
                return "REV-" + numero;
            case "DVD":
                return "DVD-" + numero;
            default:
                return tipo.toUpperCase() + "-" + numero;
        }
    }

    // Agregar material
    public void agregarMaterial(MaterialBiblioteca m) throws CodigoInvalidoException {
        if (m == null) {
            throw new NullPointerException("El material no puede ser null.");
        }
        validarCodigo(m.getCodigo());
        catalogo.add(m);
    }

    // Buscar material
    public MaterialBiblioteca buscarMaterial(String codigo) {
        for (MaterialBiblioteca m : catalogo) {
            if (m.getCodigo().equals(codigo)) {
                return m;
            }
        }
        throw new MaterialNoEncontradoException("Material no encontrado: " + codigo);
    }

    // Prestar material
    public void prestarMaterial(String codigo) {
        MaterialBiblioteca m = buscarMaterial(codigo);
        if (m.isEstaPrestado()) {
            throw new MaterialNoDisponibleException("Material ya prestado: " + codigo);
        }
        m.prestar();
    }

    // Devolver material
    public double devolverMaterial(String codigo, int diasRetraso) {
        if (diasRetraso < 0) {
            throw new IllegalArgumentException("Los días de retraso no pueden ser negativos.");
        }
        MaterialBiblioteca m = buscarMaterial(codigo);
        m.devolver();
        return m.calcularMultaPorRetraso(diasRetraso);
    }

    // Listar materiales disponibles
    public void listarMaterialesDisponibles() {
        for (MaterialBiblioteca m : catalogo) {
            if (!m.isEstaPrestado()) {
                System.out.println(m);
            }
        }
    }

    // Ordenar por año (bubble sort)
    public void ordenarPorAnio() {
        int n = catalogo.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (catalogo.get(j).getAnioPublicacion() > catalogo.get(j + 1).getAnioPublicacion()) {
                    MaterialBiblioteca temp = catalogo.get(j);
                    catalogo.set(j, catalogo.get(j + 1));
                    catalogo.set(j + 1, temp);
                }
            }
        }
    }

    // Getter y Setter
    public ArrayList<MaterialBiblioteca> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<MaterialBiblioteca> catalogo) {
        this.catalogo = catalogo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // toString
    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", catalogo=" + catalogo +
                '}';
    }
}

