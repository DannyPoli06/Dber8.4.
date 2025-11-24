public abstract class MaterialBiblioteca {

    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean estaPrestado;

    public MaterialBiblioteca(String codigo, String titulo, String autor, int anioPublicacion) {

        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío.");
        }

        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }

        if (autor == null || autor.isEmpty()) {
            throw new IllegalArgumentException("El autor no puede estar vacío.");
        }

        if (anioPublicacion < 1000 || anioPublicacion > 2025) {
            throw new IllegalArgumentException("El año debe estar entre 1000 y 2025.");
        }

        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.estaPrestado = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isEstaPrestado() {
        return estaPrestado;
    }

    public void setEstaPrestado(boolean estaPrestado) {
        this.estaPrestado = estaPrestado;
    }

    public void prestar() {
        if (estaPrestado) {
            throw new MaterialNoDisponibleException("El material ya está prestado.");
        }
        estaPrestado = true;
    }

    public void devolver() {
        estaPrestado = false;
    }

    // Métodos abstractos
    public abstract double calcularMultaPorRetraso(int diasRetraso);
    public abstract int calcularTiempoMaximoPrestamo();

    @Override
    public String toString() {
        return "Material{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", año=" + anioPublicacion +
                ", prestado=" + estaPrestado +
                '}';
    }
}

