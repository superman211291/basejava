package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int count = 0;

    public void clear() {
        storage=new Resume[10000];
        count =0;
    }

    public void save(Resume r) {
        storage[count]=r;
        count++;
    }

    public Resume get(String uuid) {
        for (int i=0;i<storage.length;i++){
            if (uuid.equals(storage[i].getUuid())){
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i <count ; i++) {
            if (uuid.equals(storage[i].getUuid())){
                System.arraycopy(storage, i + 1, storage, i, count - 1 - i);

            }

        }
        count--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll()
    {
        Resume[] resumes = new Resume[count];
        System.arraycopy(storage, 0, resumes, 0, resumes.length);
       return resumes;
    }

    public int size(){
        return count;
    }
}
