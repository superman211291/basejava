package com.urise.webapp.storage;


import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{
    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        }
        else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        }
        else if(size!=0) {
            for (int i = 0; i <size ; i++) {
                if (r.compareTo(storage[i])<=0){
                    System.arraycopy(storage,i,storage,i+1,size-i);
                    storage[i+1]=r;
                    size++;
                    break;
                }

            }
        }
        else{
            storage[size]=r;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        super.delete(uuid);

    }

    @Override
    public Resume[] getAll() {
       return super.getAll();
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
