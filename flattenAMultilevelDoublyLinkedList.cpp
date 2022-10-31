/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;
};
*/

class Solution {
public:
    void traversal(Node* &head,Node* &h)
    {
        if(head->child)
        {
            Node* temp=new Node();
            temp->val=head->child->val;
            h->next=temp;
            h->next->prev=h;
            h=h->next;
            traversal(head->child,h);
        }
        if(head->next)
        {
            Node* temp=new Node();
            temp->val=head->next->val;
            h->next=temp;
            h->next->prev=h;
            h=h->next;
            traversal(head->next,h);
        }
        return;
    }
    Node* flatten(Node* head) {
        if(head==nullptr)return head;
        Node* h=new Node(),*k=h;
        h->val=head->val;
        traversal(head,h);
        return k;
    }
};
