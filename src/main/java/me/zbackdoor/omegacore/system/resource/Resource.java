package me.zbackdoor.omegacore.system.resource;

import java.io.File;

/**
 * A loaded resource.
 *
 * @author zBackDo_or_
 * @version 1.2
 */
public interface Resource extends ResourceSection {

    /**
     * @return the resource's file.
     */
    File getFile();

    /**
     * @return the resource's reference.
     *
     * @see ResourceReference
     */
    ResourceReference getReference();

    /**
     * @return handler responsible for the resource.
     */
    ResourceHandler getHandler();

}