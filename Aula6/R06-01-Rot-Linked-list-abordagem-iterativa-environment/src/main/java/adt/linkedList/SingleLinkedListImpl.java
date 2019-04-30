package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = head;
		while (!aux.isNIL()){
			size ++;
			aux = aux.next;
		}
		return size;		
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = head;
		while (!auxHead.isNIL() && !auxHead.getData().equals(element )) {
			auxHead = auxHead.next;
		}
		return auxHead.getData();
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> node = new SingleLinkedListNode<T>(element,new SingleLinkedListNode<>());
		
		if(head.isNIL()) {
			head = node;
		}else {
			SingleLinkedListNode<T> auxHead = head;
			
			while(!auxHead.next.isNIL()) {
				auxHead = auxHead.next;
			}
			node.next = auxHead.next;
			auxHead.next = node;
		}
	}

	@Override
	public void remove(T element) {
		if(head.getData().equals(element)) {
			head = head.next;
		}else {
			SingleLinkedListNode<T> auxHead = head;
			SingleLinkedListNode<T> previous = new SingleLinkedListNode<T>();
			
			while(!auxHead.getData().equals(element) ) {
				previous = auxHead;
				auxHead = auxHead.next;
			}
			if(!auxHead.isNIL()) {
				previous.next = auxHead.next;
			}
		}
		
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> auxHead = head;
		int posi = 0;
		while(!auxHead.isNIL()) {
			array[posi] = auxHead.getData();
			auxHead = auxHead.next;
			posi += 1;
		}
		return array;
		
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
