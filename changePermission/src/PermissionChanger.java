import java.io.File;
public class PermissionChanger {

    public static void main(String[] args) {
        // Replace "C:\\path\\to\\folder" with the actual path to the folder
        File folder = new File("C:\\Users\\Beqir\\Desktop\\NFT\"");

        // Set the desired permissions
        boolean readable = true;
        boolean writable = true;
        boolean executable = true;

        changePermissions(folder, readable, writable, executable);
    }

    public static void changePermissions(File file, boolean readable, boolean writable, boolean executable) {
        try {
            // Change the permissions of the file or folder
            file.setReadable(readable);
            file.setWritable(writable);
            file.setExecutable(executable);

            // If the file is a directory, recursively change the permissions of its subfolders and files
            if (file.isDirectory()) {
                File[] subfiles = file.listFiles();
                if (subfiles != null) {
                    for (File subfile : subfiles) {
                        changePermissions(subfile, readable, writable, executable);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error changing permissions: " + e.getMessage());
        }
    }
}