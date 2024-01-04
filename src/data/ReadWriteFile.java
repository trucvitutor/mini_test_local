package data;

import model.CrispyFlour;
import model.Material;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static final String FILE = "src/util/doc.csv";

    //đọc file
//    private static List<String> fileMaterial(String file) {
//        List<String> stringList = new ArrayList<>();
//        try {
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            while (true) {
//                line = bufferedReader.readLine();
//                if (line == null) {
//                    break;
//                }
//                stringList.add(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return stringList;
//    }
//
//    //ghi file
//    private void writeFile(String file, List<String> stringList) {
//
//        try {
//            FileWriter fileWriter = new FileWriter(file);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            for (String s : stringList) {
//                bufferedWriter.write(s);
//                bufferedWriter.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }

//    public void ghiFile(List<Material> materials) {
//        List<String> stringList = new ArrayList<>();
//        for (Material s : materials) {
//            if(s instanceof CrispyFlour) {
//                stringList.add(((CrispyFlour) s).toVer());
//            }
//        }
//        writeFile(FILE, stringList);
//    }
//    public List<CrispyFlour> readCrispyFlour(){
//        List<CrispyFlour> crispyFlours=new ArrayList<>();
//        List<String> stringList=fileMaterial(FILE);
//        String[] temp;
//        for (String s: stringList) {
//            temp=s.split(",");
//            String id =temp[0];
//            String name = temp[1];
//            LocalDate manufacturingDate = LocalDate.parse(temp[2]);
//            int cost = Integer.parseInt(temp[3]);
//            int quantity = Integer.parseInt(temp[4]);
//            CrispyFlour crispyFlour =new CrispyFlour(id,name,manufacturingDate,cost,quantity);
//        }
//        return crispyFlours;
//    }
    public static void writeToFile(String path, List<Material> list) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Material> readDataFromFile(String path){
        List<Material> materials = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            materials = (List<Material>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return materials;
    }
}

