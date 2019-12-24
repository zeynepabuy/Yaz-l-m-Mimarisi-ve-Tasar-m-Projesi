public class Approve {
    public static void main(String[] args) {
        Context context=new Context();
        context.setCommunicate(new Read());
        context.sendInformation();
        context.setCommunicate(new Finalize());
        context.sendInformation();
    }
}
