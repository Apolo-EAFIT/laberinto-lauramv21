import java.util.Scanner;
public class Laberinto {
    static int nMatriz;
    static int contador;
    static char[][] mat;
    static char[][] mat2;
    static Scanner sn = new Scanner(System.in);
    public static void main(String args[]) {
        contador = 0;
        nMatriz = sn.nextInt();
        if (nMatriz >= 3 && nMatriz <= 33) {
            mat = new char[nMatriz + 2][nMatriz + 2];
        } else {
            System.out.println("0");
        }
        for (int i = 0; i < nMatriz + 2; i++) {
            if (i == 0 || i == nMatriz + 1) {
                for (int j = 0; j < nMatriz + 2; j++) {
                    mat[i][j] = '#';
                }
            } else {
                String linea = sn.next();
                char[] fila = linea.toCharArray();
                int count = 0;
                for (int j = 0; j < nMatriz + 2; j++) {
                    if (j == 0 || j == nMatriz + 1) {
                        mat[i][j] = '#';
                    } else {
                        mat[i][j] = fila[count];
                        count++;
                    }
                }
            }
        }
        mat2=copiarMat(mat);
        int result=(recorrer(1,1)-2)*9;
        boolean conectado = false;
        if(mat[nMatriz][nMatriz]=='v'){
            conectado=true;
        }
        contador=0;
        mat=copiarMat(mat2);
        int result2 = (recorrer(nMatriz, nMatriz) - 2) * 9;
        if(conectado){
            System.out.println(result-18);
        }
        else{
            System.out.println(result+result2);
        }
    }

    private static int recorrer(int x, int y) {
        mat[x][y] = 'v';
        if (mat[x - 1][y] == '.') {
            recorrer(x - 1, y);
        } else if (mat[x - 1][y] == '#') {
            contador++;
        }
        if (mat[x + 1][y] == '.') {
            recorrer(x + 1, y);
        } else if (mat[x + 1][y] == '#') {
            contador++;
        }
        if (mat[x][y - 1] == '.') {
            recorrer(x, y - 1);
        } else if (mat[x][y - 1] == '#') {
            contador++;
        }
        if (mat[x][y + 1] == '.') {
            recorrer(x, y + 1);
        } else if (mat[x][y + 1] == '#') {
            contador++;
        }
        return contador;
    }

    private static char[][] copiarMat(char[][] origen){
        char[][] resultado= new char[nMatriz+2][nMatriz+2];
        for (int i = 0; i < nMatriz + 2; i++) {
            for (int j = 0; j < nMatriz + 2; j++) {
                resultado[i][j]=origen[i][j];
            }
        }
        return resultado;
    }
}
