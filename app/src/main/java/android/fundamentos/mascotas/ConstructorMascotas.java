package android.fundamentos.mascotas;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }


    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public ArrayList<Mascota> obtenerDatosMascotasFavoritas(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotasFavoritas();
    }

    public void insertarMascotas(BaseDatos db){
        ArrayList<Mascota> registros = db.obtenerTodasLasMascotas();

        // Dummy data
        if (registros.size() == 0) {

            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Roxy");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.default1);

            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Catty");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.default2);

            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Rob");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.default1);

            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Teddy");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.default2);

            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Toby");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.default1);

            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Rex");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.default2);

            db.insertarMascota(contentValues);

        }

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesmascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

}
