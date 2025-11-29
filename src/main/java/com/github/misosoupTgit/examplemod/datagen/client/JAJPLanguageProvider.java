package com.github.misosoupTgit.examplemod.datagen.client;

import com.github.misosoupTgit.examplemod.ExampleMod;
import com.github.misosoupTgit.examplemod.block.ExampleBlocks;
import com.github.misosoupTgit.examplemod.item.ExampleItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, ExampleMod.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(ExampleItems.EXAMPLE_ITEM, "例のアイテム");
        addItem(ExampleItems.EXAMPLE_ITEM_EXTEND, "例の拡張アイテム");
        add("creativetabs.example_tab", "例のタブ");
        addBlock(ExampleBlocks.EXAMPLE_BLOCK, "例のブロック");
    }
}
