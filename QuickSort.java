
public class QuickSort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		 //int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,8};
		// int[] a={34,12,64,1,8};
		//int [] a={34};
		int[] a={49,38,65,97,76,13,27,49,78,34,12};
		//int[]a={13,38,12,34,27};
		//int []a={38,34,27};
		//int[] a={76,49,78,97,65};
		quick(a);
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
	

	
	public static void quick(int a[])
	{
		if (a==null||a.length==0) {
			return;
		}
		quickSort(a, 0, a.length-1);
	}
	
	public static void quickSort(int a[],int low,int high)
	{
		if (low>=high) {
			return;
		}
		int i=low;
		int j=high+1;
		int base=i;
		
		while(i<j)
		{
		/*	while(i<j&&a[i]<=a[base])
				i++;
			while(i<j&&a[j]>=a[base])
				j--;*/try {
					do i++;while(a[i]<a[base]&&i<high);
					do j--;while(a[j]>a[base]&&j>low);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("i = "+i);
					System.out.println("j = "+j);
					e.printStackTrace();
					throw new RuntimeException(e.getMessage());
				}
			
			if(i<j)
			{
				int temp=a[j];
				a[j]=a[i];
				a[i]=temp;
				
			}
			
		}//while
		if (a[base]>a[j]) {
			int temp=a[j];
			a[j]=a[base];
			a[base]=temp;
		}
		
		quickSort(a, low, j-1);
		quickSort(a, j+1, high);
		
	}

}
