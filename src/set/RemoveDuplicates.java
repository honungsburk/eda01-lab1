package set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] ints = new int[]{7,5,3,5,2,2,7};
		int[] result = uniqueElements(ints);
		for(int r: result) {
			System.out.print(r+ ", ");
		}
	}
	
	public static int[] uniqueElements(int[] ints) {
		MaxSet<Integer> ms = new MaxSet<>();
		for(int i: ints){
			ms.add(i);
		}
		int[] result = new int[ms.size()];
		for(int i = ms.size() - 1; i >= 0; i--){
			int max = ms.getMax();
			result[i] = max;
			ms.remove(max);
		}
		return result;
	}
	
//	//Generic..?
//	public static <E extends Comparable<E>> E[] uniqueElements(E[] elems) {
//		MaxSet<E> ms = new MaxSet<>();
//		for(E i: elems){
//			ms.add(i);
//		}
//		E[] result = new E[ms.size()];
//		for(int i = ms.size() - 1; i >= 0; i--){
//			E max = ms.getMax();
//			result[i] = max;
//			ms.remove(max);
//		}
//		return result;
//	}
}
