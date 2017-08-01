package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        storage=new Resume[10000];
        size =0;
    }

    public void update(Resume r){
        boolean flag = false;
        for (int i = 0; i <size ; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                storage[i]=r;
                flag=true;
                break;
            }
        }
        if (!flag)
        System.out.println("ERROR UPDATE");



    }

    public void save(Resume r) {
        storage[size]=r;

        if (storage[size]!=null)
                size++;
        else if (size==storage.length)
            System.out.println("SAVE ERROR OVERFLOW");
        else
            System.out.println("SAVE ERROR");

    }

    public Resume get(String uuid) {
        for (int i = 0; i <size ; i++) {
            Resume r = storage[i];
            if (r!=null) {
                if (uuid.equals(r.getUuid()))
                    return r;
            }
        }
        System.out.println("ERROR GET");
        return null;
    }

    public void delete(String uuid) {
        boolean flag = false;
        for (int i = 0; i <size ; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                System.arraycopy(storage, i + 1, storage, i, size - 1 - i);
                size--;
                flag =true;
                break;

            }
        }
            if (!flag)
                System.out.println("ERROR DELETE");

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll()
    {
        Resume[] resumes = new Resume[size];
        System.arraycopy(storage, 0, resumes, 0, resumes.length);
       return resumes;
    }

    public int size(){
        return size;
    }



}
