import java.util.ArrayList;


public class PriorityQueue <E extends Comparable<? super E>> extends ArrayList<E> {
	
	@Override
	public boolean add(E e){
		if(e == null){
			throw new NullPointerException();
		}
		super.add(e);
		if(size() > 0){
			filterUp(size() - 1);
		}
		return true;
	}
	
	@Override
	public boolean remove(Object o){
		if(!this.contains(o)) {
			return false;
		}
		
		int index = super.indexOf(o);
		swap(index, size() - 1);
		super.remove(size() - 1);
		filterDown(index);
		return true;
	}
	
	
	public boolean offer(E e){
		return add(e);
	}
	
	
	public E peek(){
		if(size() == 0){
			return null;
		}
		return super.get(0);
	}
	
	public int size() {
		return super.size();
	}

	
	public E poll(){
		if(size() == 0) {
			return null;
		}
		
		E value = peek();
		this.remove(value);
		return value;
	}
	
	
	
	
	private void filterUp(int index){
		if(index == 0) {
			return;
		}
		E curr = super.get(index);
		E parent = super.get(parent(size()));
		if(curr.compareTo(parent) < 0){
			swap(index,parent(index));
			filterUp(parent(index));
		}
	}
	
	private void filterDown( int index ) {
        if(hasLeftChild(index)&& hasRightChild(index)){
        	if(super.get(leftChild(index)).compareTo(super.get(rightChild(index))) < 0){
        		if(super.get(leftChild(index)).compareTo(super.get(index)) < 0){
        			swap(index, leftChild(index));
        			filterDown(leftChild(index));
        		}
        	}
        	else if( super.get(rightChild(index)).compareTo(super.get(index)) < 0){
        		swap(index,rightChild(index));
        		filterDown(rightChild(index));
        	}
        }
        else if(hasLeftChild(index)&& super.get(leftChild(index)).compareTo(super.get(index)) < 0){
        	swap(index, leftChild(index));
    		filterDown(leftChild(index));
        }
        else if(hasRightChild(index)&& super.get(rightChild(index)).compareTo(super.get(index)) < 0){
        	swap(index, rightChild(index));
    		filterDown(rightChild(index));
        }
    }
	
	private boolean hasLeftChild(int index){
		return leftChild(index) < size();
	}
	
	private boolean hasRightChild(int index){
		return rightChild(index) < size();
	}
	
	private void swap(int index1, int index2){
		E element1 = super.get(index1);
		E element2 = super.get(index2);
		super.set(index1,element2);
		super.set(index2,element1);
	}
	
	private int leftChild(int i) {
		return 2*i +1;
	}
	
	private int rightChild(int i) {
		return 2*i + 2;
	}
	
    private int parent(int i) {
    	return (i-1)/2;
    }
}