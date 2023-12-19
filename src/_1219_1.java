import java.util.*;
public class _1219_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] poker = new int [52]; //用來管制目前已抽出的亂數
		int count = 0; //目前已抽出不重複的亂數數量
		
		do {
			int temp=(int)(Math.random()*52);
			if(poker[temp]==0) {
				System.out.println(temp);
				count++;
			}
		}while(count!=5); //迴圈一直反覆到成功抽出五個不重複的亂數

	}

}
