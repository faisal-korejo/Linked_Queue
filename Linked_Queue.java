class Linked_Queue {

    //Now we made a head Node, so it works as Pointer it points out (Next and Previous Nodes)
    // and that's why we give null value to head
    private Node head = new Node(null);
    private static int size;

    private static class Node {
        Object object;
        Node perv = this;
        Node next = this;

        @Override
        public String toString() {
            return "Node{" +
                    "object=" + object +
                    ", perv=" + perv +
                    ", next=" + next +
                    '}';
        }

        Node(Object obj) {
            this.object = obj;
        }

        Node(Object obj, Node n, Node p) {
            object = obj;
            next = n;
            perv = p;
        }
    }


    public int size(){

        return size;
   }

   public boolean isEmpty(){

        return (size==0);
   }

   public Object first(){
        if(size==0){
            throw new RuntimeException();
        }
        return head.next.object;
   }
   public void add(Object obj){

        head.perv.next=new Node(obj,head,head.perv);
        head.perv = head.perv.next;
        ++size;
   }
   public Object remove(){
        Object temp=head.next.object;
        head.next=head.next.next;
        head.next.perv=head;
        --size;
        return  temp;
   }

    public static void main(String[] args) {
        Linked_Queue q=new Linked_Queue();

        q.add(5);
        q.add(4);
        q.add(3);


        while(!q.isEmpty()){
            System.out.println(q.first());
            q.remove();
        }
       }
    }
