import java.awt.image.RescaleOp;
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
  public static int auxContador = 0;
  public static int[] resultSustitucionValores;

  public static int resultadoSuma = 0;


  public static void main (String[] args) {
    System.out.println("Bienvenido");
    System.out.print("Por favor ingrese un número romano: ");
    numRomUser = entrada.nextLine();
    repeat();
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
            asignarToArray(arrayRomUser[i], 3);

            if( (i + 3) < arrayRomUser.length && arrayRomUser[i + 2] == arrayRomUser [i + 3] ) {
              System.out.println("Error, más  de 3 letras iguales");
              System.exit(1);
            }
            
            // Para evitar que itere sobre las otras dos letras.
            // i = (byte) (i + 1);
            i = (byte) (i + 2);
            
          } else {
            asignarToArray(arrayRomUser[i], 2);
            i = (byte) (i + 1);
            // System.out.println("Dos letras iguales: " + arrayRomUser[i]);
          }
          
        } else {
          // System.out.println(Asignar 1 sólo elemento ----- ");
          asignarToArray(arrayRomUser[i], 1);
        }
        
      }
      
    } else {
      System.out.println("Sólo una letra");
      asignarToArray(arrayRomUser[0], 1);
      // Colocar valor de la letra que se haya ingresado
      // ToDo Verificar que sólo se ingresen letras validas
    }


    sustituirValor();

    System.out.println();
    System.out.println(":::::::::::::::::::::: <Resultados> :::::::::::::::::::");
    for (int i = 0; i < resultSustitucionValores.length; i++) {
      System.out.println("Resultado " + (i + 1) + ": " + resultSustitucionValores[i] );
    }
    System.out.println(":::::::::::::::::::::: </Resultados> ::::::::::::::::::");
    System.out.println();
    
    
    // Esto retornara el valor: 
    // sumar(resultSustitucionValores);
    

    System.out.println("Resultado Suma: " + evaluar() );
    
  }


  public static int evaluar () {

    // Sé que se ve horrible - Sigo pensando como mejorarlo - Lo siento :(

    if (auxContador == 1) { return suma( resultSustitucionValores[0] ); }
    if (auxContador == 2) { return suma( resultSustitucionValores[0], resultSustitucionValores[1] ); }
    if (auxContador == 3) { return suma( resultSustitucionValores[0], resultSustitucionValores[1], resultSustitucionValores[2] ); }
    
    if (auxContador == 4) {
      return suma( resultSustitucionValores[0], resultSustitucionValores[1] ) + suma( resultSustitucionValores[2], resultSustitucionValores[3] ) ; 
    }
    if (auxContador == 5) {
      return suma( resultSustitucionValores[0], resultSustitucionValores[1] ) + suma( resultSustitucionValores[2], resultSustitucionValores[3], resultSustitucionValores[4] );
    }
    if (auxContador == 6) {
      return suma( resultSustitucionValores[0], resultSustitucionValores[1] ) + suma( resultSustitucionValores[2], resultSustitucionValores[3] ) + suma( resultSustitucionValores[4], resultSustitucionValores[5] ) ; 
    }
    if (auxContador == 7) {
      return suma( resultSustitucionValores[0], resultSustitucionValores[1] ) + suma( resultSustitucionValores[2], resultSustitucionValores[3] ) + suma( resultSustitucionValores[4], resultSustitucionValores[5], resultSustitucionValores[6] );
    }
    
    else {
      return 0;
    }
  }


  public static int suma(int valor) {
    return valor;
  }

  public static int suma(int valorA, int valorB) {
    if (valorA > valorB) {
      return valorA + valorB;
    } else {
      if ( valorA == valoresRomanos[0] || valorA == valoresRomanos[2] || valorA == valoresRomanos[4]) {
        
        int indexA = 0;
        int indexB = 0;

        for ( int i = 0; i < valoresRomanos.length; i++ ) {
          if ( valoresRomanos[i] == valorA ) { indexA = i; }
          if ( valoresRomanos[i] == valorB ) { indexB = i; }
        }

        if ( (indexB - indexA) > 2 ) {
          System.out.println("El valor " + valorA + " no puede precidir a " + valorB );
          System.exit(1);
        }

        return valorB - valorA;

      } else {
        System.out.println("Error: el valor " + valorA + " es diferente de los valores: " + valoresRomanos[0] + ", " + valoresRomanos[2] + ", " + valoresRomanos[4]);
        System.exit(1);
        return 0;
      }
    }
  }

  public static int suma(int valorA, int valorB, int valorC) {
    return suma( valorA, suma(valorB, valorC) );
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

  public static void sustituirValor () {
    System.out.println();
    System.out.println( "::::::::::::::::::::: <Sustituidos> :::::::::::::::::::::" );
    resultSustitucionValores = new int[auxContador];
    for(int i = 0; i < auxContador; i++){
      System.out.println("Letra: " + arrayAgrupadosLetras[i]);
      System.out.println("Valor: " + valoresRomanos[letrasRomanos.indexOf(arrayAgrupadosLetras[i])] * arrayAgrupadosRepetidos[i] ) ;
      resultSustitucionValores[i] = valoresRomanos[letrasRomanos.indexOf(arrayAgrupadosLetras[i])] * arrayAgrupadosRepetidos[i];
    }
    System.out.println("----------------------------------------------------------");
    System.out.println( "Cantidad de elementos: " + auxContador );
    System.out.println( "::::::::::::::::::::: </Sustituidos> ::::::::::::::::::::");
    System.out.println("");
  }

  public static void asignarToArray (char letra, int nRepetidos) {
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










