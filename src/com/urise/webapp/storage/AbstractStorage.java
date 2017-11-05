package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

/**
 * Created by superman on 29.10.17.
 */
public abstract class AbstractStorage implements Storage{
    protected Resume[] resumes;
    protected int size = 0;


    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0)
            throw new NotExistStorageException(r.getUuid());

    }



    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0)
            throw new ExistStorageException(r.getUuid());
        insertElement(r, index);
        size++;

    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return null;
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else
            fillDeletedElement(index);
        size--;

    }

    @Override
    public Resume[] getAll() {
        return resumes;
    }

    @Override
    public int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);
    protected abstract void insertElement(Resume r, int index);
    protected abstract void fillDeletedElement(int index);


}

