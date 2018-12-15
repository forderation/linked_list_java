import java.util.ArrayList;

//author: kharisma muzaki ghufron
class Queue {
    Link head, tail;
    public Queue() {
        this.head = this.tail = null;
    }

    public Boolean isEmpty() {
        return (tail==null&&head==null);
    }

    public void enqueue(String namaPasien, int keparahan, int waktu) {
        Link newlink = new Link(namaPasien, keparahan, waktu);
        if (isEmpty()){
            head = tail = newlink;
        } else {
            newlink.next = head;
            head = newlink;
            newlink.next.prev = head;
        }
    }

    public void sortByKeparahan() {
        if (!isEmpty()) {
            boolean needToSwap;
            do{
                needToSwap = false;
                Link current = head;
                while (current.next != null){
                    if (current.keparahan > current.next.keparahan){
                        this.swap(current, current.next);
                        needToSwap = true;
                    }
                    current = current.next;
                }
            }
            while(needToSwap);
        }
    }

    public void sortByWaktu() {
        if (!isEmpty()) {
            boolean needToSwap;
            do{
                needToSwap = false;
                Link current = head;
                while (current.next != null){
                    if (current.waktu < current.next.waktu){
                        this.swap(current, current.next);
                        needToSwap = true;
                    }
                    current = current.next;
                }
            }
            while(needToSwap);
        }
    }

    private void swap(Link a, Link b){
        String namaTemp = a.namaPasien;
        int keparahanTemp = a.keparahan;
        int waktuTemp = a.waktu;
        a.waktu = b.waktu;
        a.keparahan = b.keparahan;
        a.namaPasien = b.namaPasien;
        b.waktu = waktuTemp;
        b.keparahan = keparahanTemp;
        b.namaPasien = namaTemp;
    }

    public void dequeue() {
        if (!isEmpty()) {
            Link current = tail;
            if (current == head) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    public String getNameSaatIni(){
        if (!isEmpty()) {
            return  tail.namaPasien;
        }
        return "tidak ada";
    }

    public int getKeparahanSaatIni(){
        if (!isEmpty()) {
            return  tail.keparahan;
        }
        return 0;
    }

    public void readData() {
        if (!isEmpty()) {
            Link current = tail;
            while (current != null) {
                current.printData();
                current = current.prev;
            }
        }else{
            System.out.println("belum ada antrian");
        }
    }

    public ArrayList getFmt() {
        ArrayList<String> fmt = new ArrayList<String>();
        if (!isEmpty()) {
            Link current = tail;
            while (current != null) {
                fmt.add(current.seekFmt());
                current = current.prev;
            }
        }
        return fmt;
    }
}