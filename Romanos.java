import java.util.Scanner;

public class Romanos {
  
  public static Scanner entrada = new Scanner(System.in);

  public static String letrasRomanos = "IVXLCDM";
  public static int[] valoresRomanos = { 1, 5, 10, 50, 100, 500, 1000 };
  public static char[] valoresError = { 'V', 'L', 'D' };
  

  public static String numRomUser = new String();
  public static char[] arrayRom = {};
  // Fila: Character - Column: Veces repetido
  public static char[] arrayAgrupadosLetras = new char[20];
  public static int[] arrayAgrupadosRepetidos = new int[20];
  public static String[] valueRomByArray = {};
  public static int auxContador = 0;

  public static void main (String[] args) {
    System.out.println("Bienvenido");
    System.out.print("Por favor ingrese un número romano: ");
    numRomUser = entrada.nextLine();
    // valueOfLetter();
    repeat();
  }

  public static void valueOfLetter() {
    arrayRom = numRomUser.toCharArray();
    byte i = 0;
    for(char a : arrayRom) {
      System.out.println("Valor de [" + a +"]: " +  valoresRomanos[letrasRomanos.indexOf(a)] );
      i++;
    }
  }

  public static void repeat() {
    arrayRom = numRomUser.toCharArray();

    if (arrayRom.length > 1) {
      
      // boolean igual;
      
      for (byte i = 0; (i + 1) < arrayRom.length; i++ ) {

        if( arrayRom[i] == arrayRom [i + 1] ) {

          if( arrayRom[i] == valoresError[0] || arrayRom[i] == valoresError[1] || arrayRom[i] == valoresError[2] ) {
            System.out.println("Error, no se pueden repetir de manera consecutiva los valores V, L o D");
            System.exit(1);
          }

          if( (i + 2) < arrayRom.length && arrayRom[i + 1] == arrayRom [i + 2] ) {
            System.out.println("Tres letras iguales: " + arrayRom[i]);
            asignar(arrayRom[i], 3);

            if( (i + 3) < arrayRom.length && arrayRom[i + 2] == arrayRom [i + 3] ) {
              System.out.println("Error, más  de 3 letras iguales");
              System.exit(1);
            }
            
            // Para evitar que itere sobre las otras dos letras.
            i = (byte) (i + 1);
            
          } else {
            asignar(arrayRom[i], 2);
            System.out.println("Dos letras iguales: " + arrayRom[i]);
          }
          
        } else {
          if( !( (i + 2) < arrayRom.length) ) {
            System.out.println("--");
            asignar(arrayRom[i+1], 1);
          }
        }

      }

    } else {
      System.out.println("Sólo una letra");
      asignar(arrayRom[0], 1);
      // Colocar valor de la letra que se haya ingresado
      // ToDo Verificar que sólo se ingresen letras validas
    }

    listarElementos();

  }
  public static void listarElementos () {
    for(int i = 0; i < auxContador; i++){
      System.out.println("::::::::::::::::::::: ");
      System.out.println("Los elementos: ");
      System.out.println("Letra: " + arrayAgrupadosLetras[i]);
      System.out.println("Valor: " + arrayAgrupadosRepetidos[i]);
    }
  }
  public static byte sustituirValor (String v) {
    
    return 1;
  }

  public static int sumarIguales () {
    return 1;
  }

  public static void asignar (char letra, int nRepetidos) {
    // System.out.println("Letra: " + letra + " Repetidos: " + nRepetidos);
    // System.out.println("--");
    arrayAgrupadosLetras[auxContador] = letra;
    arrayAgrupadosRepetidos[auxContador] = nRepetidos;
    System.out.println("--");
    // System.out.println("Letra: " + arrayAgrupadosLetras[auxContador] );
    // System.out.println("Repetidos: " + arrayAgrupadosRepetidos[auxContador] );
    auxContador++;
    System.out.println("auxContador: " + auxContador );
  }

}










