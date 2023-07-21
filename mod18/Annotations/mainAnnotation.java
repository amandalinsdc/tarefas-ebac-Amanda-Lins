package mod18.Annotations;

public class mainAnnotation {
    public static void main(String[] args) {
        TabelaAnnotation classAnnotation = ClasseAnnotation.class.getAnnotation(TabelaAnnotation.class);
        if (classAnnotation != null) {
            System.out.println("Nome da Classe: " + classAnnotation.value());
            System.out.println("Tipos de motores: ");
            for (String motor : classAnnotation.motor()) {
                System.out.println("- " + motor);
            }
        }
    }
}
