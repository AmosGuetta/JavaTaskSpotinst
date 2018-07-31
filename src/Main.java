public class Main {

    public static void main(String[] args) {
        try{
            fileSystem fileSystem = new fileSystem();


            fileSystem.addDirectory("root","Desktop");
            fileSystem.addDirectory("root","Development");
            fileSystem.addDirectory("Desktop","Tests");
            fileSystem.addDirectory("Development","myFirstApp");
            fileSystem.addDirectory("Development","JavaProjects");
            fileSystem.addDirectory("Development","C_Projects");

            fileSystem.addFile("Desktop","StudentProfilePicture",100);
            fileSystem.addFile("Desktop","CV",90);
            fileSystem.addFile("Tests","FileSystemTests",80);
            fileSystem.addFile("Tests","DataStructuresTests",70);


            fileSystem.addFile("myFirstApp","HelloWorld",60);
            fileSystem.addFile("JavaProjects","Server",50);
            fileSystem.addFile("C_Projects","clients",40);


            fileSystem.showFileSystem();


            System.out.println("--------------------------------Delete--------------------------------------");

            fileSystem.delete("FileSystemTests");
            fileSystem.delete("Server");
            /*
            fileSystem.showFileSystem();
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
