package com.urise.webapp.exeption;

/**
 * Created by superman on 08.10.17.
 */
public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }
}
