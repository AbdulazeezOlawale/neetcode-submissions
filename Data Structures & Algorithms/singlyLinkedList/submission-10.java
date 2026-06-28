class LinkedList {
    class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int get(int index) {
        int count = 0;
        Node currentNode = this.head;
        while (currentNode != null && index >= count) {
            if (count != index) {
                currentNode = currentNode.next;
                count++;
            } else {
                return currentNode.value;
            }
        }
        return -1;
    }

    public void insertHead(int val) {

        if(this.head != null) {
            Node prevHead = this.head;
            this.head = new Node(val);
            this.head.next = prevHead;
        } else {
            this.head = new Node(val);
            this.tail = this.head;
        }
        getValues();
    }

    public void insertTail(int val) {
        if(this.tail != null) {
            Node newTail = new Node(val);
            this.tail.next = newTail;
            this.tail = newTail;
        } else {
            this.head = new Node(val);
            this.tail = this.head;
        }

        getValues();
    }

    public boolean remove(int index) {
        if(this.head == null || index < 0) {
            return false;
        }

        if(index == 0) {
            this.head = this.head.next;
            if(this.head == null) {
                this.tail = null;
            }
            return true;
        }

        Node current = this.head;
        int count = 1;

        while(current.next != null) {
            if(index == count) {
                current.next = current.next.next;
                if(current.next == null) {
                    this.tail = current;
                }
                return true;
            }
            current = current.next;
            count++;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> array = new ArrayList<>();
        Node currentNode = head;
        while (currentNode != null) {
            array.add(currentNode.value);
            currentNode = currentNode.next;
        }
        System.out.println(array);
        return array;
    }
}