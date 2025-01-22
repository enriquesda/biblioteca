public class GestionUsuarios {

    private Usuario listaUsurs[];
    private int lleno;
    private final int tamaño = 100;

    public GestionUsuarios() {
        this.listaUsurs = new Usuario[tamaño];
        this.lleno = 0;
    }

    public void añadirUsuario(Usuario usur) {
        listaUsurs[lleno] = usur;
        lleno++;
    }

    public int buscarIndice(String usur) {
        int busco=-1;
        for (int i = 0; i < lleno && busco==-1; i++) {
            if(listaUsurs[i].getNombre().equals(usur)){
                busco=i;
            }
        }

        return busco;
    }
}



