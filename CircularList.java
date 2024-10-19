public class CircularList
{
    private Item list;

    public CircularList()
    {
        list = null;
    }
    
    public Boolean isEmpty()
    {
        return list == null;
    }

    public void append(int x)
    {
        Item r = new Item(x);
        if (isEmpty()) {
            r.next = r;
        }
        else {
            r.next = list.next;
            list.next = r;
        }
        list = r;
    }
    
    public String toString()
    {
        StringBuilder s = new StringBuilder("");

        if (!isEmpty()) {
            Item r = list.next;
            while (r != list) {
                s.append(r.info + ", ");
                r = r.next;
            }
            //append last item
            s.append(r.info);
        }
        return s.toString();
    }
}
