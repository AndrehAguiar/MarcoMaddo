import java.io.IOException;

public class JavaControleDeFluxoGAME {
    public static void main(String[] args) throws IOException {

        System.out.print("Digite uma das letras da palavra Aplicativos: ---> ");
        int codASCII = System.in.read();

        switch ((char) codASCII){
            case 'a':
            case 'p':
            case 'l':
            case 'i':
            case 'c':
            case 't':
            case 'v':
            case 'o':
            case 's':
            case 'A':
            case 'P':
            case 'L':
            case 'I':
            case 'C':
            case 'T':
            case 'V':
            case 'O':
            case 'S':
                System.out.println("Opa, parabéns!!!");
                System.out.println("Código da Tecla: " + codASCII);
                System.out.println("Letra digitada: " + (char) codASCII);
                break;
            default:
                System.out.println("Letra digitada não pertence à palavra Aplicativos");
        }

    }
}
