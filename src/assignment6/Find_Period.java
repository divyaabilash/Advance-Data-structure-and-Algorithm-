package assignment6;

/*
 * An integer p is a period of a string s if s=tt...tu
 * (t repeats p times, and u is a prefix of t). 
 * The period of s is the largest such integer p. For example, 
 * if s=ababababababa
 * then 2,3,62,3,6 are periods of s, and we refer to 6 as the period of s.
 */

public class Find_Period {

	/*
	 * Calculating the K_values of the given string we know that k_values of the
	 * string can be calculated from the z values for i element k value is
	 * calculated as k[i+z[i]-1]=z[i]
	 * 
	 * here only the last element k value is returned
	 */
	
	public int Calculate_k_value(int[] z) {
		int[] k_value = new int[z.length];
		for (int i = 1; i < z.length; i++) {
			k_value[i + z[i] - 1] = z[i];
		}
		k_value[0] = -1;
		return k_value[k_value.length - 1];
	}

	/*
	 * function thats calculation z values
	 */

	public int[] Calculate_z_Values(char[] arr) {
		int[] z_value = new int[arr.length];
		int left = 0, right = 0, current = 0, z = 0;
		z_value[0] = 0;
		for (current = 1; current < arr.length; current++) {
			int pervious = current - left;
			/*
			 * If the current index is inside the box value and 
			 * value of z[current-left] is less then number elements in right-current+1;
			 * , the no need of calculating the z_value.
			 * we are place z_value as z[current]=z[current-left];
			 * 
			 * else if current <right and z[current-left]>number of elements in right-current+1
			 * then we have to recalculate the z value
			 * 
			 * else 
			 * we calculate the z value
			 * 
			 */
			
			if (left > 0 && right > 0 && current <= right) {
				z = (right - current) + 1;
				if (z_value[pervious] < z) {
					z_value[current] = z_value[current - left];
				} else {
					int current_index = current, compare_index = 0;
					int count = 0;
					while (arr[current_index] == arr[compare_index]) {
						count++;
						left = current;
						right = current_index;
						if (current_index < arr.length - 1 && compare_index < arr.length - 1) {
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
				while (arr[current_index] == arr[compare_index]) {
					count++;
					left = current;
					right = current_index;
					if (current_index < arr.length - 1 && compare_index < arr.length - 1) {
						current_index++;
						compare_index++;
					} else {
						break;
					}

				}
				z_value[current] = count;

			}
		}
		return z_value;
	}

	/*
	 * This the function asked in assignment which returns the maximum period
	 * value of the given string. where period means the number of times the
	 * substring is repeated in the main string.
	 */

	public int period(String s) {

		char[] s_c = s.toCharArray();
		int[] z_value = new int[s.length()];
		z_value = Calculate_z_Values(s_c);
		int last_value = Calculate_k_value(z_value);

		/*
		 * Since u always has to be prefix of t, the last element k value has to
		 * greater than 0. That means last element the prefix of t. if the last
		 * element K value is equal to zero , then it means last element is not
		 * prefix of t. in that case u will be empty string and whole string is
		 * considered as one t element, whose period is t.
		 */
		if (last_value > 0) {
			System.out.println("There is U element present");
			int counter = 0;
			/*
			 * According to my observation , the largest period is equal to
			 * number of non-zero elements of z-value.
			 */
			for (int i = 0; i < z_value.length; i++) {
				if (z_value[i] > 0) {
					counter++;
				}
			}
			return counter;
		}
		System.out.println("the u is the empty string");
		return 1;
	}

	public static void main(String[] args) {
		String s = "ababababababa";
		Find_Period p = new Find_Period();
		int period_value = p.period(s);
		System.out.println(period_value);
	}

}
