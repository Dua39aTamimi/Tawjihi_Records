package application;
public class Node {
	private Record data;
	private Node next;
	public Node(Record data) {
		
		this.data = data;
		
	}
	public Record getData() {
		return data;
	}
	public void setData(Record data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
}
