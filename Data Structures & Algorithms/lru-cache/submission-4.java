class LRUCache {
    public class node{
        int value;
        int key;
        node left;
        node right;

        node(int k, int v){
            value = v;
            key = k;
        }
    }
    HashMap<Integer, node> map = new HashMap<>();
    int limit = 0;
    node head = new node(-1,-1);
    node tail = new node(-1,-1);

    public LRUCache(int capacity) {
        limit = capacity;
        head.right = tail;
        tail.left = head;
    }
    public void deleteNode(node currNode){
        node prevNode = currNode.left;
        node nextNode = currNode.right;

        prevNode.right = nextNode;
        nextNode.left = prevNode;
    }

    public void addNode(node newNode){
        node nextNode = head.right;

        head.right = newNode;
        newNode.left = head;

        newNode.right = nextNode;
        nextNode.left = newNode;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        node ansNode = map.get(key);
        deleteNode(ansNode);
        addNode(ansNode);

        return ansNode.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            node currNode = map.get(key);
            deleteNode(currNode);
            map.remove(key);
        }

        if(map.size() == limit){
            node currNode = tail.left;
            deleteNode(currNode);
            map.remove(currNode.key);
        }

        node newNode = new node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }
}
