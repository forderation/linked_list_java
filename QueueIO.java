import java.io.*;
import java.util.ArrayList;

public class QueueIO {
    public Queue fileQueue;
    public QueueIO() {
        fileQueue = new Queue();
    }

    public void readFile() {
        fileQueue = new Queue();
        String [] fmtText = new String[3];
        String text = null;
        try {
            FileReader fr = new FileReader("database.csv");
            BufferedReader br = new BufferedReader(fr);
            while ((text = br.readLine())!=null){
                fmtText = text.split(",");
                fileQueue.enqueue(fmtText[0],
                        Integer.parseInt(fmtText[1]),
                        Integer.parseInt(fmtText[2]));
            }
            br.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void writeFile(){
        try{
            ArrayList<String> fmt = fileQueue.getFmt();
            File flod = new File("database.csv");
            flod.delete();
            FileWriter fw = new FileWriter("database.csv",false);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0; i<fmt.size();i++){
                bw.write(fmt.get(i));
            }
            bw.close();
            readFile();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}