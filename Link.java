class Link{
    Link next, prev;
    int keparahan, waktu;
    String namaPasien;
    public Link(String namaPasien, int keparahan, int waktu)
    {
        this.namaPasien = namaPasien;
        this.keparahan = keparahan;
        this.waktu = waktu;
    }
    void printData(){
        String grafik = "";
        for(int i=0 ; i<keparahan; i++){
            grafik += "*";
        }
        System.out.println(grafik+
                "("+keparahan +")"
                + "\t |nama pasien: "+namaPasien+
                " |waktu: " + waktu);
    }
    String seekFmt(){
        return (namaPasien+","+keparahan+","+waktu+"\n");
    }
}