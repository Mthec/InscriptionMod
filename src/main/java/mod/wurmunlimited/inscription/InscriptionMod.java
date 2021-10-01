package mod.wurmunlimited.inscription;

import org.gotti.wurmunlimited.modloader.classhooks.HookManager;
import org.gotti.wurmunlimited.modloader.interfaces.*;

import java.lang.reflect.Method;
import java.util.logging.Logger;

public class InscriptionMod implements WurmServerMod, Initable {
    private static final Logger logger = Logger.getLogger(InscriptionMod.class.getName());

    @Override
    public void init() {
        HookManager manager = HookManager.getInstance();

        manager.registerHook("com.wurmonline.server.items.InscriptionData",
                "containsIllegalCharacters",
                "(Ljava/lang/String;)Z",
                () -> this::containsIllegalCharacters);
    }

    @SuppressWarnings("SuspiciousInvocationHandlerImplementation")
    Object containsIllegalCharacters(Object o, Method method, Object[] args) {
        return false;
    }
}
