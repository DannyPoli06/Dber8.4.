public class Libro extends MaterialBiblioteca {

    private int numPaginas;
    private String editorial;
    private boolean esDigital;

    public Libro(String codigo, String titulo, String autor, int anioPublicacion,
                 int numPaginas, String editorial, boolean esDigital) {

        super(codigo, titulo, autor, anioPublicacion);

        if (numPaginas <= 0) {
            throw new IllegalArgumentException("El número de páginas debe ser mayor a 0.");
        }

        if (editorial == null || editorial.isEmpty()) {
            throw new IllegalArgumentException("La editorial no puede estar vacía.");
        }

        this.numPaginas = numPaginas;
        this.editorial = editorial;
        this.esDigital = esDigital;
    }

    @Override
    public double calcularMultaPorRetraso(int diasRetraso) {
        if (diasRetraso < 0) {
            throw new IllegalArgumentException("Los días de retraso no pueden ser negativos.");
        }

        if (esDigital) {
            return diasRetraso * 0.50;
        } else {
            return diasRetraso * 1.00;
        }
    }

    @Override
    public int calcularTiempoMaximoPrestamo() {
        return esDigital ? 7 : 15;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Libro{" +
                "páginas=" + numPaginas +
                ", editorial='" + editorial + '\'' +
                ", esDigital=" + esDigital +
                '}';
    }
}

