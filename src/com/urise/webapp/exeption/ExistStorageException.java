package com.urise.webapp.exeption;

/**
 * Created by superman on 08.10.17.
 */
public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Resume " + uuid + " already exist", uuid);
    }
}
