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
        for (int i = 0; i <size ; i++) {
            storage[i]=null;
        }
        size =0;
    }

    public void update(Resume r){
        int result = avalible(r);
       if (result!=-1){
           storage[result]=r;
       }
       else
           System.out.println("UPDATE ERROR");
    }

    public void save(Resume r) {
        boolean flag = false;
       if (avalible(r)==-1&&size!=storage.length){
           storage[size]=r;
           size++;
           flag=true;
       }
       if (size==storage.length)
           System.out.println("Save overflow error");
       else if (!flag)
           System.out.println("SAVE ERROR");
    }

    public Resume get(String uuid) {
        int result = avalible(uuid);
       if (result!=-1)
           return storage[result];
       else {
           System.out.println("GET ERROR");
           return null;

       }
    }

    public void delete(String uuid) {
        int result = avalible(uuid);
        if (result!=-1){
            System.arraycopy(storage,result+1,storage,result,size-1-result);
            size--;
        }
        else
            System.out.println("DELETE ERROR");
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

    private int avalible(Resume r){
        for (int i = 0; i <size ; i++) {
            if (r.getUuid().equals(storage[i].getUuid()))
                return i;
        }
        return -1;
    }
    private int avalible(String uuid){
        for (int i = 0; i <size ; i++) {
            if (uuid.equals(storage[i].getUuid()))
                return i;
        }
        return -1;
    }



}
