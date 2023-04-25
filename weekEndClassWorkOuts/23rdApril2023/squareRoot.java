package weekendWorOuts;

public class squareRoots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 8;
		for(double i = 1; i<10000; i++) {
			double m = i * i;
			if(x == m) {
				System.out.println(i);
				break;
			}
			else if (m > x) {
				i--;
				double srt = i;
				double op = (srt + 0.5) * (srt + 0.5);
				if (op <= x) {
					for(double j = 0.501; j < 1; j = j + 0.001) {
						if(((srt + j) * (srt + j)) >= x) {
							srt = srt + j;
							break;
						}
					}
					System.out.println(String.format("%1.3f", srt));
				}
				else if (op >= x) {
					for(double j = 0.000; j < 1; j = j + 0.001) {
						if(((srt + j) * (srt + j)) >= x) {
							srt = srt + j;
							break;
						}
					}
					System.out.println(String.format("%1.3f", srt));
				}
				break;
			}
		}
	}

}
