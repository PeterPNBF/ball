public class GlassPoint {
    public static void main(String[] args) {
        int[][] s = new int[101][50];
        int [] t = {1,2,4};
        int [] table2 = {2,2<<1,2<<3,2<<4,2<<5,2<<6,2<<7,2<<8,2<<9,
                2<<10,2<<11,2<<12,2<<13,2<<14,2<<15,2<<16,2<<17,2<<18,2<<19,
                2<<20,2<<21,2<<22,2<<23,2<<24,2<<25,2<<26,2<<27,2<<28,2<<29,
                2<<30};
        int flag = 1;
        flag ^=0;
        System.out.println(flag);
        System.out.println(Integer.MIN_VALUE>>2);
        System.out.println(Integer.MAX_VALUE);
    }
}
