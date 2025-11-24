public class Revista extends MaterialBiblioteca {

    private int numeroEdicion;
    private String mesPublicacion;
    private boolean esEspecializada;

    public Revista(String codigo, String titulo, String autor, int anioPublicacion,
                   int numeroEdicion, String mesPublicacion, boolean esEspecializada) {

        super(codigo, titulo, autor, anioPublicacion);

        if (numeroEdicion <= 0) {
            throw new IllegalArgumentException("El número de edición debe ser mayor que 0.");
        }

        if (mesPublicacion == null || mesPublicacion.isEmpty()) {
            throw new IllegalArgumentException("El mes de publicación no puede estar vacío.");
        }

        this.numeroEdicion = numeroEdicion;
        this.mesPublicacion = mesPublicacion;
        this.esEspecializada = esEspecializada;
    }

    @Override
    public double calcularMultaPorRetraso(int diasRetraso) {
        if (diasRetraso < 0) {
            throw new IllegalArgumentException("Los días de retraso no pueden ser negativos.");
        }

        if (esEspecializada) {
            return diasRetraso * 2.0;
        } else {
            return diasRetraso * 0.75;
        }
    }

    @Override
    public int calcularTiempoMaximoPrestamo() {
        return esEspecializada ? 5 : 7;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Revista{" +
                "edicion=" + numeroEdicion +
                ", mes='" + mesPublicacion + '\'' +
                ", especializada=" + esEspecializada +
                '}';
    }
}
