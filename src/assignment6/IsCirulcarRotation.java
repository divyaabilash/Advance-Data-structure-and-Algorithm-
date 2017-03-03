package assignment6;

/*
 *  Write a linear-time algorithm bool IsCircularRotation(string s, string t) 
 *  to determine whether t is obtained by shifting each leter of s by some distance d 
 *  (wrapping around when necessary). 
 *  For example arc and car are cyclic rotations of each other.
 */

public class IsCirulcarRotation {

	/*
	 * function thats calculation z values
	 */

	public boolean Calculate_z(String A, String B) {
		
		/*
		 * Pattern matching is done by concatenation two strings with a special character
		 * B#A
		 * so that , the z value of the substring matching to the pattern is equal to the length of pattern
		 * 
		 *  i.e. z[i]==b.length
		 *  
		 *  if the z values have the length of the pattern, then the pattern is existing in the string.
		 */
		String c = B + "#" + A;

//		creating the array of character of the string
		
		char[] A_C = new char[c.length()];
		A_C = c.toCharArray();	
		int[] z_value = new int[A_C.length];
		z_value[0] = 0;
		int left = 0, right = 0, current = 0, z = 0;
		for (current = 1; current < A_C.length; current++) {
			/*
			 * If the current index is inside the box value and value of
			 * z[current-left] is less then number elements in right-current+1;
			 * , the no need of calculating the z_value. we are place z_value as
			 * z[current]=z[current-left];
			 * 
			 * else if current <right and z[current-left]>number of elements in
			 * right-current+1 then we have to recalculate the z value
			 * 
			 * else we calculate the z value
			 * 
			 */
			int pervious = current - left;
			if (left > 0 && right > 0 && current <= right) {
				z = (right - current) + 1;
				if (z_value[pervious] < z) {
					z_value[current] = z_value[current - left];
				} else {
					int current_index = current, compare_index = 0;
					int count = 0;
					while (A_C[current_index] == A_C[compare_index]) {
						count++;
						left = current;
						right = current_index;
						if (current_index < A_C.length - 1 && compare_index < A_C.length - 1) {
							current_index++;
							compare_index++;
						} else {
							break;
						}

					}
					z_value[current] = count;
				}
			} else {
				int current_index = current, compare_index = 0;
				int count = 0;
				while (A_C[current_index] == A_C[compare_index]) {
					count++;
					left = current;
					right = current_index;
					if (current_index < A_C.length - 1 && compare_index < A_C.length - 1) {
						current_index++;
						compare_index++;
					} else {
						break;
					}

				}
				z_value[current] = count;

			}
		}
		
/*
 * Finding whether z value contains value == length of pattern
 */
		int to_find = B.length();
		for (int j = 0; j < z_value.length; j++) {
			if (z_value[j] == to_find) {
				return true;
			}
		}
		return false;
	}

	public boolean isCircularRotation(String s, String t) {
		// if the length of t is greater than the string s then return false.
		if (s.length() < t.length()) {
			return false;
		}
		/*
		 * According my observation , to identify the circular rotation of the pattern can 
		 * be identified in linear time o(1) by 
		 * concatenate the same string again.
		 * so any starting point of the circular rotation we will be able to identify
		 * for example car has arc and rca
		 * car  convert to carcar ==> now we can see that c|arc|ar and ca|rca|r can be obtained
		 */
		String to_compare = s + s;
		System.out.println(to_compare);
		return Calculate_z(to_compare, t);
	}

	public static void main(String[] args) {
		String s = "car";
		String t = "arc";
		IsCirulcarRotation icr = new IsCirulcarRotation();
		System.out.println(icr.isCircularRotation(s, t));

	}

}
