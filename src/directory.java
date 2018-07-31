import java.util.HashMap;
import java.util.Map.Entry;

public class directory extends fileSystemObjects {
    //Fields:
    protected HashMap<String,fileSystemObjects> subDirectoryAndSubFiles;

    //Constructor
    directory(String name, String parentDir) throws Exception {
        super(name, parentDir);
        this.subDirectoryAndSubFiles = new HashMap<>();
    }

    void addToDirectory(fileSystemObjects fileSystemObjects){
        subDirectoryAndSubFiles.put(fileSystemObjects.name,fileSystemObjects);
    }

    void delete(String name){
        subDirectoryAndSubFiles.remove(name);
    }

    @Override
    public void printFileSystemObjects(String str) {
        System.out.println(str + "Directory name: " + this.name + ", Creation Time: " + this.creationTime.toString() +"\n");
        for(Entry<String,fileSystemObjects>  entry : subDirectoryAndSubFiles.entrySet()){
            fileSystemObjects fileSystemObjects = entry.getValue();
            fileSystemObjects.printFileSystemObjects(str +  " ");
        }

    }
}
