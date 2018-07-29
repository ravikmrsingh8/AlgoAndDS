import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ReadmeUpdater {
    private static final String _$ = File.separator;
    private static final Map<String, List<String>> files = new LinkedHashMap<>();
    private static final String path = "src" + _$ + "com" + _$ + "example";
    private static final Set<String> categories = new HashSet<>(Arrays.asList( new String[]{
           "Amazon", "Bit", "DP", "Array", "List", "Graph", "Stack", "Queue", "Tree", "Trie", "Map", "Set", "Java", "Design", "Heap", "String", "Deque" , "Sort", "Problems", "Misc"
    }));
    public static void main(String[] args) throws IOException {
        parseDirectories();
        updateReadMe();
    }

    private static void updateReadMe() throws IOException {

        BufferedWriter br = new BufferedWriter(new FileWriter("./README.md"));

        files.forEach((cat, files) -> {
            StringBuilder sb = new StringBuilder();
            sb.append("\r\n#### ").append(cat).append("| \r\n");

            sb.append("|");
            files.forEach(file->{
                String filePath = file.replaceAll("\\\\", "/");
                sb.append("[" + file.substring(file.lastIndexOf("\\")+1) + "](" + filePath + ")");
                sb.append("|");

            });
            sb.append("\r\n");
            try {
                System.out.println(sb.toString());
                br.write(sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        br.flush();
        br.close();
    }

    private static void parseDirectories() throws IOException {
        Files.walk(Paths.get(path)).filter(Files::isRegularFile).forEach((Path p) -> {
            String fileName = p.getFileName().toString();
            String pathStr = p.toString();
            int index = pathStr.indexOf(_$ + "example" + _$) + 9;

            String[] packages = pathStr.substring(index, pathStr.indexOf(fileName) - 1).split("\\\\");

            categories.forEach(cat->{
                for(String module : packages){
                    if(module.toLowerCase().trim().equals(cat.toLowerCase())){
                        List<String> jFiles = files.get(cat);
                        if (jFiles == null) {
                            jFiles = new ArrayList<>();
                        }
                        jFiles.add(pathStr);
                        files.put(cat, jFiles);
                        break;
                    }
                }
            });
        });

    }

}
