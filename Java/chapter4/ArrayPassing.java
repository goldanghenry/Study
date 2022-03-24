public class ArrayPassing {
    static void replaceSpace(char args[]){
        for(int i=0;i<args.length;i++){
            if(args[i]==' ') args[i] = ',';
        }
    }
    static void printArray(char args[]){
        for(int i=0;i<args.length;i++){
            System.out.print(args[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        char a [] = {'T','h','i','s',' ', 'a', ' ', 'p', 'e','n','c','i','l','.'};

        printArray(a);
        replaceSpace(a);
        printArray(a);
    }
}
