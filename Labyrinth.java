/**
 * Created by Lauramv21 on 2/23/16.
 */

import java.util.Scanner;

public class Solucion {

    public static int main(String[] args) {
        char[][] laberinto;
        int nMatriz;
        String linea;
        int contador=0;
        Scanner in = new Scanner(System.in);
        System.out.println("");
        nMatriz = in.nextInt();

        if (nMatriz >= 3 && nMatriz <= 33){
            laberinto = new char[nMatriz][nMatriz];
        }
        else{
            return 0;
        }

        for(int i=0; i<nMatriz; i++){
            linea = in.next();
            char[] fila = linea.toCharArray();
            for(int j=0; j<nMatriz; j++){
                laberinto[i][j] = fila[j];
            }
        }

        for(int i=0; i<nMatriz; i++){
            for(int j=0; j<nMatriz; j++){
               boolean camino=(laberinto[i][j]!='#');
              if(laberinto[i][j]!='#'){
               if(i!=0){
                  //arriba
                   if(laberinto[i-1][j]=='#'){
                    contador++;
                    }
                }else{
                    if(j!=0){
                       contador++;
                    }
               }   
               if(j!=0){
                  //izquierda
                   if(laberinto[i][j-1]=='#'){
                       contador++;
                    }
                }else{
                    if(i!=0){
                       contador++;
                    }
                }
               if(i!=nMatriz-1){
                   //abajo
                    if(laberinto[i+1][j]=='#'){
                        contador++;
                    }
                }else{
                    if(j!=nMatriz-1){
                       contador++;
                    }
                }
               if(j!=nMatriz-1){
                   //derecha
                    if(laberinto[i][j+1]=='#'){
                        contador++;
                    }
                }else{
                    if(i!=nMatriz-1){
                        contador++;
                    }
                }
              }
            }
        }
        return contador;
     }
}
