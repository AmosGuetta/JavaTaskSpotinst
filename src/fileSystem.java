import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class fileSystem {

    //Fields:
    private HashMap<String,fileSystemObjects> files;
    private List<fileSystemObjects> deleteFilesList = new ArrayList<>();

    //Constructor
    fileSystem() throws Exception{
        this.files = new HashMap<>();
        directory root = new directory("root", null);
        this.files.put("root", root);
    }

     void addFile(String parentDirName, String fileName, Integer fileSize) throws Exception{
        checkUniquename(fileName);
        file fileToAdd = new file(fileName,parentDirName,fileSize);
        addToParentDirectory(fileToAdd,parentDirName);
        files.put(fileToAdd.name,fileToAdd);
     }

    void addDirectory(String parentDirName, String dirName) throws Exception{
        checkUniquename(dirName);
        directory directoryToAdd = new directory(dirName,parentDirName);
        addToParentDirectory(directoryToAdd,parentDirName);
        files.put(directoryToAdd.name,directoryToAdd);
    }

    void delete(String name) throws Exception{
        if (name == "root")
            throw new Exception("You can not delete the root directory");
        allFilesToRemove(name);
        fileSystemObjects fileSystemObjects = files.get(name);
        if(fileSystemObjects != null) {
            ((directory) files.get(fileSystemObjects.parentDir)).delete(name);
            for (int i = 0; i < deleteFilesList.size(); i++) {
                this.files.remove(deleteFilesList.get(i).name);
            }
            this.files.remove(name);
            deleteFilesList = new ArrayList<>();
        }

    }

    void showFileSystem(){
        files.get("root").printFileSystemObjects("  ");
    }


     //Helper function:
    private void addToParentDirectory(fileSystemObjects fileSystemObjects, String parentDirName) throws Exception{
        if(!files.containsKey(parentDirName))
            throw new Exception("Parent directory is not exist in System.");
        if(!(files.get(parentDirName) instanceof directory))
            throw new Exception("You can not add files or directory," + parentDirName + " is not a directory.");
        directory parentDirectory = (directory)files.get(parentDirName);
        parentDirectory.addToDirectory(fileSystemObjects);
    }

    private void checkUniquename(String name) throws Exception{
        if(files.containsKey(name))
            throw new Exception("This file name is already exist in the system.");
    }

    private void allFilesToRemove(String name) throws Exception {
        for (Map.Entry<String, fileSystemObjects> entry : files.entrySet()) {
            fileSystemObjects myFiles = entry.getValue();
            if (myFiles.parentDir != null)
                if (myFiles.parentDir.equals(name)) {
                    deleteFilesList.add(myFiles);
                    allFilesToRemove(myFiles.name);
                }
        }
    }



}
