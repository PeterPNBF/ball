public class TestDd {
    //单项链表， 删除倒数第N 个节点，返回头结点
    public static void main(String[] args) {

        int[][]arr = {{1,2,3},{2,3,4}};
        System.out.println(arr.length);
    }

    class Node<T>{
        T value;
        Node next;
    }

    public Node deleteReverseNNode(Node head, int n){
        if(head==null || n<0){
            return head;
        }
        Node p=head,q=head;
        int visitNum=1;
        //找到第N个节点的父节点
        boolean find = false;
        while(q.next!=null){
            q = q.next;
            if(visitNum>=n-1){
                find = true;
                p = p.next;
            } else {
                visitNum++;
            }
        }
        //找到倒数第N个删除，N小于总长度
        if(find) {
            p.next = p.next.next;
        }
        return head;
    }
}
