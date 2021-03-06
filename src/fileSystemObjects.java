import java.util.Date;

public abstract class fileSystemObjects {

    //Fields:
    String name;
    Date creationTime;
    String parentDir;

    //Constructor
    fileSystemObjects(String name, String parentDir) throws Exception{
        if(name.length() > 32)
            throw new Exception("The name length must be up to 32  characters");
        this.name = name;
        this.parentDir = parentDir;
        this.creationTime = new Date();
    }

    public abstract void printFileSystemObjects(String str);


}
