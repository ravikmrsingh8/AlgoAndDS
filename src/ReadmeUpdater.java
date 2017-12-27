import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ReadmeUpdater {
    private static final String _$ = File.separator;
    private static final Map<String, List<String>> files = new LinkedHashMap<>();
    private static final String path = "src" + _$ + "com" + _$ + "example";

    public static void main(String[] args) throws IOException {
        parseDirectories();
        updateReadMe();
    }

    private static void updateReadMe() throws IOException {

        BufferedWriter br = new BufferedWriter(new FileWriter("./README.md"));

        files.forEach((cat, files) -> {
            StringBuilder sb = new StringBuilder();
            sb.append("|" + cat + "|  |  |  |" + "\n" + "|-----------------|--|--|--|\n");
            for (int i = 0; i < files.size(); i++) {
                if (i % 4 == 0) sb.append("|");
                String filePath = (path + _$ + cat + _$ + files.get(i)).replaceAll("\\\\", "/");
                sb.append((i + 1) + ". [" + files.get(i) + "](" + filePath + ")" + "|");
                if ((i + 1) % 4 == 0) sb.append("\n");
            }
            System.out.println(sb);
            try {
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

            String category = pathStr.substring(index, pathStr.indexOf(fileName) - 1);
            category.replace("\\", "/");

            List<String> jFiles = files.get(category);
            if (jFiles == null) {
                jFiles = new ArrayList<>();
            }
            jFiles.add(fileName);
            files.put(category, jFiles);
        });
    }

}
