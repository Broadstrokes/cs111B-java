public class Halloween {
   private int[] values;

   public Halloween() {
       this(3, 2);
   } 

   public Halloween(int x1, int x2) {
       values = new int[x1];

       for (int i = 0; i < values.length; i++) {
           values[i] = i + x2;
       }
   }

   public int getFirstValue() {
       return values[0];
   }
}