package net.dofi.flintknife.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.dofi.flintknife.FlintKnife;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FLINT_KNIFE = registerItem(new Item(new Item.Settings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(FLINT_KNIFE);
    }

    private static Item registerItem(Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FlintKnife.MOD_ID, "flint_knife"), item);
    }

    public static void registerModItems() {
        FlintKnife.LOGGER.info("Registering Mod Items For " + FlintKnife.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
