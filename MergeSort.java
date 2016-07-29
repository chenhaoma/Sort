
public class MergeSort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] a={9,1,5,3,4,2,6,8,7};
		
		sort(a);
		for (int i : a) {
			System.out.print(i+" ");
		}
	}
	
	public static void merge(int a[],int low,int mid,int high)
	{
		if (low>=high) {
			return;
		}
		int i=low;
		int j=mid+1;
		int k=0;
		int arrayTmp[] =new int[high-low+1];//临时数组
		
		while(i<=mid&&j<=high)
		{
			if (a[i]<=a[j]) {
				arrayTmp[k]=a[i];
				k++;
				i++;
			}else
			{
				arrayTmp[k]=a[j];
				k++;
				j++;
			}
		}//while 合并
		if (i>mid) {
			while(j<=high)
			{
				arrayTmp[k]=a[j];
				k++;
				j++;
			}
		}else if(j>high) {
			while(i<=mid)
			{
				arrayTmp[k]=a[i];
				k++;
				i++;
			}
		}//if else 合并剩余
		for(i=low,k=0;i<=high;i++,k++)
		{
			a[i]=arrayTmp[k];
		}
	}//merge
	
	public static void mergeSort(int[] a,int subSize,int len)
	{
		int i;
		for(i=0;i+2*subSize-1<len;i=i+2*subSize)
		{
			merge(a, i, i+subSize-1, i+2*subSize-1);
		}
		//合并剩余两个
		if (i+subSize-1<len) {
			merge(a, i, i+subSize-1, len-1);
		}
	}//mergSort
	
	public static  void sort(int[] a)
	{
		if (a==null||a.length==0) {
			return;
		}
		for(int subSize=1;subSize<a.length;subSize=subSize*2)
		{
			mergeSort(a, subSize, a.length);
		}
	}//sort

}
