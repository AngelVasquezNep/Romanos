import java.util.Scanner;

public class Romanos {
  
  public static Scanner entrada = new Scanner(System.in);

  public static String letrasRomanos = "IVXLCDM";
  public static int[] valoresRomanos = { 1, 5, 10, 50, 100, 500, 1000 };
  public static char[] valoresError = { 'V', 'L', 'D' };
  

  public static String numRomUser = new String();
  public static char[] arrayRomUser = {};
  public static char[] arrayAgrupadosLetras = new char[20];
  public static int[] arrayAgrupadosRepetidos = new int[20];
  public static String[] valueRomByArray = {};
  public static int auxContador = 0;

  public static int resultadoSuma = 0;


  public static void main (String[] args) {
    System.out.println("Bienvenido");
    System.out.print("Por favor ingrese un número romano: ");
    numRomUser = entrada.nextLine();
    // valueOfLetter();
    repeat();
  }

  public static void valueOfLetter() {
    arrayRomUser = numRomUser.toCharArray();
    byte i = 0;
    for(char a : arrayRomUser) {
      System.out.println("Valor de [" + a +"]: " +  valoresRomanos[letrasRomanos.indexOf(a)] );
      i++;
    }
  }

  public static void repeat() {
    arrayRomUser = numRomUser.toCharArray();

    errorLetras();

    if (arrayRomUser.length > 1) {
      
      for (byte i = 0; i < arrayRomUser.length; i++ ) {

        if( (i + 1) < arrayRomUser.length && arrayRomUser[i] == arrayRomUser [i + 1] ) {

          if( arrayRomUser[i] == valoresError[0] || arrayRomUser[i] == valoresError[1] || arrayRomUser[i] == valoresError[2] ) {
            System.out.println("Error, no se pueden repetir de manera consecutiva los valores V, L o D");
            System.exit(1);
          }

          if( (i + 2) < arrayRomUser.length && arrayRomUser[i + 1] == arrayRomUser [i + 2] ) {
            // System.out.println("Tres letras iguales: " + arrayRomUser[i]);
            asignar(arrayRomUser[i], 3);

            if( (i + 3) < arrayRomUser.length && arrayRomUser[i + 2] == arrayRomUser [i + 3] ) {
              System.out.println("Error, más  de 3 letras iguales");
              System.exit(1);
            }
            
            // Para evitar que itere sobre las otras dos letras.
            // i = (byte) (i + 1);
            i = (byte) (i + 2);
            
          } else {
            asignar(arrayRomUser[i], 2);
            i = (byte) (i + 1);
            // System.out.println("Dos letras iguales: " + arrayRomUser[i]);
          }
          
        } else {
          // System.out.println("Asignar 1 sólo elemento ----- ");
          asignar(arrayRomUser[i], 1);
        }
        
      }
      
    } else {
      System.out.println("Sólo una letra");
      asignar(arrayRomUser[0], 1);
      // Colocar valor de la letra que se haya ingresado
      // ToDo Verificar que sólo se ingresen letras validas
    }

    listarElementos();

    sustituirValor(arrayAgrupadosLetras, arrayAgrupadosRepetidos);
  }

  public static void errorLetras () {

    char[] charRom = letrasRomanos.toCharArray();

    for (char letter : arrayRomUser) {
      for (int i = 0; i < charRom.length; i++) {
        if(letter == charRom[i]) {
          break;
        }
        if( ( i + 1 ) == charRom.length ) {
          System.out.println(" Error: Letras romanas válidas: I, V, X, L, C, D y M ");
          System.exit(1);
        }
      }
    }
  }


  public static void listarElementos () {
    for(int i = 0; i < auxContador; i++){
      System.out.println("::::::::::::::::::::: ");
      System.out.println("Los elementos: ");
      System.out.println("Letra: " + arrayAgrupadosLetras[i]);
      System.out.println("Valor: " + arrayAgrupadosRepetidos[i]);
    }
  }

  public static void sustituirValor (char[] letras, int[] repetidos) {
    System.out.println("----------Valores----------");
    for (char letra : letras) {
      if( letra != arrayAgrupadosLetras[19]) {
        // System.out.println("FOR FOR FOR FOR");
        System.out.println( "Valor de " + letra + ": " +  valoresRomanos[letrasRomanos.indexOf(letra)] );
      }
    }
    System.out.println("----------/Valores----------");
  }

  public static void asignar (char letra, int nRepetidos) {
    // System.out.println("Letra: " + letra + " Repetidos: " + nRepetidos);
    // System.out.println("--");
    arrayAgrupadosLetras[auxContador] = letra;
    arrayAgrupadosRepetidos[auxContador] = nRepetidos;
    // System.out.println("--");
    // System.out.println("Letra: " + arrayAgrupadosLetras[auxContador] );
    // System.out.println("Repetidos: " + arrayAgrupadosRepetidos[auxContador] );
    auxContador++;
    // System.out.println("auxContador: " + auxContador );
  }




}










