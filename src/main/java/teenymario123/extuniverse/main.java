package teenymario123.extuniverse;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import teenymario123.extuniverse.proxy.*;
import org.apache.logging.log4j.*;
import net.minecraft.creativetab.*;
import net.minecraftforge.fml.common.event.*;
import teenymario123.extuniverse.objects.tabs.*;
import teenymario123.extuniverse.util.ref;

@Mod(modid = ref.MOD_ID, version = ref.VERSION, name = ref.NAME)
public class main {

    @Instance
    public static main instance;
    @SidedProxy(clientSide = ref.CLIENT_PROXY_CLASS, serverSide = ref.COMMON_PROXY_CLASS)
    public static commonProxy proxy;
    public static Logger logger;
    public static final CreativeTabs ENGINES_TAB;
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        main.logger = event.getModLog();
        main.proxy.preInit(event);
    }
    
    @EventHandler
    public void init(final FMLInitializationEvent e) {
        main.proxy.init(e);
    }
    
    @EventHandler
    public void postInit(final FMLPostInitializationEvent e) {
        main.proxy.postInit(e);
    }
    
    @EventHandler
    public void serverInit(final FMLServerStartingEvent event) {
    }
    
    static {
        ENGINES_TAB = new engines();
    }
}
