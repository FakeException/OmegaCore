package me.zbackdoor.omegacore.system.resource;

/**
 * @author zBackDo_or_
 * @version 1.0
 */
public interface ResourceLoadResultHandler {

    /**
     * @param resource the resource that is loaded.
     */
    void onComplete(Resource resource);

    /**
     * @param e exception thrown when attempting to load.
     */
    default void onFailure(Exception e) {}
}