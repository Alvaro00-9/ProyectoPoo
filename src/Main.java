public class InventarioLetras {

    private int [] letras;
    private int totalCount;
    private int nonZeroCount; //Cantidad de letras que sean distintas de 0

    //Decidí expresar mejor las ideas dentro del código, de forma más ordenada

   ///Método Auxiliar, para llamarlo sin tener que repetir su escritura en varias partes del texto, cosa había hecho en el prototipo de este código (No guardado)

    private int getIndice(char letra) {
       letra =  Character.toLowerCase(letra);
       if (letra < 'a' || letra > 'z') {
           throw new IllegalArgumentException("Carácter no Válido");
       }
       return letra - 'a';
    }

    ///Método Constructor
    public InventarioLetras(String data) {
        letras = new int[26];
        totalCount = 0;
        nonZeroCount = 0;
        /// Recorre el Sttring
        for (int i = 0; i < data.length(); i++) {
            char c = Character.toLowerCase(data.charAt(i));
            /// Verificación de letras Inglesas; En el orden del formato ASCI
            if  (c >= 'a' && c <= 'z') {
                int indice = c - 'a';

                /// La letra se cuenta por primera vez
                if (letras[indice] == 0) {
                    nonZeroCount++;
                }
                letras[indice]++;
                totalCount++;
            }
        }
    }

    /// ENCRIPTADO CESÁR

    public char encriptarCesar(char letra) {
        int indice = getIndice(letra);
        return (char) ((indice +3) % 26 + 'a');
    }

    /// Desencriptar Cesár

    public char decriptarCesar(char letra) {
        int indice = getIndice(letra);
        return (char) ((indice -3) % 26 + 'a');
    }


    /// ENCRIPTACIÓN

    public String encriptarPalabra(String palabra, int desplazamiento) {
        String resultado = "";
        for (int i = 0; i < palabra.length(); i++) {
            char c = Character.toLowerCase(palabra.charAt(i));
            if (c >= 'a' && c <= 'z') {
                int indice = c - 'a';

                char nueva =
                        (char) ((indice + desplazamiento) % 26 + 'a');
                resultado = resultado + nueva;

            } else{
                resultado = resultado + c;
            }
        }
        return resultado; ///Gran parte de este bloque lo hizo auttomaticamente el Compilador, pero al revisar ví que si complementaba correctamente al código
    }

    /// DESENCRIPTACIÓN
    public String desencriptarPalabra(String palabra, int desplazamiento) {
        String resultado = "";
        for (int i = 0; i < palabra.length(); i++) {
            char c = Character.toLowerCase(palabra.charAt(i));
            if (c >= 'a' && c <= 'z') {
                int indice = c - 'a';

                char nueva =
                        (char) ((indice - desplazamiento + 26) % 26 + 'a');
                resultado = resultado + nueva;
            }  else{
                resultado = resultado + c;
            }
        }
        return resultado;
    }


    /// MÉTODO GETTER O  GET
    public int get(char letra) { //Conteo de una letra
        return letras[getIndice(letra)];
    }
    /// SETTER O SET

    public void set(char letra, int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor Inválido");
        }

        int indice = getIndice(letra);

        /// Ajuste de totalCount
        totalCount -= letras[indice];
        totalCount += valor;

        /// Ajuste de nonZeroCount
        if (letras[indice] == 0 && valor > 0) {
            nonZeroCount++;
        }
        if (letras[indice] > 0 && valor == 0) {
            nonZeroCount--;
        }
        letras[indice] = valor;
    }


    /// SIze



















}