import java.util.Scanner;

public class Romanos {
  
  public static Scanner entrada = new Scanner(System.in);

  public static String letrasRomanos = "IVXLCDM";
  public static int[] valoresRomanos = { 1, 5, 10, 50, 100, 500, 1000 };
  
  public static String numRomUser = new String();
  public static char[] arrayRom = {};
  public static String[] arrayGroupRom = {};
  public static String[] valueRomByArray = {};
  public static byte auxContador = 0;

  public static void main (String[] args) {
    System.out.println("Bienvenido");
    System.out.print("Por favor ingrese un número romano: ");
    numRomUser = entrada.nextLine();
    index();
    // repeat();
  }

  public static void index() {
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

          if( (i + 2) < arrayRom.length && arrayRom[i + 1] == arrayRom [i + 2] ) {
            System.out.println("Tres letras iguales: " + arrayRom[i]);

            // Para evitar que itere sobre las otras dos letras.
            i = (byte) (i + 2); 

            if( (i + 3) < arrayRom.length && arrayRom[i + 2] == arrayRom [i + 3] ) {
              System.out.println("Error, más  de 3 letras iguales");
              System.exit(1);
            }

          } else {
            System.out.println("Dos letras iguales: " + arrayRom[i]);
          }

        } else {
          System.out.println("--");
        }
      }
      
    } else {
      System.out.println("Sin igualdades");
      // Colocar valor de la letra que se haya ingresado
      // ToDo Verificar que sólo se ingresen letras validas
    }
  }

  public static byte sustituirValor (String v) {
    
    return 1;
  }

  public static int sumarIguales () {
    return 1;
  }

}
