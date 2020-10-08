package android.fundamentos.mascotas;

import android.widget.ImageView;

public class Mascota {
    private String nombre;
    private int rating;
    private int imgFoto;

    public int getImgFoto() {
        return imgFoto;
    }

    public void setImgFoto(int imgFoto) {
        this.imgFoto = imgFoto;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Mascota(int imgFoto, String nombre, int rating) {
        this.imgFoto = imgFoto;
        this.nombre = nombre;
        this.rating = rating;
    }
}
