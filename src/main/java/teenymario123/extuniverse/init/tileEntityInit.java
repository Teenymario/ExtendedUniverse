package teenymario123.extuniverse.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import teenymario123.extuniverse.objects.TESR.*;
import teenymario123.extuniverse.objects.tileEntity.*;
import teenymario123.extuniverse.util.ref;

public class tileEntityInit {

    public static void registerTE() {
        GameRegistry.registerTileEntity(basicEngineTE.class, new ResourceLocation(ref.MOD_ID, "basic_engine"));
    }

    public static void registerTESR() {
        ClientRegistry.bindTileEntitySpecialRenderer(basicEngineTE.class, new basicEngineTESR());
    }

}
