public class Test
{
 public Test () {
     System.out.print('\u000C');
 }
 
 public void test(){
 /*
     int[] b1 = {14, -2, -9, 1, 7, 14};
 ausgeben(b1);
 System.out.println("Minimum Mittelwert Maximum: " + minimum(b1) +" " + mittelwert(b1) + " " + maximum(b1));
 System.out.println();
 ausgeben(b1);
 System.out.println("Grösster ganz nach Rechts");
 grössterNachRechts(b1);
 ausgeben(b1);
 System.out.println();
 int[] b2 = {14, -2, -9, 1, 7, 2};
 ausgeben(b2);
 System.out.println("Aufsteigend sortieren (Version 1)");
 aufsteigendSortierenV1(b2);
 System.out.println();
 int[] b3 = {14, -2, -9, 1, 7, 7};
 ausgeben(b3);
 System.out.println("Aufsteigend sortieren (Version 2)");
 aufsteigendSortierenV2(b3);
 System.out.println();
 */
 int[] b4 = {14, -2, -9, 1, 7, 4, 14, 265 , 874, 13, 36, 685, 245, 57, 36,54,1,54,5,2,1,4,8,5,4,85,564,68,4};
 ausgeben(b4);
 System.out.println("Aufsteigend sortieren (Version 3)");
 aufsteigendSortierenV3(b4);
 System.out.println();
 /*
 int[] b5 = {14, -2, -9, 1, 7, 13};
 ausgeben(b5);
 System.out.println("Medianwert");
 System.out.println("Medianwert: " + medianwert(b5));
 System.out.println();
 */
 }
 
 private void ausgeben (int[] a) {
     for(int i=0;i<a.length;++i)
     {
        System.out.print(""+ a[i] + " ");
     }
     System.out.println();
 }
 
 private int minimum(int[] a) {
     int min=a[0];
     for(int i=1;i<a.length;++i)
     {
         if(a[i]<min)
         {
            min=a[i];
         }
     }
 return min;
 }
 
 private int maximum(int[] a) {
     int max=a[0];
     for(int i=1;i<a.length;++i)
     {
         if(a[i]>max)
         {
             max=a[i];
         }
     }
 return max;
 }
 
 private double mittelwert(int[] a) {
     double sum=0;
     for(int i=0;i<a.length;++i)
     {
         sum+=(double) a[i];
     }
     sum/=a.length;
     return sum;
 }
 
 private void grössterNachRechts (int[] a) {
     int res;
     for(int i=0;i<a.length-1;i++)
     {
         if(a[i]>a[i+1])
         {
            res=a[i+1];
            a[i+1]=a[i];
            a[i]=res;
         }
     }
 }
 
 private void aufsteigendSortierenV1(int[] a) {
     for(int i=0;i<a.length;++i)
     {
         grössterNachRechts(a);
     }
     ausgeben(a);
 }
 
 private void aufsteigendSortierenV2(int[] a) {
     int res;
     for(int j=1;j<a.length;++j)
     {
         for(int i=0;i<a.length-j;++i)
         {
             if(a[i]>a[i+1])
             {
                 res=a[i+1];
                 a[i+1]=a[i];
                 a[i]=res;
             }
         }
     }
 ausgeben(a);
 }
 
 private void aufsteigendSortierenV3(int[] a) {
 boolean fertig=false;
 boolean sortiert=true;
 int res;
     for(int j=1;(j<a.length)&&!fertig;++j)
     {
         for(int i=0;(i<a.length-j)&&!fertig;++i)
         {
             if(a[i]>a[i+1])
             {
                 res=a[i+1];
                 a[i+1]=a[i];
                 a[i]=res;
                 sortiert=false;
             }
         }
         if(minimum(a)==a[0]&&sortiert)
         {
            fertig=true;
         }
         else
         {
            sortiert=true;
         }
     }
 ausgeben(a);
 }
 
 private int medianwert(int[] a) {
 aufsteigendSortierenV2(a);
 int med;
    if(a.length/2==((int) a.length*0.5))
    {
        med=a[(int) a.length/2-1]+a[(int) (a.length/2)];
        med/=2;
    }
    else
    {
        med=a[(int) a.length/2];
    }
 return med;
 }
}