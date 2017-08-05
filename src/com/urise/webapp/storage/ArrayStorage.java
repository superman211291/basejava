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
        int result = avalible(r);
       if (result!=-1){
           storage[result]=r;
       }
       else
           System.out.println("UPDATE ERROR");
    }

    public void save(Resume r) {
       if (absence(r)){
           storage[size]=r;
           size++;
       }
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
        int result = absence(uuid);
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
            if (storage[i]==r)
                return i;
        }
        return -1;
    }
    private boolean absence(Resume r){
        for (int i = 0; i <size ; i++) {
            if (storage[i]==r){
                return false;
            }
        }
        return true;
    }
    private int absence(String uuid){
        for (int i = 0; i <size ; i++) {
            if (uuid.equals(storage[i].getUuid()))
                return i;
        }
        return -1;
    }




}
