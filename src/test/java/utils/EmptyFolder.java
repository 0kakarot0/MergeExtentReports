package utils;

import java.io.File;

public class EmptyFolder {

    public void clearFolder(String folderPath) {
        try {
            File folder = new File(folderPath);

            // Check if the folder exists
            if (folder.exists()) {
                // List all files and subdirectories in the folder
                File[] files = folder.listFiles();

                // Delete each file and subdirectory
                if (files != null) {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            // Recursive call to clear subdirectories
                            clearFolder(file.getAbsolutePath());
                        } else {
                            // Delete the file
                            if (!file.delete()) {
                                System.err.println("Failed to delete file: " + file.getAbsolutePath());
                            }
                        }
                    }
                }

                // Delete the empty folder
//                if (folder.delete()) {
////                    System.out.println("Deleted folder: " + folder.getAbsolutePath());
//                } else {
//                    System.err.println("Failed to delete folder: " + folder.getAbsolutePath());
//                }
            } else {
                System.out.println("Folder does not exist: " + folderPath);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
