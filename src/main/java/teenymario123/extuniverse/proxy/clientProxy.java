package teenymario123.extuniverse.proxy;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraftforge.client.model.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.client.model.obj.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;
import teenymario123.extuniverse.util.ref;

@EventBusSubscriber(Side.CLIENT)
public class clientProxy extends commonProxy {

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }
    
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        OBJLoader.INSTANCE.addDomain(ref.MOD_ID);
    }
    
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {

    }

}
