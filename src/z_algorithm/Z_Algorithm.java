package z_algorithm;

public class Z_Algorithm {

//	the run time is o(n power(2))
	public void Brute_force_z_calculation(char[] arr){
		int[] z_value=new int[arr.length];
		z_value[0]=0;
		
			for(int j=1;j<arr.length;j++){
				int current_index=j,compar_index=0,count=0;
				while(arr[compar_index]==arr[current_index])
					if( compar_index<arr.length-1 && current_index<arr.length-1){
					count++;
					compar_index++;
					current_index++;
				}else{
					if(arr[compar_index]==arr[current_index]){
						count=count+1;
					}
					break;
				}
				z_value[j]=count;
			}
		System.out.println(arr);
		for(int i=0;i<z_value.length;i++){
		System.out.print(z_value[i]);
		}
	}
	
//	making it to be o(2n) as the run time
	public void Better_o_n(char[] arr){
		int left=0,right=0,current=0,z=0;

		int[] z_value = new int[arr.length];
		z_value[0]=0;	
	for(current=1;current<arr.length;current++){
		int pervious=current-left;
		if(left >0 && right >0 && current <= right){
			z=(right-left)+1;
			if(z_value[pervious]<z){
				z_value[current]=z_value[current-left];
			}else{
				int current_index=current,compare_index=0;
				int count=0;
				while(arr[current_index]==arr[compare_index]){
					count++;
					left=current;
					right=current_index;
					if(current_index<arr.length-1 && compare_index< arr.length-1){
					current_index++;
					compare_index++;
					}else{
						break;
					}

				}
				z_value[current]=count;
				
			}
		}else{
			int current_index=current,compare_index=0;
			int count=0;
			while(arr[current_index]==arr[compare_index]){
				count++;
				left=current;
				right=current_index;
				if(current_index<arr.length-1 && compare_index< arr.length-1){
				current_index++;
				compare_index++;
				}else{
					break;
				}

			}
			z_value[current]=count;
			
		}
	}
	System.out.println("");
	for(int i=0;i<z_value.length;i++){
		System.out.print(z_value[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub aabcaabcxaabza
		char[] arr = {'a','a','b','c','a','a','b','c','x','a','a','b','z','a'};
		Z_Algorithm z= new Z_Algorithm();
		z.Brute_force_z_calculation(arr);
		z.Better_o_n(arr);
	}

}
