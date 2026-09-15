package io.papermc.paper.registry.data.dialog;

import io.papermc.paper.registry.PaperRegistryBuilder;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.data.dialog.type.DialogType;
import io.papermc.paper.registry.data.util.Conversions;
import io.papermc.paper.registry.set.RegistryValueSetBuilder;
import io.papermc.paper.registry.set.RegistryValueSetBuilderImpl;
import net.minecraft.server.dialog.CommonDialogData;
import net.minecraft.server.dialog.Dialog;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import static io.papermc.paper.registry.data.util.Checks.asArgument;
import static io.papermc.paper.registry.data.util.Checks.asConfigured;

public class PaperDialogRegistryEntry implements DialogRegistryEntry {

    protected @Nullable DialogBase dialogBase;
    protected @Nullable DialogType dialogType;

    protected final Conversions conversions;

    public PaperDialogRegistryEntry(
        final Conversions conversions,
        final @Nullable Dialog internal
    ) {
        this.conversions = conversions;
        if (internal == null) return;

        final CommonDialogData common = internal.common();
        this.dialogBase = conversions.convert(common, PaperDialogCodecs.DIALOG_BASE_CODEC, CommonDialogData.MAP_CODEC.codec());

        this.dialogType = PaperDialogs.extractType(internal, conversions);
    }

    @Override
    public @NonNull DialogBase base() {
        return asConfigured(this.dialogBase, "dialogBase");
    }

    @Override
    public @NonNull DialogType type() {
        return asConfigured(this.dialogType, "dialogType");
    }

    public static final class PaperBuilder extends PaperDialogRegistryEntry implements Builder, PaperRegistryBuilder<Dialog, io.papermc.paper.dialog.Dialog> {

        public PaperBuilder(final Conversions conversions, final @Nullable Dialog internal) {
            super(conversions, internal);
        }

        @Override
        public @NonNull RegistryValueSetBuilder<io.papermc.paper.dialog.Dialog, Builder> registryValueSet() {
            return new RegistryValueSetBuilderImpl<>(RegistryKey.DIALOG, this.conversions);
        }

        @Override
        public @NonNull Builder base(final @NonNull DialogBase dialogBase) {
            this.dialogBase = asArgument(dialogBase, "dialogBase");
            return this;
        }

        @Override
        public @NonNull Builder type(final @NonNull DialogType dialogType) {
            this.dialogType = asArgument(dialogType, "dialogType");
            return this;
        }

        @Override
        public @NonNull Dialog build() {
            return PaperDialogs.constructDialog(this.base(), this.type(), this.conversions);
        }
    }
}
