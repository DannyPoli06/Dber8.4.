//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //  Probar creación de material con título vacío
        try {
            MaterialBiblioteca libroError = new Libro("LIB-101", "", "Autor X", 2020, 100, "Editorial A", true);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        //  Probar creación con año < 1000
        try {
            MaterialBiblioteca libroError2 = new Libro("LIB-102", "Título", "Autor Y", 900, 200, "Editorial B", false);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Crear biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        try {
            // Agregar 8 materiales válidos
            MaterialBiblioteca libro1 = new Libro("LIB-201", "Java Básico", "Juan Pérez", 2021, 300, "Editorial A", true);
            MaterialBiblioteca libro2 = new Libro("LIB-202", "POO Avanzado", "Ana Gómez", 2019, 500, "Editorial B", false);

            MaterialBiblioteca revista1 = new Revista("REV-301", "Tech Monthly", "Equipo Tech", 2023, 10, "Marzo", true);
            MaterialBiblioteca revista2 = new Revista("REV-302", "Ciencia Hoy", "Dr. López", 2022, 5, "Abril", false);

            MaterialBiblioteca dvd1 = new DVD("DVD-401", "Inception", "Christopher Nolan", 2010, 148, "Ciencia Ficción", true);
            MaterialBiblioteca dvd2 = new DVD("DVD-402", "Matrix", "Wachowski", 1999, 136, "Acción", false);

            MaterialBiblioteca libro3 = new Libro("LIB-203", "Algoritmos", "Pedro Ruiz", 2020, 400, "Editorial C", true);
            MaterialBiblioteca revista3 = new Revista("REV-303", "Historia Hoy", "Equipo Historia", 2018, 7, "Mayo", false);

            // Agregar al catálogo
            biblioteca.agregarMaterial(libro1);
            biblioteca.agregarMaterial(libro2);
            biblioteca.agregarMaterial(revista1);
            biblioteca.agregarMaterial(revista2);
            biblioteca.agregarMaterial(dvd1);
            biblioteca.agregarMaterial(dvd2);
            biblioteca.agregarMaterial(libro3);
            biblioteca.agregarMaterial(revista3);

        } catch (CodigoInvalidoException e) {
            System.out.println("ERROR al agregar material: " + e.getMessage());
        }

        //  Realizar 4 préstamos exitosos
        try {
            biblioteca.prestarMaterial("LIB-201");
            biblioteca.prestarMaterial("REV-301");
            biblioteca.prestarMaterial("DVD-401");
            biblioteca.prestarMaterial("LIB-203");
            System.out.println("Préstamos exitosos realizados.");
        } catch (MaterialNoDisponibleException | MaterialNoEncontradoException e) {
            System.out.println("ERROR préstamo: " + e.getMessage());
        }

        //  Probar préstamo de material ya prestado
        try {
            biblioteca.prestarMaterial("LIB-201");
        } catch (MaterialNoDisponibleException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (MaterialNoEncontradoException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        //  Probar búsqueda de material inexistente
        try {
            biblioteca.buscarMaterial("LIB-999");
        } catch (MaterialNoEncontradoException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Devolver 2 materiales con retraso y mostrar multa
        try {
            double multa1 = biblioteca.devolverMaterial("LIB-201", 3);
            double multa2 = biblioteca.devolverMaterial("DVD-401", 5);
            System.out.println("Multa LIB-201: $" + multa1);
            System.out.println("Multa DVD-401: $" + multa2);
        } catch (MaterialNoEncontradoException e) {
            System.out.println("ERROR devolución: " + e.getMessage());
        }

        //  Listar materiales disponibles
        System.out.println("\nMateriales disponibles:");
        biblioteca.listarMaterialesDisponibles();

        // Ordenar por año y mostrar
        biblioteca.ordenarPorAnio();
        System.out.println("\nMateriales ordenados por año:");
        for (MaterialBiblioteca m : biblioteca.getCatalogo()) {
            System.out.println(m.getCodigo() + " - " + m.getTitulo() + " - " + m.getAnioPublicacion());
        }
    }
}
