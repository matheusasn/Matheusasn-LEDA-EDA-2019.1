package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	private DoubleLinkedListNode<T> nill = new DoubleLinkedListNode<T>();
	
	public DoubleLinkedListImpl() {
		setHead(nill);
		setLast(nill);
	}
	@Override
	public void insertFirst(T element) {
		if (element == null) return;
	
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>(element, (DoubleLinkedListNode<T>) head, nill);
				
		((DoubleLinkedListNode<T>) head).previous = newHead;
			
		if(head.isNIL()) {
			setLast(newHead);
		}
		setHead(newHead);
		
	}
	
	@Override
	public void insert(T element) {
		if (element == null) return;
		
		if(this.isEmpty()) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>(element, nill, nill);
			setHead(newHead);
			setLast(newHead);
		}else {
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>(element, nill, last);
			last.setNext(newLast);
			setLast(newLast);
		}	
	}
	
	@Override
	public void removeFirst() {
		if(!head.isNIL()) {
			setHead(head.next);
			((DoubleLinkedListNode<T>)head).setPrevious(nill); 
		}
	}

	@Override
	public void removeLast() {
		if(!last.isNIL()) {
			setLast(last.getPrevious());
			if(last.isNIL()) {
				head = last;
			}
			last.setNext(nill); 
		}
		
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
