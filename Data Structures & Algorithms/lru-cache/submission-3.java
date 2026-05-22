class LRUCache {
    class node {
        int key;
        int value;
        node left;
        node right;

        node(int k, int v) {
            key = k;
            value = v;
        }
    }

    HashMap<Integer, node> map = new HashMap<>();
    private int limit = 0;
    node head = new node(-1, -1);
    node tail = new node(-1, -1);

    public LRUCache(int capacity) {
        limit = capacity;
        head.right = tail;
        tail.left = head;
    }

    public void addNode(node newNode){
        node nextNode = head.right;
        newNode.left = head;
        head.right = newNode;
        newNode.right = nextNode;
        nextNode.left = newNode;
    }
    public void deleteNode(node oldNode){
        node prevNode = oldNode.left;
        node nextNode = oldNode.right;

        prevNode.right = nextNode;
        nextNode.left = prevNode;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        node ansNode = map.get(key);
        map.remove(key);
        deleteNode(ansNode);
        addNode(ansNode);
        map.put(key, ansNode);
        return ansNode.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
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
