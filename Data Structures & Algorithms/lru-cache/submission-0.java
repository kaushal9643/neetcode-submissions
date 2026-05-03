class LRUCache {
    class node{
        int key;
        int value;
        node next;
        node prev;

        node(int k, int v){
            key = k;
            value = v;
        }
    }
    node head = new node(-1, -1);
    node tail = new node(-1, -1);

    HashMap<Integer, node> map = new HashMap<>(); 
    int limit;

    public void addNode(node newNode){
        node oldNext = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = oldNext;
        oldNext.prev = newNode;
    }
    public void deleteNode(node oldNode){
        node oldPrev = oldNode.prev;
        node oldNext = oldNode.next;

        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }
    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        
        node ansNode = map.get(key);
        int ans = ansNode.value;

        map.remove(key);
        deleteNode(ansNode);

        addNode(ansNode);
        map.put(key, ansNode);

        return ans;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            node oldNode = map.get(key);
            deleteNode(oldNode);
            map.remove(key);
        }

        if(map.size() == limit){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        node newNode = new node(key, value);
        addNode(newNode);
        map.put(key, newNode);    
    }
}
