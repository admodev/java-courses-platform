public class CursoDTO {
    private int idCurso;
    private String descripcion;
    private double precio;

    public int setIdCurso(int id) {
        this.idCurso = id;
        return this.idCurso;
    }

    public String setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this.descripcion;
    }

    public double setPrecio(double precio) {
        this.precio = precio;
        return this.precio;
    }
}