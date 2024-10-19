public class BSTree<E extends Comparable> implements BSTreeInterface<E>
{
    private Node<E> root;

    public BSTree()
    {
        root = null;
    }

    //assumes the new node does not exist in the tree
    public void insertBST(E obj)
    {
        Node<E> newNode = new Node<E>(obj);

        if (root == null)
            root = newNode;
        else {
            int comp = -999;    //Java requires an initialization here
            Node<E> lead, lag;
            lead = lag = root;
            while (lead != null) {
                lag = lead;
                comp = newNode.info.compareTo(lag.info);
                if (comp < 0)
                    lead = lag.left;
                else
                    lead = lag.right;
            }
            //lead fell off tree
            if (comp < 0)
                lag.left = newNode;
            else
                lag.right = newNode;
        }
    }

    public E find(E obj)
    {
        Node<E> findNode = new Node<E>(obj);
        Node<E> r = root;

        int comp;
        while (r != null && (comp = r.info.compareTo(findNode.info)) != 0) {
            if (comp < 0)
                r = r.right;
            else
                r = r.left;
        }
        if (r == null)
            return null;
        return r.info;
    }

    private void intrav(Node<E> r, StringBuilder sb)
    {
        if (r != null) {
            intrav(r.left, sb);
            sb.append(r.info.toString() + "\n");
            intrav(r.right, sb);
        }
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        intrav(root, sb);
        return sb.toString();
    }
}