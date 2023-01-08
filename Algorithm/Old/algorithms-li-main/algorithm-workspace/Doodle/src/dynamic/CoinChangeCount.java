package dynamic;

import java.util.HashMap;
import java.util.Objects;

public class CoinChangeCount {
	// pure recursion
	public static int countChange1(int[] s, int p, int t) {
		if(t == 0)
			return 1;
		if(t<0)
			return 0;
		if(t>=0 && p<0)
			return 0;

		return countChange1(s, p-1, t)+countChange1(s, p, t-s[p]);
	}

	static class Key{
		int p;
		int t;
		Key(int p, int t){
			this.p = p;
			this.t = t;
		}
		@Override
		public boolean equals(Object o) {
			if(!(o instanceof Key)) return false;
			Key ok = (Key)o;
			if(ok.p == p && ok.t == t)	return true;
			return false;
		}
		@Override
		public int hashCode() {
			return Objects.hash(p,t);
		}
	}
	// Using dynamic programming
	static HashMap<Key,Integer> table = new HashMap<Key, Integer>();
	public static int countChange2(int[] s, int p, int t) {
		Key k = new Key(p,t);
		if(table.containsKey(k))
			return table.get(k);
		if(t == 0) {
			table.put(k, 1);
			return 1;
		}
		if(t<0) {
			table.put(k,0);
			return 0;
		}
		if(t>=0 && p<0) {
			table.put(k,0);
			return 0;
		}
		int l = countChange2(s, p-1, t);
		Key kl = new Key(p-1,t);
		int r = countChange2(s, p, t-s[p]);
		Key kr = new Key(p, t-s[p]);
		table.put(kl, l);
		table.put(kr, r);
		return l+r;
	}


	public static void main(String[] args) {
		int[] coins = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		System.out.println(countChange1(coins,coins.length-1, 100));
		System.out.println(countChange2(coins,coins.length-1, 100));
	}
}
