package study01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(args[0]);
        System.out.println(args[1]);
        /*
        1000, 1001번
        scanner 함수가 기억나지 않았을 때는 웹 화면에서 입력 받은 숫자를 받아와서 계산하는 방법을 생각함.
      	더하기 빼기는 쉽지만 어떻게 숫자를 입력 받을 건지?? Scanner 사용은 검색해서 적용함.  
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("a+b="+(a+b)+", a-b="+(a-b));
        
        1002번... 터렛?...
      	무슨 소리인지 하나도 모르겠다 사진도 뭔지 모르겠고.. 이럴때는 블로그 같은 것을 찾아봐야하나?
        
         1003번
         0과 1이 각각 몇 번 출력되는지 구하는 프로그램.   리턴 값을 받아서 변수 a,b를 1씩 증가시키면 되는 거 같은데..
         fibo() -> 0,1,1,2,3,5,8,13,21....     만들어 놓은 함수에서 0,1 리턴을 .. 어떻게 사용?해야하는지.. 
        */
        
        
        // 전체 문제를 순서대로 푸는 것이 어려워서 단계별로 푸는 문제에서 알고리즘 풀이를 시작함.. 
        // 2839번
        /*문제내용
         * 설탕을 정확하게 N킬로그램을 배달. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다. 최대한 적은 봉지들기.
         * 18kg 설탕을 배달해야 할 때, 5kg 3개와 3kg 1개를 배달
         * 11kg 설탕을 배달해야 할 때, 5kg 1개와 3kg 2개를 배달
         * 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력
         * 
         *생각한 풀이
         * '/'랑 '%' 사용해서 몫을 저장하고 그걸 더하면 봉지 수를 구할 수 있겠다. 
         * 5로 나눈 나머지를 3으로 나눠서 나온 나머지의 값이 0이면 5로 나눈 몫을 a에 저장하고 , 5로 나누어 떨어졌을 때도 a에 저장됨.
         * 5로 나눴을 때 나머지를 3으로 나눈 몫을 b에 저장한다. >>  a+b를 하면 봉지 수 를 구할 수 있다.. 
         * 문제를 제대로 이해하지 못해서 아래 주석처리 해 놓은 코드를 작성함.. 11kg이 왜 3봉지 인지 처음엔 생각도 못하고; 
         * 
         * 3<=N<=5000
         * 
         * 3  /  1  (3*1)
         * 4  /  -1  
         * 5  /  1  (5*1)
         * 6  /  2  (3*2)
         * 7  /  -1  
         * 8  /  2   (5*1,3*1)
         * 9  /  3   (3*3)
         * 10  /  2  (5*2)
         * 11  /  3  (5*1,3*2)
         * 12  /  4  (3*4)
         * 13  /  3  (5*2,3*1)
         * 14  /  4  (5*1,3*3)
         * 15  /  3  (5*3)
         * 16  /  4  (5*2,3*2)
         * 17  /  5  (5*1,3*4)
         * 18  /     (5*3,3*1)
         * 19  /  5  (5*2,3*3)
         * 26  /  8  (5*1,3*7)
         * */
        int n = scanner.nextInt();
        int a=0,b=0;
        
        // 5로 나누어 떨어지거나 3으로 나누어 떨어지는 경우는 몫이 봉지수가 될 수 있을 것 같다. 
        // for문을...써서 해본다면 ? i는 몇까지 줘야하나? 1000정도..?
        if(n%5==0 || n%3==0){
        	// n을 5나 3으로 나눴을 때 몫이 큰 경우를 찾는다? 
        	if(!(n%5==0)){	// 5로 나눴을 때 나머지가 있으면 3으로 나누면 될 것 같다
        		System.out.println("n/3 = "+n/3);
        	}else{System.out.println("n/5 = "+n/5);}
        } else{
        	for (n = 3; n < 20; n++) {        	
	        	boolean isOut = false;
	        	for(int i=1;i<=n / 5;i++){
	        		for(int j=1;j<=n / 3;j++){
	        			if((5*i)+(3*j)==n){
	        				System.out.println("i="+i+",j="+j+"-> i+j ="+(i+j));
	        				isOut = true;
	        				break;		// continue, break 사용 할 때.. 개념? 알아봐야 함.
	        			}
	        		}
	        		
	        		if (isOut == true) {
	        			break;
	        		}
	        	}
	        	
	        	// 위 조건을 타면 -1을 출력 안하고 싶은데 그럼 어떻게 조건을 줘야 할지.. ?
	        	if (isOut == false) {
	        		System.out.println("n=" + n);
	        	}
        	}
        }
        

        /*if((n%5)%3==0){        // 5로 나눈 나머지를 3으로 나눠서 나온 나머지의 값이 0이면
            a = n/5;        // 5로 나눈 몫을 a에 저장하고 , 5로 나누어 떨어졌을 때도 걸러지고...
            b = (n%5)/3;    // 5로 나눴을 때 나머지를 3으로 나눈 몫을 b에 저장한다
            System.out.println(a+b);
        }else if(n%3==0){    // 3으로 나누어 떨어지면 3kg짜리 봉지만 가져가면 되니깐...
            System.out.println(n/3);
        }else{
            System.out.println("-1");
        }*/
        

    }
    
    
    // 1003문제에 있던 피보나치 함수...
    public static int fibo(int x) {
        if(x==0) {
            System.out.print("0, ");
            return 0;
        }else if(x==1){
            System.out.print("1, ");
            return 1;
        }else {
            System.out.println("x ::"+x);
            System.out.println("x-1 ="+(x-1)+" // x-2 ="+(x-2));
            return fibo(x-1)+fibo(x-2);
        }
    }

}
