package BruteForce.boj_1182;
/* 
 * -------------------------------------
 * 수열 A = {-3, -7, 0, 3, 8}을 정렬시키면,{-7, -3, 0, 3, 8}
 * S = -7일때, 답 = {-7}, {-7,-3,3}, {-7,0}, {-7,-3,3,0}
 * 탐색 시작
 * K=0, A[0] = -7에 접근
 * -------------------------------------
 * 1. A[0]은 S일 때, return !
 * S가 -7이라면, 부분집합 개수를 증가시키고, return한다.
 * 그 이유는 수열이 정렬되어있기 때문에! 계속 진행해서, 그 다음 S가 0이 되는 경우는, -3 3 이나 0과같이
 * K를 증가시키면서 A[K]로 시작할 때의 연산에서 개수를 계산할 수 있다.
 * 결론만 말하자면, 나중에 어차피 계산될거란말이다.
 * -------------------------------------
 * No > 부분집합의 개수이기 때문에, S=-7일때, {-7}, {-7,-3,3}, {-7,0}, {-7,-3,3,0} 은 모두 다른 답이다.
 * 그렇다면, 위 처럼 return하되, 수학적으로 계산해서 개수를 구할 수 있지 않을까?
 * 해결방안, S=-7일때만 구하지 않고, S=0일때도 구한다. 그러면 S=-7일 때, 원래대로라면 답은 1개 인데, S=0일 때의 답을 더한다. 
 * 여기서 또 문제가... S=0을 구할때, 수열에 0을 포함하는 경우도 찾아야 하는가?
 * {-3,-2,0,2,3}이라는 수열이 있다고 가정하면, 이 알고리즘 답으론, {-3} 1개를 출력하고 끝낸다....
 * 멘붕-
 * 정렬을 절대값을 씌우고 하면 어떨까??...
 * 그래도 수열{0,0,0,0}이 주어지면, 이 방식대로는 답을 못구한다...
 * -------------------------------------
 * 2. A[0]은 S일 때, no return !
 * 그냥 브루트 포스로 완전 탐색 해보자...
 * 시간초과 안나려나?... 뿌리노드 가지수만 N!개인데
 * N이 최대 20까지밖에 안되므로 단순히 어떤수 를 선택하고 안하고로,모든 경우를 나타내어도 O(N*2^N)밖에 안된다.
 * ------------------------------------- 
 */

import java.util.*;
public class Main {
	static int Cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++) 
			A[i]=sc.nextInt();
	
		Arrays.sort(A);
		for (int i = 0; i < N; i++) {
			go(A, S, i, A[i]);
		}
		System.out.println(Cnt);

	}
	static void go(int[] A, int S, int K, int Sum) {
		if(Sum==S)
			Cnt++;
		for (int i = K+1; i < A.length; i++) {
			go(A, S, i, Sum+A[i]);
		}
	}
}