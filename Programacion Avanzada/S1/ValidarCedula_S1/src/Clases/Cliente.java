package Clases;
public class Cliente{
    public String cedula;
    public String nombre;

    public Cliente() { //vacio
    }

    public Cliente(String cedula, String nombre) {//sobrecargado
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "cliente{" + "cedula=" + cedula + ", nombre=" + nombre + '}';
    }
}