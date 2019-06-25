package me.zbackdoor.omegacore.system.register;

/**
 * The {@link Registrable} interface is a marker for all registrable classes.
 *
 * @author zBackDo_or_
 */
public interface Registrable {

    void register();

    /**
     * Called when a registrable object has been registered.
     */
    default void onRegister() {}

    /**
     * Called when a registrable object has been unregistered.
     */
    default void onUnregister() {}
}