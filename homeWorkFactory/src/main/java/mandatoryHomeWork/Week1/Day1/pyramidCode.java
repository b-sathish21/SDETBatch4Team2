package mandatoryHomeWork.week1.day1;

public class pyramidCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int line = 2;
        System.out.println("This is pyramid loop");
        for(int i = 1; i <= line ; i++) {
            System.out.println();
            int inrLpSpc = line - i;
            for(; inrLpSpc > 0; inrLpSpc--) System.out.print(" ");
            int inrLpStr = i + ( i - 1 );
            for(int j = 0; j < inrLpStr ; j++)  System.out.print("*");
        }
	}

}
