public class InstrumentationAgent {
private static Instrumentation instrumentationObject = null;

public static void agentmain(final String agentArgs, final Instrumentation inst) {
instrumentationObject = inst;
classTransformer = new MyClassTransformer();
instrumentationObject.addTransformer(classTransformer, true);
}

…

public static void addConfiguration(String classToInstrument, String methodToInstrument) {
if (instrumentationObject != null) {
transformClass(classToInstrument, methodToInstrument, instrumentationObject);
} else {
LOGGER.info(“[Agent] ADD CONFIG: Instrument Object Not Initialized”);
}
}
}
