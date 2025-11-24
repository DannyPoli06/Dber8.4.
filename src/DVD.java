public class DVD extends MaterialBiblioteca {

    private int duracionMinutos;
    private String genero;
    private boolean tieneSubtitulos;

    public DVD(String codigo, String titulo, String autor, int anioPublicacion,
               int duracionMinutos, String genero, boolean tieneSubtitulos) {

        super(codigo, titulo, autor, anioPublicacion);

        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor a 0 minutos.");
        }

        if (genero == null || genero.isEmpty()) {
            throw new IllegalArgumentException("El género no puede estar vacío.");
        }

        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
        this.tieneSubtitulos = tieneSubtitulos;
    }

    @Override
    public double calcularMultaPorRetraso(int diasRetraso) {
        if (diasRetraso < 0) {
            throw new IllegalArgumentException("Los días de retraso no pueden ser negativos.");
        }
        return diasRetraso * 1.50;
    }

    // Sobrecarga: multa por estreno
    public double calcularMultaPorRetraso(int diasRetraso, boolean esEstreno) {
        double multa = calcularMultaPorRetraso(diasRetraso);
        return esEstreno ? multa * 2 : multa;
    }

    @Override
    public int calcularTiempoMaximoPrestamo() {
        return 3;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | DVD{" +
                "duracion=" + duracionMinutos +
                ", genero='" + genero + '\'' +
                ", subtitulos=" + tieneSubtitulos +
                '}';
    }
}
