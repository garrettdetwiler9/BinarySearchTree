public class Node<E extends Comparable>
{
    protected E info;
    protected Node<E> left;
    protected Node<E> right;

    public Node()
    {
        info = null;
        left = null;
        right = null;
    }

    public Node(E obj)
    {
        info = obj;
        left = null;
        right = null;
    }
}
