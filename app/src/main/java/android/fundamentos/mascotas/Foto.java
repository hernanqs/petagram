package android.fundamentos.mascotas;

public class Foto {
    private int rating;
    private int imgFoto;


    public int getImgFoto() {
        return imgFoto;
    }

    public int getRating() {
        return rating;
    }


    public Foto(int imgFoto, int rating) {
        this.imgFoto = imgFoto;
        this.rating = rating;
    }

}
