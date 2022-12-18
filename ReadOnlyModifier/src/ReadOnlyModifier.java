import java.io.File;
import java.io.IOException;
public class ReadOnlyModifier {

    public static void main(String[] args) {
        // Define the path to the folder
        String folderPath = "C:\\Users\\Beqir\\Desktop\\NFT\\AlienNFT\\node_modules";

        // Create a File object for the folder
        File folder = new File(folderPath);

        // Check if the current process has write permission for the folder
        if (!folder.canWrite()) {
            System.out.println("Error: Current process does not have write permission for folder: " + folder.getAbsolutePath());
            return;
        }

        // Modify the read-only attribute for the folder and its subfolders and files
        modifyReadOnlyAttribute(folder);
    }

    public static void modifyReadOnlyAttribute(File file){
        // Check if the current process has write permission for the file or folder
        if (!file.canWrite()) {
            System.out.println("Error: Current process does not have write permission for file or folder: " + file.getAbsolutePath());
            return;
        }
      file.setReadOnly();

        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    modifyReadOnlyAttribute(child);
                }
            }
        }
    }
}