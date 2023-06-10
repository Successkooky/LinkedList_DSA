
public class LinkedList1 {

    //Creation of linked list class
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;

        }
    }
    public static Node head;
    public static Node tail;
    public int size=0;

    //Methods

    public void addFirst(int data){
        //If linkedlist is empty
        // Step1=Create new Node
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;

        }


       
        //Step2 =newNode next=head
        newNode.next=head;
        head=newNode;

    }
    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;

        }
        tail.next=newNode;
        tail=newNode;

    }

    public void print(){
        if (head == null) {
            System.out.println("Linked list is empty");
            return;

        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;

        }
        System.out.println("null");
    }
    public void add(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp =head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }

        //i=idx-1==temp->prev
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public int removeFirst(){
        if(size==0){
            System.out.println("Linked is empty");
            return Integer.MAX_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    public int removeLast(){
         if(size==0){
            System.out.println("Linked is empty");
            return Integer.MIN_VALUE;
    } else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        //prev:i =size-2
        Node prev=head;

        for (int i = 0; i < size-2; i++) {
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }
    public int Search(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        //key not found 
        return -1;
    }

    public static void main(String args[]){

        LinkedList1 l1=new LinkedList1();
        // l1.head=new Node(1);
        // l1.head.next=new Node(2);
        // We cant keep on adding this so we create methods to add create and delete a node in the linked list class

        l1.print();
        l1.addFirst(1);
        l1.print();
        l1.addFirst(2);
        l1.print();
        l1.addFirst(3);
        l1.print();
        l1.addLast(6);
        l1.print();
        l1.addLast(4);
        l1.print();
        l1.add(2, 10);
        l1.print();
        l1.removeFirst();
        l1.print();
        l1.removeLast();
        l1.print();
        System.out.println("Size is ->"+ l1.size);

        System.out.println(l1.Search(10));

    }
    
}
