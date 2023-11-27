package DAO;

public class test {

    public static void main(String[] args) {
        try {
            Conexion c = new Conexion();
            c.Conectar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
