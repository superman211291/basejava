package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by superman on 13.08.17.
 */
public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void clear() {

    }

    @Override
    public void save(Resume r) {

    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected int getindex(String uuid) {
        Resume searchkey = new Resume();
        searchkey.setUuid(uuid);
        return Arrays.binarySearch(storage,0,size,searchkey);
    }
}
