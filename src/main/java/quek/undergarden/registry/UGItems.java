package quek.undergarden.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import quek.undergarden.UndergardenMod;
import quek.undergarden.item.*;

public class UGItems {

    private static FabricItemSettings defaultSettings = new FabricItemSettings().group(UndergardenMod.group);

    public static final Item catalyst = new CatalystItem(new FabricItemSettings().group(UndergardenMod.group).maxDamage(3));
    public static final Item depthrock_pebble = new PebbleItem(defaultSettings);
    public static final Item smogstem_stick = new Item(defaultSettings);
    public static final Item twistytwig = new Item(defaultSettings);
    public static final Item cloggrum_ingot = new Item(defaultSettings);
    public static final Item cloggrum_nugget = new Item(defaultSettings);
    public static final Item froststeel_ingot = new Item(defaultSettings);
    public static final Item froststeel_nugget = new Item(defaultSettings);
    public static final Item utheric_shard = new Item(defaultSettings);
    public static final Item utherium_ingot = new Item(defaultSettings);
    public static final Item utherium_nugget = new Item(defaultSettings);
    public static final Item regalium_ingot = new Item(new FabricItemSettings().group(UndergardenMod.group).rarity(Rarity.UNCOMMON));
    public static final Item regalium_nugget = new Item(new FabricItemSettings().group(UndergardenMod.group).rarity(Rarity.UNCOMMON));
    public static final Item smogstem_torch = new WallStandingBlockItem(UGBlocks.smogstem_torch, UGBlocks.smogstem_wall_torch, defaultSettings);
    public static final Item ditchbulb = new Item(defaultSettings);
    public static final Item brute_tusk = new Item(defaultSettings);

    public static void registerAll() {
        registerItem("catalyst", catalyst);
        registerItem("depthrock_pebble", depthrock_pebble);
        registerItem("smogstem_stick", smogstem_stick);
        registerItem("twistytwig", twistytwig);
        registerItem("cloggrum_ingot", cloggrum_ingot);
        registerItem("cloggrum_nugget", cloggrum_nugget);
        registerItem("froststeel_ingot", froststeel_ingot);
        registerItem("froststeel_nugget", froststeel_nugget);
        registerItem("utheric_shard", utheric_shard);
        registerItem("utherium_ingot", utherium_ingot);
        registerItem("utherium_nugget", utherium_nugget);
        registerItem("regalium_ingot", regalium_ingot);
        registerItem("regalium_nugget", regalium_nugget);
        registerItem("smogstem_torch", smogstem_torch);
        registerItem("ditchbulb", ditchbulb);
        registerItem("brute_tusk", brute_tusk);
    }

    private static void registerItem(String regName, Item item2Register) {
        Registry.register(Registry.ITEM, new Identifier(UndergardenMod.MODID, regName), item2Register);
    }
}
