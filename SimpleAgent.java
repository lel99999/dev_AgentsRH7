public class SimpleAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        final SimpleClassTransformer transformer = new SimpleClassTransformer();
        inst.addTransformer(transformer);
    }
}