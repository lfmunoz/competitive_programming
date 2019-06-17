public class Utils {


    int booleansToInt(boolean[] arr){
        int n = 0;
        for (boolean b : arr)
            n = (n << 1) | (b ? 1 : 0);
        return n;
    }


    static void print2Dx(int[][] arr) {
        for(int x = 0; x < arr.length; x++) {
            for(int y = 0; y < arr[x].length; y++) {
                System.out.printf("%d %d = %d, ", x, y, arr[x][y]);
            }
            System.out.printf("%n");
        }
    }

}
