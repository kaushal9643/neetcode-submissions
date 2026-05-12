class LRUCache {
    class node{
        int key;
        int value;
        node left;
        node right;

        node(int k, int v){
            key = k;
            value = v;
        }
    }
    HashMap<Integer, node> map = new HashMap<>();
    int limit = 0;
    node head = new node(-1, -1);
    node tail = new node(-1, -1);

    public LRUCache(int capacity) {
        limit = capacity;
        head.right = tail;
        tail.left = head;
    }
    public void addNode(node newNode){
        node oldNext = head.right;
        head.right = newNode;
        newNode.left = head;
        newNode.right = oldNext;
        oldNext.left = newNode;
    }
    public void deleteNode(node oldNode){
        node oldPrev = oldNode.left;
        node oldNext = oldNode.right;

        oldPrev.right = oldNext;
        oldNext.left = oldPrev;
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
            map.remove(tail.left.key);
            deleteNode(tail.left);
        }
        node newNode = new node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }
}
