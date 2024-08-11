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
    public static final Item FLINT_KNIFE = registerItem("flint_knife", new Item(new Item.Settings()));
    public static final Item FLINT_AXE = registerItem("flint_axe", new Item(new Item.Settings()));
    public static final Item FLINT_PICKAXE = registerItem("flint_pickaxe", new Item(new Item.Settings()));
    public static final Item FLINT_SHOVEL = registerItem("flint_shovel", new Item(new Item.Settings()));
    public static final Item FLINT_HOE = registerItem("flint_hoe", new Item(new Item.Settings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(FLINT_KNIFE);
        entries.add(FLINT_AXE);
        entries.add(FLINT_PICKAXE);
        entries.add(FLINT_SHOVEL);
        entries.add(FLINT_HOE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FlintKnife.MOD_ID, name), item);

    }

    public static void registerModItems() {
        FlintKnife.LOGGER.info("Registering Mod Items For " + FlintKnife.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
