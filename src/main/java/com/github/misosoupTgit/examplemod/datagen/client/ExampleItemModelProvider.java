package com.github.misosoupTgit.examplemod.datagen.client;

import com.github.misosoupTgit.examplemod.ExampleMod;
import com.github.misosoupTgit.examplemod.item.ExampleItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ExampleItemModelProvider extends ItemModelProvider {
    public ExampleItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ExampleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ExampleItems.EXAMPLE_ITEM.get());
        basicItem(ExampleItems.EXAMPLE_ITEM_EXTEND.get());
    }
}
