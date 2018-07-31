public class Main {

    public static void main(String[] args) {
        try{

            fileSystem fileSystem = new fileSystem();
            // Building the hierarchical directories structure.
            fileSystem.addDirectory("root","Desktop");
            fileSystem.addDirectory("root","Development");
            fileSystem.addDirectory("Desktop","Tests");
            fileSystem.addDirectory("Development","myFirstApp");
            fileSystem.addDirectory("Development","JavaProjects");
            fileSystem.addDirectory("Development","C_Projects");

            //Add files to directories
            fileSystem.addFile("Desktop","StudentProfilePicture",100);
            fileSystem.addFile("Desktop","CV",90);
            fileSystem.addFile("Tests","FileSystemTests",80);
            fileSystem.addFile("Tests","DataStructuresTests",70);


            fileSystem.addFile("myFirstApp","HelloWorld",60);
            fileSystem.addFile("JavaProjects","Server",50);
            fileSystem.addFile("C_Projects","clients",40);

            // showFileSystem function result.
            fileSystem.showFileSystem();


            System.out.println("------------------------------------- Delete Tests ------------------------------------- ");
            fileSystem.delete("Desktop");
            fileSystem.showFileSystem();

            System.out.println("------------------------------------- Add file and directory after remove Tests -------------------------------------");

            fileSystem.addFile("Tests","FileSystemTests",80);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
