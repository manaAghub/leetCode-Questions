import java.io.*;
import java.util.*;

public class LinkedListfunctions {


    public static void main(String[] args) throws Exception {
//        Node<Integer> xyz = takeinput();
//        Node<Integer> abc = takeinput();
//        Scanner sc = new Scanner(System.in);
//        print(delete_node_from_end(xyz,2));
        int[] arr = {1, 2, 3, 4, 5,-1};
//        Node<Integer> input_circularLL = take_input_circularLL();
//        print_circularLL(delete_kth_node_circularLL(input_circularLL,1));
//        print_circularLL(input_circularLL);

//        print(midPointOfLinkedList(xyz));
        printDoubleLL(insertAtPosDLL(inputDLL(arr), 5, 10));
//        print(insertNodeR(takeinput(arr),10,2));
    }

    public static void print(Node<Integer> data) {
        Node<Integer> head = data;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Node<Integer> takeinput(int[] arr) {
        int i = 0;
        int data = arr[0];
        Node<Integer> head = null, tail = null;
        while (data != -1) {
            Node<Integer> currentnode = new Node<>(data);
            if (head == null) {
                head = currentnode;
                tail = currentnode;
            } else {
                tail.next = currentnode;
                tail = tail.next;
            }
            i++;
            data = arr[i];
        }

        return head;
    }

    public static Node<Integer> delete_node(Node<Integer> data, int pos) {
        Node<Integer> head = data;
        if (pos == 0) {
            return head.next;
        } else {
            int i = 0;
            while (head != null && i < pos - 1) {
                head = head.next;
                i++;
            }
            if (head != null) {
                head.next = head.next.next;
            }
        }
        return data;
    }

    public static Node<Integer> deleteNodeR(Node<Integer> head, int pos) {
        if (head == null) {
            return null;
        }
        if (pos == 0) {
            return head.next;
        }
        head.next = deleteNodeR(head.next, pos - 1);
        return head;
    }

    public static Node<Integer> insertNodeR(Node<Integer> head, int elem, int pos) {
        if (head == null && pos > 0) {
            return head;
        }
        if (pos == 0) {
            Node<Integer> newhead = new Node<>(elem);
            newhead.next = head;
            return newhead;
        } else {
            head.next = insertNodeR(head.next, elem, pos - 1);
            return head;
        }
    }

    public static Node<Integer> reverseLinkedListR(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> new_head = reverseLinkedListR(head.next);
        head.next.next = head;
        head.next = null;
        return new_head;
    }

    public static Node<Integer> reverseLinkedList(Node<Integer> head) {
        Node<Integer> prev = null;
        Node<Integer> current = head;
        Node<Integer> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static Node<Integer> midPointOfLinkedList(Node<Integer> head) {
        if (head == null) {
            return head;
        }
        Node<Integer> slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node<Integer> mergeTwoSortedLL(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node<Integer> merged_tail, merged_head;
        if (head1.data < head2.data) {
            merged_head = head1;
            merged_tail = head1;

            head1 = head1.next;
        } else {
            merged_head = head2;
            merged_tail = head2;
            head2 = head2.next;

        }


        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                merged_tail.next = head1;
                head1 = head1.next;

            } else {
                merged_tail.next = head2;
                head2 = head2.next;
            }
            merged_tail = merged_tail.next;
        }

        while (head1 != null) {
            merged_tail.next = head1;
            merged_tail = merged_tail.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            merged_tail.next = head2;
            merged_tail = merged_tail.next;
            head2 = head2.next;
        }
        return merged_head;

    }

    public static Node<Integer> merge_sort(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> mid = midPointOfLinkedList(head);

        Node<Integer> head1 = head;
        Node<Integer> head2 = mid.next;
        mid.next = null;

        head1 = merge_sort(head1);
        head2 = merge_sort(head2);


        Node<Integer> finalhead = mergeTwoSortedLL(head1, head2);
        return finalhead;
    }

    public static int searchinLL_R(Node<Integer> head, int count, int x) {
        if (head == null) {
            return -1;
        }
        if (head.data == x) {
            return count;
        }
        count++;
        return searchinLL_R(head.next, count, x);

    }

    // Circular linked list
    public static Node<Integer> take_input_circularLL() {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null, tail = null;
        while (data != -1) {
            Node<Integer> current_node = new Node<>(data);
            if (head == null) {
                head = current_node;
                tail = current_node;
            } else {
                tail.next = current_node;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        tail.next = head;

        return head;
    }

    public static void print_circularLL(Node<Integer> head) {
        if (head == null) {
            return;
        }
        Node<Integer> sample = head;
        do {
            System.out.print(sample.data + " ");
            sample = sample.next;
        } while (sample != head);

    }

    public static Node<Integer> inserting_at_beg_circularLL(Node<Integer> head, int x) {     // O(1)
        Node<Integer> temp = new Node<>(x);
        if (head == null) {
            temp.next = temp;
            return temp;
        }
        Node<Integer> a = head.next;
        head.next = temp;
        temp.next = a;
        int t = head.data;
        head.data = temp.data;
        temp.data = t;
        return head;
    }

    public static Node<Integer> inserting_at_end_circularLL(Node<Integer> head, int x) {     // O(1)
        Node<Integer> temp = new Node<>(x);
        if (head == null) {
            temp.next = temp;
            return temp;
        }
        Node<Integer> a = head.next;
        head.next = temp;
        temp.next = a;
        int t = head.data;
        head.data = temp.data;
        temp.data = t;
        return temp;
    }

    public static Node<Integer> delete_first_node_circularLL(Node<Integer> head) {
        if (head == null || head.next == head) {
            return null;
        }
        head.data = head.next.data;
        head.next = head.next.next;
        return head;
    }

    public static Node<Integer> delete_kth_node_circularLL(Node<Integer> head, int index) {
        if (head == null || head.next == head) {
            return null;
        }
        if (index == 0) {
            return delete_first_node_circularLL(head);
        }
        Node<Integer> curr = head;
        int i = 0;
        while (curr != null && i != index - 1) {
            curr = curr.next;
            i++;
        }
        curr.next = curr.next.next;
        return head;
    }

    public static Node<Integer> reverse_inner_LL(Node<Integer> head, int i, int j) {
        Node<Integer> temp = head;
        if (i == 0) {
            Node<Integer> curr = temp;
            Node<Integer> curr_next = curr.next;

            Node<Integer> prev = null;
            Node<Integer> next = null;
            while (i <= j) {
                prev = curr.next;
                curr.next = next;
                next = curr;
                curr = prev;
                i++;
            }
            head.next = prev;
            head = next;
            return head;
        }

        int k = 0;
        while (temp != null && k < i - 1) {
            temp = temp.next;
            k++;
        }

        Node<Integer> initial = temp;
        Node<Integer> next_of_initial = initial.next;
        Node<Integer> curr = initial.next;

        Node<Integer> prev = null;
        Node<Integer> next = null;
        while (i <= j) {
            prev = curr.next;
            curr.next = next;
            next = curr;
            curr = prev;
            i++;
        }
        initial.next = next;
        next_of_initial.next = prev;
        return head;
    }

    public static Node<Integer> odd_first_even_secondLL(Node<Integer> head) {
        Node<Integer> odd_head = null;
        Node<Integer> odd_tail = null;
        Node<Integer> even_head = null;
        Node<Integer> even_tail = null;
        Node<Integer> temp = head;
        Node<Integer> xyz = new Node<>(temp.data);
        if (temp.data % 2 == 0) {
            even_head = xyz;

            even_tail = xyz;

            temp = temp.next;
        } else {
            odd_head = xyz;
            odd_tail = xyz;


            temp = temp.next;
        }
        while (temp != null) {
            Node<Integer> xyz1 = new Node<>(temp.data);
            if (temp.data % 2 == 0) {
                if (even_head == null) {
                    even_head = xyz1;
                    even_tail = xyz1;
                } else {
                    even_tail.next = xyz1;
                    even_tail = even_tail.next;
                }
            } else {
                if (odd_head == null) {
                    odd_head = xyz1;
                    odd_tail = xyz1;
                }
                odd_tail.next = xyz1;
                odd_tail = odd_tail.next;
            }
            temp = temp.next;
        }
        odd_tail.next = even_head;
        return odd_head;
    }

    public static Node<Integer> reverse_nodes_in_k_groups(Node<Integer> head, int k) {
        Node<Integer> temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        int n1 = 0;
        int n2 = k - 1;
        while (n1 + k <= size) {
            head = reverse_inner_LL(head, n1, n2);


            n1 += k;
            n2 += k;
        }
        return head;
    }

    public static int[] nextGreaterNode(Node<Integer> head) {
        Node<Integer> temp = head;

        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        int[] arr = new int[size];
        head = reverseLinkedListR(head);

        Node<Integer> temp1 = head;
        int i = size - 2;

        int max = head.data;

        temp1 = temp1.next;

        while (temp1 != null) {

            if (temp1.data < max) {
                arr[i] = max;

            } else {

                for (int j = i + 1; j < size; j++) {
                    if (arr[j] > temp1.data) {
                        arr[i] = arr[j];

                        break;
                    }
                }


            }
            max = temp1.data;
            temp1 = temp1.next;
            i--;
        }
        return arr;
    }

    public static Node<Integer> add_two_numberLL(Node<Integer> num1, Node<Integer> num2) {
        num1 = reverseLinkedListR(num1);
        num2 = reverseLinkedListR(num2);
        Node<Integer> sum1 = null;
        int carry = 0;
        while (num1 != null && num2 != null) {
            int sum = num1.data + num2.data + carry;
            if (num1.next == null && num2.next == null) {
                if (sum >= 10) {
                    sum -= 10;
                    carry = 1;
                    sum1 = insertNodeR(sum1, sum, 0);
                    sum1 = insertNodeR(sum1, carry, 0);
                } else {
                    carry = 0;
                    sum1 = insertNodeR(sum1, sum, 0);
                }
            } else {
                if (sum >= 10) {
                    sum -= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                sum1 = insertNodeR(sum1, sum, 0);
            }
            num1 = num1.next;
            num2 = num2.next;
        }
        while (num1 != null) {
            int sum = num1.data + carry;
            if (num1.next == null) {
                if (sum >= 10) {
                    sum -= 10;
                    carry = 1;
                    sum1 = insertNodeR(sum1, sum, 0);
                    sum1 = insertNodeR(sum1, carry, 0);
                } else {
                    carry = 0;
                    sum1 = insertNodeR(sum1, sum, 0);
                }
            } else {
                if (sum >= 10) {
                    sum -= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                sum1 = insertNodeR(sum1, sum, 0);
            }
            num1 = num1.next;
        }
        while (num2 != null) {
            int sum = num2.data + carry;
            if (num2.next == null) {
                if (sum >= 10) {
                    sum -= 10;
                    carry = 1;
                    sum1 = insertNodeR(sum1, sum, 0);
                    sum1 = insertNodeR(sum1, carry, 0);
                } else {
                    carry = 0;
                    sum1 = insertNodeR(sum1, sum, 0);
                }
            } else {
                if (sum >= 10) {
                    sum -= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }

                sum1 = insertNodeR(sum1, sum, 0);
            }
            num2 = num2.next;
        }
//        sum1 = reverseLinkedListR(sum1);
        return sum1;
    }

    public static boolean hasCycle(Node<Integer> head) {
        if (head == null) {
            return false;
        }
        Node<Integer> slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static Node<Integer> delete_node_from_end(Node<Integer> data, int pos) {
        Node<Integer> temp1 = data;
        int size = 0;
        while (temp1 != null) {
            temp1 = temp1.next;
            size++;
        }
        if (pos > size) {

            return data;
        } else if (pos == size) {


            return data.next;

        } else {
            int diff = size - pos;
            Node<Integer> prev = null;
            Node<Integer> curr = data;
            int i = 0;
            while (i < diff) {
                i++;
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            return data;
        }
    }

    // Double linked list functions
    public static DoubleNode<Integer> inputDLL(int[] arr) {
        int i = 0;
        int data = arr[0];
        DoubleNode<Integer> head = null, tail = null;
        while (data != -1) {
            DoubleNode<Integer> currentnode = new DoubleNode<>(data);
            if (head == null) {
                head = currentnode;
                tail = currentnode;
            } else {
                tail.next = currentnode;
                tail.next.prev = tail;
                tail = tail.next;
            }
            i++;
            data = arr[i];
        }

        return head;
    }

    public static DoubleNode<Integer> insertAtBegin(DoubleNode<Integer> head, int k) {
        DoubleNode<Integer> temp = new DoubleNode<>(k);
        temp.next = head;
        if (head != null) {
            head.prev = temp;
        }
        return temp;
    }

    public static DoubleNode<Integer> insertAtEnd(DoubleNode<Integer> head, int k) {
        DoubleNode<Integer> temp = new DoubleNode<>(k);
        if (head == null) {
            return temp;
        }
        DoubleNode<Integer> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        temp.prev = curr;
        return head;
    }

    public static TripleNode<Integer> reverseDoubleLL(TripleNode<Integer> head) {
        if (head == null || head.prev == null) return head;
        TripleNode<Integer> prev = null, curr = head;
        while (curr != null) {

            prev = curr.next;
            curr.next = curr.prev;
            curr.prev = prev;
            curr = curr.next;
        }

        return prev.next;
    }

    public static DoubleNode<Integer> deleteAtHeadDoubleLL(DoubleNode<Integer> head) {
        if (head == null) return null;
        if (head.next == null) return null;
        head = head.next;
        head.prev = null;
        return head;
    }

    public static DoubleNode<Integer> deleteAtEndDoubleLL(DoubleNode<Integer> head) {
        if (head == null) return null;
        if (head.next == null) return null;
        DoubleNode<Integer> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.prev.next = null;
        return head;
    }

    public static TripleNode<Integer> tertiaryToDouble(TripleNode<Integer> original) {

        TripleNode<Integer> head = original;


        if (head == null) {
            return null;
        }
        if (head.tertiary != null) {

            TripleNode<Integer> a = tertiaryToDouble(head.tertiary);
            TripleNode<Integer> temp = head.next;

            if (temp != null) {
                a.next = temp;
                temp.prev = a;
            } else {
                head.next = a;
                return a;
            }
            head.next = head.tertiary;
            head.tertiary.prev = head;

            TripleNode<Integer> x = tertiaryToDouble(a.next);
            head = x;
        }
        if (head.tertiary == null) {
            TripleNode<Integer> b = tertiaryToDouble(head.next);
            if (b != null) {
                head = b;
            }
        }
        return head;
    }

    public static DoubleNode<Integer> insertAtPosDLL(DoubleNode<Integer> head, int pos, int num) {
        DoubleNode<Integer> t1 = new DoubleNode<>(num);
        if (head == null && pos == 0) {

            return t1;
        }
        if (pos == 0) {
            t1.next = head;
            head.prev = t1;
            return t1;
        }
        DoubleNode<Integer> temp = head;
        int idx = 0;
        while (idx != pos - 1) {
            temp = temp.next;
            idx++;
        }
        if(temp.next==null){
            temp.next = t1;
            t1.prev = temp;
        }
        else {
            DoubleNode<Integer> temp1 = temp.next;
            temp.next = t1;
            t1.prev = temp;
            t1.next = temp1;
            temp1.prev = t1;

        }
        return head;
    }

    public static void printDoubleLL(DoubleNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    ////    public static void inputtingATripleNode(){
////        TripleNode<Integer> i = new TripleNode<>(1);
////        i.tertiary = new TripleNode<>(4);
////        i.tertiary.prev = i;
////        i.tertiary.tertiary = new TripleNode<>(6);
////        i.tertiary.tertiary.prev = i.tertiary;
////        i.tertiary.next = new TripleNode<>(5);
////        i.tertiary.next.prev = i.tertiary;
////        i.next = new TripleNode<>(2);
////        i.next.prev = i;
////        i.next.next = new TripleNode<>(3);
////        i.next.next.prev = i.next;
//
////        TripleNode<Integer> i = new TripleNode<>(1);
////        i.next = new TripleNode<>(8);
////        i.next.prev = i;
////        i.tertiary = new TripleNode<>(2);
////        i.tertiary.prev = i;
////        i.tertiary.next = new TripleNode<>(3);
////        i.tertiary.next.prev = i.tertiary;
////        i.tertiary.next.tertiary = new TripleNode<>(4);
////        i.tertiary.next.tertiary.prev = i.tertiary.next;
////        i.tertiary.next.next = new TripleNode<>(5);
////        i.tertiary.next.next.prev = i.tertiary.next;
////        i.tertiary.next.next.tertiary = new TripleNode<>(6);
////        i.tertiary.next.next.tertiary.prev = i.tertiary.next.next;
////        i.tertiary.next.next.next = new TripleNode<>(7);
////        i.tertiary.next.next.next.prev = i.tertiary.next.next;
//
//
//
////        TripleNode<Integer> i = new TripleNode<>(1);
////        i.tertiary = new TripleNode<>(2);
//////        i.tertiary.next = new TripleNode<>(10);
//////        i.tertiary.next.prev = i.tertiary;
////        i.tertiary.prev = i;
////        i.tertiary.tertiary = new TripleNode<>(3);
////        i.tertiary.tertiary.prev = i.tertiary;
////        i.tertiary.tertiary.next = new TripleNode<>(4);
////        i.tertiary.tertiary.next.prev = i.tertiary.tertiary;
////        i.tertiary.tertiary.next.next = new TripleNode<>(5);
////        i.tertiary.tertiary.next.next.prev = i.tertiary.tertiary.next;
////        i.next = new TripleNode<>(6);
////       i.next.prev = i;
//
////        TripleNode<Integer> i = new TripleNode<>(1);
////        i.next = new TripleNode<>(2);
////        i.next.prev = i;
////        i.next.tertiary = new TripleNode<>(3);
////        i.next.tertiary.prev = i.next;
////        i.next.next = new TripleNode<>(4);
////        i.next.next.prev = i.next;
////        i.next.next.tertiary = new TripleNode<>(5);
////        i.next.next.tertiary.prev = i.next.next;
////        i.next.next.next = new TripleNode<>(6);
////        i.next.next.next.prev = i.next.next;
////        i.next.next.next.next = new TripleNode<>(7);
////        i.next.next.next.next.prev = i.next.next.next;
////        i.next.next.next.next.tertiary = new TripleNode<>(8);
////        i.next.next.next.next.tertiary.prev = i.next.next.next.next;
//
//        TripleNode<Integer> i = new TripleNode<>(1);
//        i.tertiary = new TripleNode<>(2);
//
//
////        TripleNode<Integer> i = new TripleNode<>(1);
////        i.next = new TripleNode<>(2);
////        i.next.prev = i;
////        i.tertiary = new TripleNode<>(3);
////        i.tertiary.prev = i;
//
//        TripleNode<Integer> xyz =  tertiaryToDouble(i);
//        TripleNode<Integer> abc = reversingatriplenode(xyz);
//        printDoubleLL(abc);
////        System.out.println(xyz.prev.prev.prev.prev.data+" "+xyz.prev.prev.prev.data+" "+xyz.prev.prev.data+" "+ xyz.prev.data+" "+xyz.data+" ");
//    }
    public static TripleNode<Integer> reversingatriplenode(TripleNode<Integer> head) {
        head = reverseDoubleLL(head);
        TripleNode<Integer> temp = new TripleNode<>(head.data);

        TripleNode<Integer> start, end;
        start = temp;
        end = temp;
        head = head.prev;
        while (head != null) {
            TripleNode<Integer> temp1 = new TripleNode<>(head.data);

            end.next = temp1;
            end = end.next;
            head = head.prev;
        }

        return start;
    }
    static class Pair{
        ListNode list1,list2;
        public Pair(ListNode list1, ListNode list2){
            this.list1 = list1;
            this.list2 = list2;
        }
    }
    public static Pair splitCircularLL(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=head && fast.next.next!=head){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next.next==head){
            fast.next.next = null;
        }
        else{
            fast.next = null;
        }
        ListNode temp = slow.next;
        slow.next = null;
        return new Pair(head,temp);
    }
}
//    public static void printDoubleLL(TripleNode<Integer> head){
////        head = reverseDoubleLL(head);
//
////        while(head!=null){
////            System.out.print(head.data+" ");
////            head = head.prev;
////        }
//
//        while(head!=null){
//            System.out.print(head.data+" ");
//            head = head.next;
//        }
//        System.out.println("");
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class TripleNode<T>{
    T data;
    TripleNode<T> prev;
    TripleNode<T> next;
    TripleNode<T> tertiary;
    TripleNode(T data){
        this.data = data;
    }
}
class DoubleNode<T>{
    T data;
    DoubleNode<T> prev;
    DoubleNode<T> next;
    DoubleNode(T data){
        this.data = data;
    }
}
class Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
    }
}
