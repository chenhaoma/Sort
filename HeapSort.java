
public class HeapSort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		 //int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };
		int[] array = { 6,7,3,20,17,8}; 
		heapSort(array, array.length);
		for (int i : array) {
			System.out.print(i+" ");
		}
		System.out.println("");
		 heapSortMin(array, array.length);
		for (int i : array) {
			System.out.print(i+" ");
		}
	}
	
	public static void exchange(int []a,int index1,int index2)
	{
		int temp=a[index1];
		a[index1]=a[index2];
		a[index2]=temp;
	}
	
	public static void maxHeap(int [] a,int index, int heapBound)
	{
		int child=2*index+1;
		int temp=a[index];

		while(child<=heapBound)
		{
			if (child<heapBound&&a[child]<a[child+1]) {
				child++;
			}
			if (temp>=a[child]) {
				break;
			}
			a[(child-1)/2]=a[child];
			child=2*child+1;
		}
		a[(child-1)/2]=temp;
		
	}
	public static void buildMaxHeap(int []a,int n)
	{
		for(int i=(n-2)/2;i>-1;i--) 
			maxHeap(a, i, n-1);
	}
	
	public static  void heapSort(int [] a,int n)
	{
		if (a==null||n==0) {
			return;
		}
		buildMaxHeap(a, n);
		for(int i=n-1;i>0;i--)
		{
			exchange(a, 0, i);
			maxHeap(a, 0, i-1);
		}
	}

	public static void minHeap(int [] a,int index, int heapBound)
	{
		int child=2*index+1;
		int temp=a[index];

		while(child<=heapBound)
		{
			if (child<heapBound&&a[child]>a[child+1]) {
				child++;
			}
			if (temp<=a[child]) {
				break;
			}
			a[(child-1)/2]=a[child];
			child=2*child+1;
		}
		a[(child-1)/2]=temp;
		
	}
	public static void buildMinHeap(int []a,int n)
	{
		for(int i=(n-2)/2;i>-1;i--) 
			minHeap(a, i, n-1);
	}
	
	public static  void heapSortMin(int [] a,int n)
	{
		buildMinHeap(a, n);
		for(int i=n-1;i>0;i--)
		{
			exchange(a, 0, i);
			minHeap(a, 0, i-1);
		}
	}
}
