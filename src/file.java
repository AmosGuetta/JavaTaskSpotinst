public class file extends fileSystemObjects {

    //Fields:
     private int size;

    //Constructor
    file(String name, String parentDir, int size) throws Exception {
        super(name, parentDir);
        if (size < 1)
            throw new Exception("File size must be positive");
        this.size = size;
    }

    @Override
    public void printFileSystemObjects(String str) {
        System.out.println(str + "File name: " + this.name + ", Size: " + this.size + ", Creation Time: " + this.creationTime.toString() +"\n");

    }
}