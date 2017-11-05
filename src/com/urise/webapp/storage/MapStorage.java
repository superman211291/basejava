package com.urise.webapp.storage;

import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.UUID;

/**
 * Created by superman on 29.10.17.
 */
public class MapStorage extends AbstractStorage {

    private HashMap<String,Resume> resumeHashMap=new HashMap<>();

    @Override
    public void clear() {
        resumeHashMap.clear();
        super.clear();
    }

    @Override
    public void update(Resume r) {
        resumeHashMap.put(r.getUuid(),r);
        super.update(r);
    }

    @Override
    public Resume get(String uuid) {
        super.get(uuid);
        return resumeHashMap.get(uuid);
    }

    @Override
    public Resume[] getAll() {
        super.resumes= new Resume[resumeHashMap.size()];
        int i =0;
        for (Map.Entry<String,Resume> empty :resumeHashMap.entrySet()){
            super.resumes[i]=empty.getValue();
            i++;
        }
        return super.getAll();
    }

    @Override
    public void delete(String uuid) {
        if (resumeHashMap.containsKey(uuid))
            resumeHashMap.remove(uuid);
        else
            throw new NotExistStorageException(uuid);
        super.size--;

    }

    @Override
    protected int getIndex(String uuid) {
        int index = -1;
        try {
            if (resumeHashMap.containsKey(uuid))
                index=1;
        }
        catch (NullPointerException ex){

        }
        return index;
    }

    @Override
    protected void insertElement(Resume r, int index) {
        String uuid = r.getUuid();
        resumeHashMap.put(uuid,r);
    }

    @Override
    protected void fillDeletedElement(int index) {


    }
}
