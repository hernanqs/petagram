package android.fundamentos.mascotas;

public class Mascota {
    private String nombre;
    private int rating;
    private int imgFoto;

    public int getImgFoto() {
        return imgFoto;
    }

    public int getRating() {
        return rating;
    }

    public String getNombre() {
        return nombre;
    }

    public Mascota(int imgFoto, String nombre, int rating) {
        this.imgFoto = imgFoto;
        this.nombre = nombre;
        this.rating = rating;
    }
}
