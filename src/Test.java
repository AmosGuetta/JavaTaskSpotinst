import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws Exception {

        fileSystem fileSystem = new fileSystem();
        String parentDirName, name;
        int size, option;
        Scanner input = new Scanner(System.in);


        System.out.println("You are at the root directory, choose a function to operate");

        while (true) {
            System.out.println("addFile         -      [1]");
            System.out.println("addDirectory    -      [2]");
            System.out.println("deleteFile      -      [3]");
            System.out.println("showFileSystem  -      [4]");
            System.out.println("Exit            -      [5]");
            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter the parent directory name: ");
                    parentDirName = input.next();
                    System.out.println("Enter the file name: ");
                    name = input.next();
                    System.out.println("Enter the file size: ");
                    size = Integer.parseInt(input.next());
                    fileSystem.addFile(parentDirName, name, size);
                    break;
                case 2:
                    System.out.println("Enter the parent directory name: ");
                    parentDirName = input.next();
                    System.out.println("Enter the directory name: ");
                    name = input.next();
                    fileSystem.addDirectory(parentDirName, name);
                    break;
                case 3:
                    System.out.println("Enter the file name or directory name you want to delete");
                    name = input.next();
                    fileSystem.delete(name);
                    break;
                case 4:
                    fileSystem.showFileSystem();
                    break;
                case 5:
                    input.close();
                    return;
                default:
                    System.out.println("There is no such an option, choose again: ");
                    break;
            }
        }
    }


}
