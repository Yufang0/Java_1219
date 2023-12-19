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
				face[count] = temp/13; //商數
				point[count] = temp%13; //餘數
				printFace(face[count],point[count]);
				poker[temp]=1;
				count++;
			}
		}while(count!=5); //迴圈一直反覆到成功抽出五個不重複的亂數
		
		pokerSort(face,point);
		System.out.println("=== sorted ===");
		for(int i=0;  i<5; i++)
			printFace(face[i],point[i]);
		

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
	
	public static void pokerSort(int [] f, int [] p) {
		for(int i=0;i<p.length;i++)
			for(int j=i+1;j<p.length;j++)
				if(p[i]>=p[j]) {
					int temp=p[i]; //將p[i]與p[j]內容交換
					p[i]=p[j];
					p[j]=temp;
					temp=f[i]; //將f[i]與f[j]內容交換
					f[i]=f[j];
					f[j]=temp;
				}
					
				
	}

}
