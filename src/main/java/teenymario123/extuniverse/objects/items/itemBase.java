package teenymario123.extuniverse.objects.items;

import net.minecraft.item.*;
import teenymario123.extuniverse.util.interfaces.*;
import teenymario123.extuniverse.*;
import teenymario123.extuniverse.init.*;

public class itemBase extends Item implements IHasModel {

    public itemBase(String name) {
        this.setRegistryName(name);
        this.setTranslationKey(name);
        this.setCreativeTab(main.ENGINES_TAB);
        itemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
