import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class MyPriorityQueue <T extends Comparable<? super T>> extends ArrayList<T> {
	private int size;
	
	public MyPriorityQueue(){
		super.add(null);
		size = 0;
	}
	
	public T peek() {
		if(size == 0) {
			return null;
		}
		return super.get(1);
	}
	
	public T poll() {
		if (size == 0) {
			return null;
		}
		T top = super.get(1);
		remove(top);
		return top;
	}

	@Override
	public int size() {
		return size;
	}
	
	public void clear() {
		super.clear();
		super.add(null);
		size = 0;	
	}

	//might not run in correct time
	public Object[] toArray() {
		super.remove(0);
		Object[] arr = super.toArray();
		
		super.add(0, null);
	
		return arr;	
	}
	
	//might not run in correct time
	public <T> T[] toArray(T[] a) { 
        a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size-1);
		
		super.remove(0);
		a = super.toArray(a);
		super.add(0, null);
	
		return a;	
	}

	
	
	public boolean add(T o) {
		if(o == null) {
			throw new NullPointerException();
		}
		
		super.add(null);
		size++;
		int holeIndex = size;
		
		return addHelper(o, holeIndex);
	}
	
	public boolean addHelper(T o, int holeIndex) {
		if(holeIndex <= 1) {
			super.set(holeIndex, o);
			return true;
		}
		
		T holeParent = super.get(holeIndex/2);	
		
		if(o.compareTo(holeParent) > 0) {
			super.set(holeIndex, o);
			return true;
		} else {
			super.set(holeIndex, holeParent);
			holeIndex = holeIndex/2;
			super.set(holeIndex, null);
			return addHelper(o, holeIndex);
		}
	}
	
	
	public boolean offer(T o) {
		return add(o);
	}
	
	

	
	
	
	public boolean remove(T o) {
		super.remove(0);
		int oIndex = -1;
		for(int i = 0; i < size; i++) {
			if(o.compareTo(super.get(i)) == 0) oIndex = i + 1;
		}
		super.add(0, null);
		
		if(oIndex == -1) return false;
		
		
		//System.out.println("REMOVING: " + super.get(oIndex));
		
		super.set(oIndex, null);
		Boolean sucsess = removeHelper(oIndex);
		size--;
		return sucsess;
		
//		T largest = super.get(size);
//		super.set(oIndex, largest);
//		super.remove(size);
//		size--;
//		sort();
//		return true;
	}
	
	private boolean removeHelper(int holeIndex) {
		
		int leftIndex = holeIndex * 2;
		int rightIndex = leftIndex + 1;
		
		
		//System.out.println("size = " + size + ", leftIndex = " + leftIndex);
		//System.out.println();
		
		if(leftIndex > size) {
			//System.out.println("test 1");
			super.remove(holeIndex);
			return true;
		}
		if(rightIndex > size) {
			super.set(holeIndex, super.get(leftIndex));
			holeIndex = leftIndex;
			super.remove(holeIndex);
			return true;
		}
		
		
		T left = super.get(leftIndex);
		T right = super.get(rightIndex);
		
		if(left.compareTo(right) < 0) {
			super.set(holeIndex, left);
			holeIndex = leftIndex;
		} else { 
			super.set(holeIndex, right);
			holeIndex = rightIndex;
		}
		super.set(holeIndex, null);
		return removeHelper(holeIndex);
	}
		
	
	public void sort() {
		int startIndex = size/2;
		heapify(startIndex);
	}
	
	public void heapify(int startIndex) {
		int origionalStartIndex = startIndex;
		if(startIndex == 0) return;
		
//		while(startIndex != 0) {
//			percolateDown(startIndex);
//			startIndex = startIndex-1;
//		}
		
		
		T smallest = super.get(startIndex);
		
		int leftIndex = startIndex * 2;
		int rightIndex = leftIndex + 1;
		

		
		
		T smallestChild;
		int smallestChildIndex;
		
//		if(rightIndex > size) {
//			smallestChild = super.get(leftIndex);
//			smallestChildIndex = leftIndex;
//		} else if(super.get(leftIndex).compareTo(super.get(rightIndex)) < 0) {
//			smallestChild = super.get(leftIndex);
//			smallestChildIndex = leftIndex;
//		} else if(super.get(leftIndex).compareTo(super.get(rightIndex)) > 0) {
//			smallestChild = super.get(rightIndex);
//			smallestChildIndex = rightIndex;
//		} else {
//			System.out.println("HELP");
//			smallestChild = null;
//			smallestChildIndex = -5;
//		}
//		
//		
//		if (smallestChild.compareTo(smallest) < 0) {
//			percolateDown(startIndex);
//		}
		
		
		
		if (super.get(leftIndex).compareTo(smallest) < 0) {
			T temp = super.get(leftIndex);
			super.set(leftIndex, smallest);
			super.set(startIndex, temp);
			smallest = temp;
			//heapify(leftIndex);
			//percolateDown(startIndex);
		} 
			
		if(rightIndex <= size) {
			if (super.get(rightIndex).compareTo(smallest) < 0) {
				T temp = super.get(rightIndex);
				super.set(rightIndex, smallest);
				super.set(startIndex, temp);
				smallest = temp;
				//heapify(rightIndex);
				//percolateDown(startIndex);
				
			}
		}
		
		System.out.println(startIndex);
		heapify(startIndex-1);
	}
	
	
	

	public void percolateDown(int parentIndex) {
			int origionalParentIndex = parentIndex;
			
			T smallestChild;
			int smallestChildIndex;
			
			int leftIndex = parentIndex*2;
			int rightIndex = leftIndex + 1;
			
			if(leftIndex > size && rightIndex > size) {
				return;
			} 
			
			if(rightIndex > size) {
				smallestChild = super.get(leftIndex);
				smallestChildIndex = leftIndex;
			} else if(super.get(leftIndex).compareTo(super.get(rightIndex)) < 0) {
				smallestChild = super.get(leftIndex);
				smallestChildIndex = leftIndex;
			} else if(super.get(leftIndex).compareTo(super.get(rightIndex)) > 0) {
				smallestChild = super.get(rightIndex);
				smallestChildIndex = rightIndex;
			} else {
				//System.out.println("HELP");
				smallestChild = super.get(leftIndex);
				smallestChildIndex = leftIndex;
			}
			
			
			T parent = super.get(parentIndex);
			
			if(smallestChild.compareTo(parent) < 0) {
				super.set(parentIndex, smallestChild);
				super.set(smallestChildIndex, parent);
				parentIndex = smallestChildIndex;				
			}
			
			
//			if (super.get(leftIndex).compareTo(smallest) < 0) {
//				T temp = super.get(leftIndex);
//				super.set(leftIndex, smallest);
//				super.set(parentIndex, temp);
//				smallest = temp;
//				parentIndex = leftIndex;
//			} 
//			
//			if(rightIndex <= size) {
//				if (super.get(rightIndex).compareTo(smallest) < 0) {
//					T temp = super.get(rightIndex);
//					super.set(rightIndex, smallest);
//					super.set(parentIndex, temp);
//					smallest = temp;
//					parentIndex = rightIndex;
//				}
//			}
//			
			if(parentIndex == origionalParentIndex) return;
				
			percolateDown(parentIndex);	
			
		}
		
}
