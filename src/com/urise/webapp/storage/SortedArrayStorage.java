package com.urise.webapp.storage;


import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        int rindex = -index-1;
        if (index>0) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        }
        else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        }
        else if(size!=0) {
                if (index<0){
                    System.arraycopy(storage,rindex,storage,rindex+1,size-rindex);
                    storage[rindex]=r;
                    size++;
                }
        }
        else{
            storage[size]=r;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index<0) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            System.arraycopy(storage,index+1,storage,index,size-index-1);
            storage[size-1]=null;
            size--;
        }

    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        int result =Arrays.binarySearch(storage, 0, size, searchKey);
        return result;
    }
}
