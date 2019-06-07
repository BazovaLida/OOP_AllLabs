package Lab7;

import Lab6V2.ElectricAppliances;

public class Node {
    private Node next;
    private ElectricAppliances data;

    public Node getNext(){
        return next;
    }public void setNext(Node n){
        next = n;
    }
    public ElectricAppliances getData(){
        return data;
    }public void setData(ElectricAppliances d){
        data = d;
    }
}
