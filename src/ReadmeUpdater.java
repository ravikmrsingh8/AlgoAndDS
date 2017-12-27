import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ReadmeUpdater {
    private static final String _$ = File.separator;
    private static final Map<String, List<String>> files = new LinkedHashMap<>();
    private static final String path = "."+_$+"src"+_$+"com"+_$+"example"+_$;

    public static void main(String[] args) throws IOException {
        parseDirectories();
        updateReadMe();
    }

    private static void updateReadMe() throws IOException {

        BufferedWriter br = new BufferedWriter(new FileWriter("./README.md"));
        files.forEach((cat, files)->{
            try {
                System.out.println("<h2>"+cat+"</h2>");
                br.write("<h2>"+cat+"</h2>");
                br.newLine();
                for(String file: files) {
                    System.out.println("\t- ["+file+"]("+path+cat+file+")");
                    br.write("\t- "+file);
                    br.newLine();
                }
                ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        br.flush();
        br.close();
    }
    private static void parseDirectories() throws IOException {
        Files.walk(Paths.get(path)).filter(Files::isRegularFile).forEach((Path p) ->{
            String fileName = p.getFileName().toString();
            String pathStr = p.toString();
            int index = pathStr.indexOf(_$+"example")+ 9;

            String category = pathStr.substring(index, pathStr.indexOf(fileName));
            List<String> jFiles =  files.get(category);
            if(jFiles == null) {
                jFiles = new ArrayList<>();
            }
            jFiles.add(fileName);
            files.put(category, jFiles);
        });
    }

}
