package cr8.rrch.boaherramientas;

public class HerramientaVo {

private String nombre;
private String PN;
private  String CodigoBoa;
private int foto;


public HerramientaVo(){

}

    public HerramientaVo(String nombre, String PN, String codigoBoa, int foto) {
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
}
