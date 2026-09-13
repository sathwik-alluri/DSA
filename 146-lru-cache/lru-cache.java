class Node
{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int k, int v)
    {
        key=k;
        value=v;
    }
}

class LRUCache 
{
    HashMap<Integer, Node> hm=new HashMap<>();  //This is used to check whether the node exist and also to store the node reference
    Node head=new Node(-1, -1);
    Node tail=new Node(-1, -1);
    int cap;
    public LRUCache(int capacity) 
    {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) 
    {
        if(hm.containsKey(key) == false)
            return -1;

        Node node=hm.get(key);
        deleteNode(node);
        insertAfterHead(node);
        
        return node.value;
    }

    public void deleteNode(Node node)
    {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        nextNode.prev=prevNode;
        prevNode.next=nextNode;
    }

    public void insertAfterHead(Node node)
    {
        Node currAfterHead=head.next;
        head.next=node;
        node.next=currAfterHead;
        node.prev=head;
        currAfterHead.prev=node;
    }
    
    public void put(int key, int value) 
    {
        if(hm.containsKey(key))   //If alreday present in the cache then we have to update the value for that key and put at start
        {
            Node node=hm.get(key);
            node.value=value;
            deleteNode(node);
            insertAfterHead(node);
        }
        else   //not present
        {
            if(hm.size()==cap)   //Cache reached its capacity so we remove Least recently used ele and add this new node with the give key and value
            {
                Node node=tail.prev;  //we are removing the least recently used node(i.e, node before the tail)
                hm.remove(node.key);
                deleteNode(node);
            }
            Node ne=new Node(key,value);  //Inserting 
            hm.put(key,ne);
            insertAfterHead(ne);
        }   
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */