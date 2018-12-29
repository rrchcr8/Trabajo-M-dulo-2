package cr8.rrch.boaherramientas;

import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import android.util.Base64;


public class HerramientaVo {

private String nombre;
private String PN;
private  String CodigoBoa;
//private int foto;
private String dato;
private Bitmap imagen;

public HerramientaVo(){

}


    public HerramientaVo(String nombre, String PN, String codigoBoa) {
        this.nombre = nombre;
        this.PN = PN;
        CodigoBoa = codigoBoa;
        //this.foto = foto;
    }


public String getCodigoBoa() {
    return CodigoBoa;
}

    public void setCodigoBoa(String codigoBoa) {
        CodigoBoa = codigoBoa;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;

        try {
            byte[] byteCode= Base64.decode(dato,Base64.DEFAULT);
            //this.imagen= BitmapFactory.decodeByteArray(byteCode,0,byteCode.length);

            //int alto=100;//alto en pixeles
            //int ancho=150;//ancho en pixeles

            //Bitmap foto=BitmapFactory.decodeByteArray(byteCode,0,byteCode.length);
            this.imagen= BitmapFactory.decodeByteArray(byteCode,0,byteCode.length);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPN() {
        return PN;
    }

    public void setPN(String PN) {
        this.PN = PN;
    }





/*  public HerramientaVo(String nombre, String PN, String codigoBoa, int foto) {
        this.nombre = nombre;
        this.PN = PN;
        CodigoBoa = codigoBoa;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPN() {
        return PN;
    }

    public void setPN(String PN) {
        this.PN = PN;
    }

    public String getCodigoBoa() {
        return CodigoBoa;
    }

    public void setCodigoBoa(String codigoBoa) {
        CodigoBoa = codigoBoa;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
*/
}
