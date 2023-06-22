package mandatoryHomeWork.week1.day2;

public class diamondPatternCode {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int line = 5;
		if(line<3 || (line%2)==0) throw new Exception("can't create diamond pattern");
        System.out.println("This is Diamond Patern");
        for(int i = 1; i <= line ; i++) {
        	if (i<=((line/2)+1)) {
        		System.out.println();
                int inrLpSpc = line - i;
                for(; inrLpSpc > 0; inrLpSpc--) System.out.print(" ");
                int inrLpStr = i + ( i - 1 );
                for(int j = 0; j < inrLpStr ; j++)  System.out.print("*");
        	}
        	else if (i>((line/2)+1)) { 
    			int inrLpStr = line;      		 
        		for (int l=1;l<=(line/2);l++) {
        			inrLpStr = inrLpStr-2; 
            		System.out.println("");
        			int inrLpSpc = l+2;
        			for(; inrLpSpc > 0; inrLpSpc--) System.out.print(" ");
                    for(int k = 0; k < inrLpStr ; k++)  System.out.print("*");
        		}
        		break;
        	}
            
        }
	}
}
