package io.papermc.paper.registry.data.dialog;

import com.google.common.base.Preconditions;
import io.papermc.paper.registry.data.dialog.body.DialogBody;
import io.papermc.paper.registry.data.dialog.input.DialogInput;
import java.util.Collections;
import java.util.List;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Unmodifiable;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public record DialogBaseImpl(
    Component title,
    @Nullable Component externalTitle,
    boolean canCloseWithEscape,
    boolean pause,
    DialogAfterAction afterAction,
    @Unmodifiable List<DialogBody> body,
    @Unmodifiable List<DialogInput> inputs
) implements DialogBase {

    public DialogBaseImpl {
        Preconditions.checkArgument(!pause || afterAction != DialogAfterAction.NONE, "Dialogs that pause the game must use after_action values that unpause it after user action!");
        body = List.copyOf(body);
        inputs = List.copyOf(inputs);
    }

    public static final class BuilderImpl implements DialogBase.Builder {

        private final Component title;
        private @Nullable Component externalTitle;
        private boolean canCloseWithEscape = true;
        private boolean pause = true;
        private DialogAfterAction afterAction = DialogAfterAction.CLOSE;
        private List<DialogBody> body = Collections.emptyList();
        private List<DialogInput> inputs = Collections.emptyList();

        public BuilderImpl(final Component title) {
            this.title = title;
        }

        @Override
        public @NonNull BuilderImpl externalTitle(final @Nullable Component externalTitle) {
            this.externalTitle = externalTitle;
            return this;
        }

        @Override
        public @NonNull BuilderImpl canCloseWithEscape(final boolean canCloseWithEscape) {
            this.canCloseWithEscape = canCloseWithEscape;
            return this;
        }

        @Override
        public @NonNull BuilderImpl pause(final boolean pause) {
            this.pause = pause;
            return this;
        }

        @Override
        public @NonNull BuilderImpl afterAction(final @NonNull DialogAfterAction afterAction) {
            this.afterAction = afterAction;
            return this;
        }

        @Override
        public @NonNull BuilderImpl body(final @NonNull List<? extends DialogBody> body) {
            this.body = List.copyOf(body);
            return this;
        }

        @Override
        public @NonNull BuilderImpl inputs(final @NonNull List<? extends DialogInput> inputs) {
            this.inputs = List.copyOf(inputs);
            return this;
        }

        @Override
        public @NonNull DialogBase build() {
            return new DialogBaseImpl(this.title, this.externalTitle, this.canCloseWithEscape, this.pause, this.afterAction, this.body, this.inputs);
        }
    }
}
