import java.util.*;
public class _1219_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] poker = new int [52]; //用來管制目前已抽出的亂數
		int count = 0; //目前已抽出不重複的亂數數量
		int [] face =  new int [5]; //記錄五張牌的花色
		int [] point = new int [5]; //記錄五張牌的點數
		
		do {
			int temp=(int)(Math.random()*52);
			if(poker[temp]==0) {
				System.out.println(temp);
				face[count] = temp/13;
				point[count] = temp%13;
				printFace(face[count],point[count]);
				poker[temp]=1;
				count++;
			}
		}while(count!=5); //迴圈一直反覆到成功抽出五個不重複的亂數
		
		
		

	}
	public static void  printFace(int f, int p) {
		switch(f) {
		case 0:
			System.out.print("Spade");break;
		case 1:
			System.out.print("Heart");break;
		case 2:
			System.out.print("Diamond");break;
		case 3:
			System.out.print("Club");break;
		}
		switch(p) {
		case 0:
			System.out.println("A");break;
		case 10:
			System.out.println("J");break;
		case 11:
			System.out.println("Q");break;
		case 12:
			System.out.println("K");break;
		default:
			System.out.println(p+1);break;
		}
	}

}
