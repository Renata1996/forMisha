/**
 * Created by Рената on 31.10.2016.
 */
public class Main {
    public static void main(String[] args) {

        double[][] a = {{0, -1, 3, 0, 0}, {0, 1, -2, 5, 0}, {0, 0, 4, -3, 0}};
        double[] d = {1, 2, -4};
        double[] pi = new double[a.length + 1];
        double[] qi = new double[a.length + 1];
        double[] xi = new double[a.length];
        pi[1] = a[0][2] / a[0][1];
        qi[1] = -d[0] / a[0][1];
        for (int i = 2; i < a.length + 1; i++) {
            pi[i] = pFunk(a[i - 1][i+1], a[i - 1][i ], a[i - 1][i - 1], pi[i - 1]);
            qi[i] = qFunk(a[i - 1][i - 1], qi[i - 1], d[i - 1], a[i - 1][i ], pi[i - 1]);
        }
       
        xi[a.length-1]=qi[a.length];
        for(int i=a.length-2;i>=0;i--){
            xi[i]=pi[i+1]*xi[i+1]+qi[i+1];
        }
        printArrays(a,d,pi,qi,xi);
    }

    public static double pFunk(double c, double b, double a, double p) {
        return (c / (b - a * p));
    }

    public static double qFunk(double a, double q, double d, double b, double p) {
         return ((a * q - d) / (b - a * p));
    }
    public  static void printArrays(double[][] a, double[] d, double[] pi, double[] qi, double[] xi){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.printf("%4f ",a[i][j]);
            }
            System.out.println(" x"+i+" = "+d[i]);
        }
        System.out.printf("%6s,%6s\n", "Pi","Qi");
        for(int i=1;i<a.length+1;i++)
        {
            if(pi[i]==-0.0 || qi[i]==-0.0)
                System.out.printf("%4f %4f\n",0.0,0.0);
            else
            System.out.printf("%4f %4f\n",pi[i],qi[i]);
        }
        System.out.println("X");
        for(int i=0;i<a.length;i++)
        {
            if(xi[i]==-0.0 )
                System.out.printf("%4f \n",0.0);
            else
                System.out.printf("%4f \n",xi[i]);
        }



    }
}
