public class InventarioLetras {
    private int  [] letras;
    private int totalCount;
    private int nonZeroCount; //cambio de nombre debido a que revisé mejor el PDF y creí
    //que los nombres een el eran meros ejemplos.


    public InventarioLetras(String data) {
        letras = new int [26];
        totalCount = 0;
        nonZeroCount = 0;


        for (int i = 0; i < data.length(); i++) {
            char c = Character.toLowerCase(data.charAt(i));

            if (c >= 'A' && c <= 'Z') {
                int indice = c - 'a';

                //aumenta el conteo partiendo desde 0 || La letra aparece por primera vez

                if(letras[indice] == 0) {
                    nonZeroCount++;
                }

                letras[indice]++;
                totalCount++;
            }
        }
    }
    //Cifrado Cesár
    public char encriptadoCesar(char letra) {
        letra = Character.toLowerCase(letra);
        if(letra < 'a' || letra > 'z') {
            throw new IllegalArgumentException("Caracter no válido");
        }
    }
}