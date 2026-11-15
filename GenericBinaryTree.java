class Node <T extends Comparable<T>> {
    T value;
    Node<T> left, right;

    public Node(T data) {
        value = data;
        left = right = null;
    }
}


class Bisearchtree <T extends Comparable<T>> {
    private Node<T> root;

    public Bisearchtree() {
        root = new Node<T>(null);
    }

    public void insert(T value) {
        //Node<T> node = new Node<T>(value);

        root = insertthething(root, value);

    }

    private Node insertthething(Node<T> root, T value) {

        if(root.value == null) {
            root = new Node<T>(value);
            //System.out.println(root.value + " " + (root.left == null) + " " + (root.right == null));
            return root;
        }
        //System.out.println(value);
        if(value.compareTo(root.value) < 0) {
            if(root.left == null)
                root.left = new Node<T>(value);
            else
            insertthething(root.left, value);
        }
        else {
            //System.out.println("helooooo");
            if(root.right == null) {
                //System.out.println("helooooo");
                root.right = new Node<T>(value);
            }
            else
            insertthething(root.right, value);
        }

        return root;
    }

    
    public void delete(T value) {
        root = deletethething(root, value);
    }

    private Node deletethething(Node<T> root, T value) {
        if(root == null) {
            root = new Node<T>(value);
            return root;
        }
        //left node
        if(value.compareTo(root.value) < 0) {
            root.left = null;
        }
        else if(value.compareTo(root.value) > 0) { //right node
            root.right = null;
        }
        else { //nothing
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            root.value = minvalue(root.right);
            root.right = deletethething(root.right,root.value);
        }
        return root;
    }
        

    private T minvalue(Node<T> root) {
        T minval = root.value;
        while(root.left != null) {
            minval = root.left.value;
        }
        return minval;

    }
    

    public boolean search(T value) {
        return(searchforthing(root,value));
    }
        

    private boolean searchforthing(Node<T> root, T value) {
        if(root == null || value.compareTo(root.value) == 0) {
            return (root!=null);
        }
        if(value.compareTo(root.value) < 0) {
            return(searchforthing(root.left, value));
        }
        return(searchforthing(root.right,value));
    }
    
}

public class GenericBinaryTree {
    public static void main(String[] args) throws Exception {
        Bisearchtree<Integer> thing1 = new Bisearchtree();
        thing1.insert(20);
        thing1.insert(22);
        thing1.insert(30);
        thing1.insert(32);
        System.out.println(thing1.search(32));
        System.out.println(thing1.search(42));
        thing1.insert(42);
        System.out.println(thing1.search(42));
        thing1.insert(16);
        System.out.println(thing1.search(16));
        thing1.delete(32);
        System.out.println(thing1.search(32) + " egijjegn");

        System.out.println("///////////////////");

        Bisearchtree<String> thing2 = new Bisearchtree();
        thing2.insert("Hello");
        thing2.insert("Hello2");
        thing2.insert("Hello3");
        System.out.println(thing2.search("Hello3"));
    }
}
