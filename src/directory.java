import java.util.HashMap;
import java.util.Map.Entry;

public class directory extends fileSystemObjects {

    //Fields:
    private  HashMap<String,fileSystemObjects> subDirectoryAndSubFiles;

    //Constructor
    public directory(String name, String parentDir) throws Exception {
        super(name, parentDir);
        this.subDirectoryAndSubFiles = new HashMap<String,fileSystemObjects>();
    }

    public void addToDirectory(fileSystemObjects fileSystemObjects){
        subDirectoryAndSubFiles.put(fileSystemObjects.name,fileSystemObjects);
    }

    public void delete (String name){
        if(subDirectoryAndSubFiles.containsKey(name))
            subDirectoryAndSubFiles.remove(name);
    }


    @Override
    public void printFileSystemObjects(String str) {
        System.out.println(str + "Directory name: " + this.name + ", Creation Time: " + this.creationTime.toString() +"\n");
        for(Entry<String,fileSystemObjects>  entry : subDirectoryAndSubFiles.entrySet()){
            fileSystemObjects fileSystemObjects = entry.getValue();
            fileSystemObjects.printFileSystemObjects(str + "  ");
        }

    }
}
