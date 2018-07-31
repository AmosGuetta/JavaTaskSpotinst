import java.util.HashMap;

class fileSystem {

    //Fields:
    private HashMap<String,fileSystemObjects> files;

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

    void delete(String name){
        fileSystemObjects fileSystemObjects = files.get(name);
        files.remove(name);
        ((directory) files.get(fileSystemObjects.parentDir)).delete(name);
    }

    void showFileSystem(){
        files.get("root").printFileSystemObjects(" ");
    }


     //Helper function:
    private void addToParentDirectory(fileSystemObjects fileSystemObjects, String parentDirName) throws Exception{
        if(!files.containsKey(parentDirName))
            throw new Exception("Parent directory is not exist in System.");
        if(!(files.get(parentDirName) instanceof directory))
            throw new Exception("You can not add files or directory," + parentDirName +" is not a directory.");
        directory parentDirectory = (directory)files.get(parentDirName);
        parentDirectory.addToDirectory(fileSystemObjects);
    }

    private void checkUniquename(String name) throws Exception{
        if(files.containsKey(name))
            throw new Exception("This file name is already exist in the system.");
    }



}
