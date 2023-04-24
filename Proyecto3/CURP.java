import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class CURP {
  
    public static void main(String[] args) throws IOException {

        /* Parámetro "n" que dice cuántos CURP por segundo se generan */
        int num = Integer.valueOf(args[0]);

        FileWriter fileWriter = new FileWriter("curps.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        //Character c = args[1].charAt(0); //Esto pide la letra del sexo para filtrar curps

        //hacer un while que no se detenga
        boolean continuar = true;

        try {
            while (continuar) {
                /* Un ciclo de n CURPS por segundo */
                for(int i = 0; i < num; i++){
        
                    String curp = getCURP();
                    int partido = getPartido();
                    String linea = curp + "," + partido;

                    System.out.println(linea);
                    bufferedWriter.write(linea);
                    bufferedWriter.newLine();
                    
                }
                try {
                    Thread.sleep(1000); // Esperar un segundo
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                bufferedWriter.flush(); // vaciar el búfer antes de cerrar el archivo
            }
            continuar = false;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        /* //El iterator es como un comparador, lo dejo aqui por si sirve
        Iterator<String> itr = ListaCURP.iterator();
        
        while(itr.hasNext()){
            String auxCurp = itr.next();
                if(auxCurp.charAt(10) == c){
                        itr.remove();
                }
            
        }

        for (String s : ListaCURP){
            System.out.println(s);
        }
        
    System.out.println("\nCURPS filtrados");
        for (String s : ListaCURP){
            System.out.println(s);
        }*/
    }
 
    /* Método para generar CURPS de forma aleatoria */
    static String getCURP() {
        String Letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Numero = "0123456789";
        String Sexo = "HM";
        String Entidad[] = {"AS", "BC", "BS", "CC", "CS", "CH", "CL", "CM", "DF", "DG", "GT", "GR", "HG", "JC", "MC", "MN", "MS", "NT", "NL", "OC", "PL", "QT", "QR", "SP", "SL", "SR", "TC", "TL", "TS", "VZ", "YN", "ZS"};
        int indice;
        
        StringBuilder sb = new StringBuilder(18);
        
        for (int i = 1; i < 5; i++) {
            indice = (int) (Letra.length()* Math.random());
            sb.append(Letra.charAt(indice));        
        }
        
        for (int i = 5; i < 11; i++) {
            indice = (int) (Numero.length()* Math.random());
            sb.append(Numero.charAt(indice));        
        }
 
        indice = (int) (Sexo.length()* Math.random());
        sb.append(Sexo.charAt(indice));        
        
        sb.append(Entidad[(int)(Math.random()*32)]);
 
        for (int i = 14; i < 17; i++) {
            indice = (int) (Letra.length()* Math.random());
            sb.append(Letra.charAt(indice));        
        }
 
        for (int i = 17; i < 19; i++) {
            indice = (int) (Numero.length()* Math.random());
            sb.append(Numero.charAt(indice));        
        }
        
        return sb.toString();
    }  
    
    /* Método para seleccionar partidos políticos de forma aleatoria */
    static int getPartido() {
        String partidosPoliticos[] = {"PRI", "PAN", "PRD", "PT", "PVEM", "MC", "NA", "MORENA", "PES"};
        Random random = new Random();
        int indice = random.nextInt(9); 
        return indice;
    }
}