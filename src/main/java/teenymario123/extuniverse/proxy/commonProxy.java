package teenymario123.extuniverse.proxy;

import net.minecraftforge.fml.common.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.event.*;
import net.minecraft.block.*;
import net.minecraftforge.fml.common.eventhandler.*;

@Mod.EventBusSubscriber
public class commonProxy {

    public void registerItemRenderer(Item item, int meta, String id) {
    }
    
    public void preInit(FMLPreInitializationEvent e) {
    }
    
    public void init(FMLInitializationEvent e) {
    }
    
    public void postInit(FMLPostInitializationEvent e) {
    }
    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    }
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    }
}
