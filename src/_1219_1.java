//411422259 蕭羽芳
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
				face[count] = temp/13; //商數
				point[count] = temp%13; //餘數
				printFace(face[count],point[count]);
				poker[temp]=1;
				count++;
			}
		}while(count!=5); //迴圈一直反覆到成功抽出五個不重複的亂數
		
		/*int [] face = {1,3,4,2,2}; 
		int [] point = {8,7,7,8,7};  //假設抽到的牌，確認程式碼正確性*/
		
		pokerSort(face,point);
		System.out.println("=== sorted ===");
		for(int i=0;  i<5; i++)
			printFace(face[i],point[i]);
		
		if(checkFlush(face)) {
			if(checkStraight(point))
				System.out.println("Straight Flush  ! ! !");
			else if(checkRoyal(point))
				System.out.println("Royal Flush  ! ! !"); }
		else {
			if(checkStraight(point))
				System.out.println("Straight ! !");
			else if(checkRoyal(point))
				System.out.println("Royal ! !"); }
		
		//Counts(point)回傳值對照表　1:一對、2:兩對、3:三條、4:鐵支、5:葫蘆
		switch(counts(point)) {
		case 0:
			System.out.println("No special card type ...");break;
		case 1:
			System.out.println("One Pair !");break;
		case 2:
			System.out.println("Two Pairs !");break;
		case 3:
			System.out.println("Three of a kind ! !");break;
		case 4:
			System.out.println("Four of a kind ! ! !");break;
		case 5:
			System.out.println("Full House ! ! !");break;
		}
	
	}
	
	public static int  counts(int [] p) {
		int count = 0; //計算單個點數重複次數
		int [] sumCount = {0,0,0,0};
		//for迴圈在計算每個點數跟此點數後面的點數重複次數
		//如此數字重複了i次，就會使sumCount[i]++，紀錄重複幾次的點數有幾個。
		for(int i=0;i<p.length-1;i++) {
			count = 0;
			for(int j=i+1;j<p.length;j++)
				if(p[i]==p[j])
					count++;
			sumCount[count]++;
		}
		//sumCount對照表　1:一對[ ,1,0,0]、2:兩對[ ,2,0,0]、3:三條[ ,1,1,0]、4:鐵支[ ,1,1,1]、5:葫蘆[ ,2,1,0] *計算重複0次的忽略
		if(sumCount[3]==1)
			return(4);
		else if(sumCount[2]==1&&sumCount[1]==2)
			return(5);
		else if(sumCount[2]==1&&sumCount[1]==1)
			return(3);
		else if(sumCount[1]==2)
			return(2);
		else if(sumCount[1]==1)
			return(1);
		else
			return(0);
	}
	
	//判斷是否為同花
		public static boolean checkFlush(int [] f) {
			for(int i=0;i<f.length-1;i++)
				if(f[i]!=(f[i+1]))
					return false;
			return true;
		}
		
	//判斷是否為大順
	public static boolean checkRoyal(int [] p) {
		if(p[0]==0 & p[1]==9 & p[2]==10 & p[3]==11 & p[4]==12)
				return true;
		return false;
	}
	
	//判斷是否為順子
	public static boolean checkStraight(int [] p) {
		for(int i=0;i<p.length-1;i++)
			if(p[i]!=(p[i+1]-1))
				return false;
		return true;
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
