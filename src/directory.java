import java.util.HashMap;
import java.util.Map.Entry;

public class directory extends fileSystemObjects {

    HashMap<String,fileSystemObjects> subDirectoryAndSubfiels;

    public directory(String name, String parentDir) throws Exception {
        super(name, parentDir);
        this.subDirectoryAndSubfiels = new HashMap<String,fileSystemObjects>();
    }

    public void addToDirectory(fileSystemObjects fileSystemObjects){
        subDirectoryAndSubfiels.put(fileSystemObjects.name,fileSystemObjects);
    }

    public void delete (String name){
        if(subDirectoryAndSubfiels.containsKey(name))
            subDirectoryAndSubfiels.remove(name);
    }


    @Override
    public void printFileSystemObjects(String str) {
        System.out.println(str + "Directory name: " + this.name + ", Creation Time: " + this.creationTime.toString() +"\n");
        for(Entry<String,fileSystemObjects>  entry : subDirectoryAndSubfiels.entrySet()){
            fileSystemObjects fileSystemObjects = entry.getValue();
            fileSystemObjects.printFileSystemObjects(str + "  ");
        }

    }
}
