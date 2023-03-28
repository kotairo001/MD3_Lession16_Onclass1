import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input main file's path");
        String mainFile = input.nextLine();
        System.out.println("Input copy file's path");
        String copyFile = input.nextLine();
        writeFileText(copyFile, readFileText(mainFile));
        countCharacter(readFileText(mainFile));
    }
    public static List<String> readFileText(String filePath) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File(filePath);
            if(!file.exists()){
                throw new FileNotFoundException();
            } else {
                file.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line=br.readLine())!=null){
                list.add(line);
            }
            br.close();
        } catch (Exception e){
            System.err.println("File error");
        }
        return list;
    }
    public static void writeFileText(String filePath, List<String>list){
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i) + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void countCharacter(List<String>list) {
        int count =0;
        for (int i = 0; i < list.size(); i++) {
            count+=list.get(i).length();
        }
        System.out.println(count);
    }
}
