public class MainClass {
	
	private static char[][] ar = new char[26][26];

	public static void main(String[] args) {
		fillArray();
		
		//String p = decryptCiphertext("DECEPTIVE", "ZICVTWQNGRZGVTWAVZHCQYGLMGJ");
		String p = decryptCiphertext("GANDALF", "YUPFEDX OS AHVPW VEEPAYJTT NQD QFOLHUE TX TEIHR QNTAY");
		System.out.println(p);
	}

	private static String decryptCiphertext(String kStr, String c) {
		kStr = kStr.toUpperCase();
		c = c.toUpperCase();
		char[] k = kStr.toCharArray();
		String p = "";
		
		int j = 0;
		for(int i = 0; i < c.length(); i++) {
			if(c.charAt(i) == ' ') {
				p += ' ';
			}
			else {
				p += Character.toString(search(k[j % k.length], c.charAt(i)));
				j++;
			}
		}
		
		return p;
	}
	
	private static char search(char kc, char cc) { //kc == Key Character, cc = Ciphertext Character
		for(int i = 0; i < ar.length; i++) {
			for(int j = 0; j < ar.length; j++) {
				if(ar[i][j] == cc && ar[i][0] == kc) {				
					return ar[0][j];
				}
			}
		}
		return '\0';
	}
	



	private static void fillArray() {
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				ar[i][j] = (char)(((j + i) % 26) + 65);
			}
		}
	}
	
	private static void displayArray() {
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				System.out.print(String.format("%2c", ar[i][j]) + " ");
			}
			System.out.println();
		}		
	}
}
