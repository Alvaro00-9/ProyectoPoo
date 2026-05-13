public class InventarioLetras {
    private int [ ] Letras; // letras almacenadas
    private int totalcnt; //cantidad de letras cuyo conteo general resulta distinto de 0
    private int conteovacio;


    public InventarioLetras(String datos) {
        letras = new int [27];
        totalcnt = 0;
        conteovacio = 0;
    }
}