

import java.util.*;

public class HashMapImp<K,V>{
    private class Node{
        K key;
        V value;
        Node next;
        public Node(){

        }
        public Node(K key,V value){
            this.key  = key;
            this.value=value;
        }
    }
    private ArrayList<Node> bucketArray;  // Arraylist of bucket 
    private int  size =0;
    public HashMapImp(int initialCap){
        this.bucketArray  = new ArrayList<>();
        for(int i=0;i<initialCap;i++){
            bucketArray.add(null);
        }
    }
    public HashMapImp(){
        this(4);
    }

    //                  PUT 

    public void put(K key,V value){
        int bn = hashfun(key);
        Node temp  = this.bucketArray.get(bn);

    //                  If Previously Added

        while(temp!=null){
            if(temp.key.equals(key)){
                temp.value = value;
                return;
            }
                temp=temp.next; 
        }

    //                   Add at first position of linked list 
        temp  = this.bucketArray.get(bn);   
        Node nn= new Node(key, value);
        nn.next = temp;
        this.bucketArray.set(bn,nn);
        
        this.size++; //    increasing the size of hashmap

        double lf = (1.0*this.size)/this.bucketArray.size();  // load factor
        double th = 2.0 ; // threshHold factor
        if(lf>th){
            rehasing();
        }



    }

    //                REHASHING

    private  void rehasing(){
        ArrayList<Node> nba = new ArrayList<>();  // new bucket Array nba
        for(int i=0;i<this.bucketArray.size()*2;i++){
            nba.add(null);
        }
        ArrayList<Node> oba = this.bucketArray;  // old bucket Array oba
        this.bucketArray = nba;
        this.size =0;
        for(Node nn : oba){
            while(nn!=null){
                put(nn.key,nn.value);
            }
        } 


    }


    //                  GET

    public V get(K key){
        int bn = hashfun(key);
        Node temp  = this.bucketArray.get(bn);

        while(temp!=null){
            if(temp.key.equals(key)){
                return temp.value;
            }
                temp=temp.next; 
        }
        return null;
        
    }

    //                 containsKey

    public  boolean containsKey(K key){
        int bn = hashfun(key);
        Node temp  = this.bucketArray.get(bn);

        while(temp!=null){
            if(temp.key.equals(key)){
                return true;
            }
                temp=temp.next; 
        }
        return false;

    }

    //                  remove

    public V remove(K key){
        int bn = hashfun(key);
        Node prev= null;
        Node curr = this.bucketArray.get(bn);
        while(curr!=null){
            if(curr.key.equals(key)){
                break;
            }
            prev  = curr;
            curr = curr.next;
        }
        if(curr==null){  //data is not in the map
            return null;
        }

        this.size--;

        if(prev==null){ // If starting node is going delete 
            this.bucketArray.set(bn,curr.next);
            curr.next  = null;
            return curr.value;
        }
        //else
        prev.next =curr.next;
        curr.next = null;
        return curr.value;
    }


    //                   print HashMap

    public String toString(){
        String s ="{";
        for(Node nn: this.bucketArray){
            while(nn!=null){
                s += nn.key +"="+nn.value+",";
                nn = nn.next;
            }
        }
        s +="}";
        return s;

    }

    //                Hashfun give Bucket number in which we hace to add our key value

    public int hashfun(K Key){
        int bn = Key.hashCode() % this.bucketArray.size();
        if(bn<0){
            bn = bn+this.bucketArray.size();
        }
        return bn;
    }



}