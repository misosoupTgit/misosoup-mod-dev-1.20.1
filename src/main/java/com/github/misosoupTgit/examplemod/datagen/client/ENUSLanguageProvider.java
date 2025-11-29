package com.github.misosoupTgit.examplemod.datagen.client;

import com.github.misosoupTgit.examplemod.ExampleMod;
import com.github.misosoupTgit.examplemod.block.ExampleBlocks;
import com.github.misosoupTgit.examplemod.item.ExampleItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, ExampleMod.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(ExampleItems.EXAMPLE_ITEM, "Example Item");
        addItem(ExampleItems.EXAMPLE_ITEM_EXTEND, "Example Item Extend");
        add("creativetabs.example_tab", "Example Tab");
        addBlock(ExampleBlocks.EXAMPLE_BLOCK, "Example Block");
    }
}
