package application;
public class List {
	Node first;
	Node last;
	int listLength;
	
	public List() {

		first = last = null;

		this.listLength = 0;
	}
	public void insertFirst(Record data) {
		
		
		
		Node  node= new Node(data);
    
     if (first == null)
     {
         first = new Node(data);
         return;
     }
     node.setNext(null);
     Node last = first; 
     while (last.getNext() != null) {
         last = last.getNext();
      
     }
    
     last.setNext(node);//2,1,5,4
  
     return;
	}

	public void insertSorted(Node node) {
		if (this.first == null) {
			this.first = node;
			this.first.setNext(null);
			
			listLength = 1;
		} else {

			Node temp = first;
			while (temp != null) {
				
				if (node.getData().getAverage() > first.getData().getAverage()) {
					
					Node n = first;
					node.setNext(n);
					first = node;
					break;
				} else if (temp.getNext() == null) {
					temp.setNext(node);
					break;

				} else if (node.getData().getAverage() > temp.getNext().getData().getAverage()) {
					Node n = temp.getNext();
					temp.setNext(node);
					node.setNext(n);

					
					break;
				} 
				else if(node.getData().getAverage() == first.getData().getAverage()) {
					if(node.getData().getSeatNumber() < first.getData().getSeatNumber()) {
						Node n = first;
						node.setNext(n);
						first = node;
						break;
					}
					else {
						Node n = first;
						node.setNext(n);
						first = node;
					}
				}
				else if(node.getData().getAverage() == temp.getNext().getData().getAverage()) {
					if(node.getData().getSeatNumber() < temp.getNext().getData().getSeatNumber()) {
						Node n = temp.getNext();
						node.setNext(n);
						temp.setNext(node);
						break;
					}
					else {
						Node n = temp.getNext();
						node.setNext(n);
						temp.setNext(node);
					}
				}
				else {
					temp = temp.getNext();
				}

			}
			listLength++;

		}
	}//1 -> 2 -> 3->

	public boolean remove(int seatNumber) {
		boolean result = false;
		if (first.getData().getSeatNumber() == seatNumber) {
			
			first=first.getNext();
			result = true;

		} else {
			Node temp = first;
			
			while (temp != null) {
				if(temp.getNext()==null) {
					if (temp.getData().getSeatNumber() == seatNumber) {
						temp=null;
						result=true;
						break;
					}
				}
				if (temp.getNext().getData().getSeatNumber() == seatNumber) {
					temp.setNext(temp.getNext().getNext());
					result = true;
					break;
				}
				
				temp = temp.getNext();
			}
		}
		listLength--;
		return result;
	}

	public Node search(int seatNumber) {
		Node temp = first;
		Node result=null;
		for (int i = 0; i < listLength; i++) {
			if(temp.getData().getSeatNumber()==seatNumber) {
				result=temp;
				break;
			}
			temp = temp.getNext();
		}
		return result;
	}
	
	public void print() {
		Node temp = first;
		for (int i = 0; i < listLength; i++) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

}
