package com.urise.webapp.storage;


import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{


    @Override
    protected void insertElement(Resume r, int index) {
        int rindex = -index-1;
        System.arraycopy(storage,rindex,storage,rindex+1,size-rindex);
        storage[rindex]=r;
        storage[size]=r;

    }

    @Override
    protected void fillDeletedElement(int index) {
        System.arraycopy(storage,index+1,storage,index,size-index-1);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        int result =Arrays.binarySearch(storage, 0, size, searchKey);
        return result;
    }
}
